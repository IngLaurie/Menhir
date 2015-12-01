import java.util.*;

public abstract class Joueur {
//   /!\ GRAINES 
	private String nom;
	private int age;

	private int nombreDePointTotal;
	private ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();
	private int nbMenhirDuJoueur;
	protected int nbGraineDuJoueur; 
	private boolean actif;
	private int choixAction;
	//private int nbGraine;
	//private Joueur jQuiCommence;
	//private int cptLJ;
	//private int nbJoueur;

	

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

			System.out.println(c.afficherCarte() + " taper " + i);
			// travailler la méthode afficherCarte() de carte pour permettre l'affichage de chaque cartes des joueurs

			System.out.println(c.afficherCarte() + "\n taper " + i);
			i++;
		}
	}
	
	public int getNbGraineDuJoueur(){
		return nbGraineDuJoueur;
	}
	
	public void setNbGraineDuJoueur(int nbGraineDuJoueur, int nbAAjouterGraine){
		this.nbGraineDuJoueur = nbGraineDuJoueur + nbAAjouterGraine;
	}
	
	public int getNbMenhirDuJoueur(){
		return nbMenhirDuJoueur;
	}
	
	public void setNbMenhirDuJoueur(int nbMenhirDuJoueur, int nbAAjouterMenhir){
		this.nbMenhirDuJoueur = nbMenhirDuJoueur + nbAAjouterMenhir;
	}
	
	
	
	public ArrayList<Carte> getMainDuJoueur() {
		return this.mainDuJoueur;
	}

	//public abstract void jouerCarte(){
	public abstract void jouerCarte();
	
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
	
}
