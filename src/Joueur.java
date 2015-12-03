import java.util.*;

public abstract class Joueur {
//   /!\ GRAINES 
	private String nom;
	private int age;

	private int nombreDePointTotal;
	protected ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();
	private int nbMenhirDuJoueur;
	private int nbMenhirTotalDuJoueur;
	protected int nbGraineDuJoueur;
	private boolean actif;
	private int choixAction;

	

	// /!\ gérer pour 2 à 6 joueurs
	public Joueur(){
		System.out.println("Nom du joueur :");
		Scanner scanNom = new Scanner(System.in); //Créer une exception si on ne rentre pas des caractères
		String nomJPhysique = scanNom.nextLine();
		
		System.out.println("Age du joueur :");
		Scanner scanAge = new Scanner(System.in); //Créer une exception si on ne rentre pas un nombre
		int ageJoueurPhysique = scanAge.nextInt();
		
		this.age = ageJoueurPhysique;
		this.nom = nomJPhysique;
		//main = new ArrayList<Carte>();
		this.nbGraineDuJoueur = 0;
		this.nbMenhirDuJoueur = 0;
	}
	
	public void afficherMainJoueur(){
		int i = 1;
		for(Carte c: this.mainDuJoueur){
			// pour permettre au USER de faire afficher les valeurs de la carte

			System.out.println(c.getNom() + " taper " + i);
			// travailler la méthode afficherCarte() de carte pour permettre l'affichage de chaque cartes des joueurs

			//System.out.println(c.afficherCarte() + "\n taper " + i);
			i++;
			
			System.out.println(c.toString());
		}
	}
	
	public int getNbGraineDuJoueur(){
		return nbGraineDuJoueur;
	}
	
	public void setNbGraineDuJoueur(int nbGraineDuJoueur, int nbAAjouterGraine){
		this.nbGraineDuJoueur = nbGraineDuJoueur + nbAAjouterGraine;
	}
	
	public void setNbGraineDuJoueur(int nbGraineADonner){
		this.nbGraineDuJoueur = nbGraineADonner;
	}
	
	public int getNbMenhirDuJoueur(){
		return nbMenhirDuJoueur;
	}
	
	public void setNbMenhirDuJoueur(int nbMenhirDuJoueur, int nbAAjouterMenhir){
		this.nbMenhirDuJoueur = nbMenhirDuJoueur + nbAAjouterMenhir;
	}
	
	public void setNbMenhirTotalDuJoueur(int nbMenhirDuJoueur) {
		this.nbMenhirTotalDuJoueur = this.nbMenhirTotalDuJoueur + nbMenhirDuJoueur;
	}
	
	public int getNbMenhirTotalDuJoueur() {
		return this.nbMenhirTotalDuJoueur;
	}
	
		
	public ArrayList<Carte> getMainDuJoueur() {
		return this.mainDuJoueur;
	}

	//public abstract void jouerCarte(){
	public abstract void jouerCarte(Manche m, Partie p);
	public abstract void faireAction(Carte c, Manche m, Partie p);
	
	/*public void faireAction(){		
		
	}*/
	
	/*public String getJoueurDeDebut() {
		return jQuiCommence;
	}

	public void setJoueurDeDebut(String jQuiCommence) {
		this.jQuiCommence = jQuiCommence;
	}*/

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Joueur choisirJoueur(ArrayList<Joueur> listDeJoueur){
		int i = 0;
		
		for(Joueur j : listDeJoueur){
			System.out.println(j.nom + " taper " + i);
			i++;
		}
		Scanner scanJ = new Scanner(System.in);
		int choixJoueur = scanJ.nextInt();
		
		return listDeJoueur.get(choixJoueur);
	}
	
	public String getNom() {
		return nom;
	}
	
}
