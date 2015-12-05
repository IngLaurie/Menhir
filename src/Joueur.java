import java.util.*;

import org.omg.CORBA.portable.IndirectionException;
// NOTRE CONTEXT POUR LA STRATEGIE 
public abstract class Joueur implements Comparable<Joueur> {
//   /!\ GRAINES 
	protected String nom;
	protected int age;

	protected ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();
	protected int nbMenhirDuJoueur = 0;
	private int nbMenhirTotalDuJoueur = 0;
	protected int nbGraineDuJoueur = 0;
	//private boolean actif;
	//private int choixAction;
	private int nbChiens = 0;
	private boolean aDejaCommence = false;
	protected boolean isJoueurPhysique;

	

	// /!\ gérer pour 2 à 6 joueurs
	public Joueur(){
		this.nbGraineDuJoueur = 0;
		this.nbMenhirDuJoueur = 0;
		this.isJoueurPhysique = false;
	}
	
	public void afficherMainJoueur(){
		int i = 1;
		for(Carte c: this.mainDuJoueur){
			// pour permettre au USER de faire afficher les valeurs de la carte

			System.out.println("Carte " + i + " :");
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
	
	public void setNbGraineDuJoueur(int nbGraine){
		this.nbGraineDuJoueur = nbGraine;
	}
	
	public int getNbMenhirDuJoueur(){
		return nbMenhirDuJoueur;
	}
	
	public void setNbMenhirDuJoueur(int nbMenhirDuJoueur, int nbAAjouterMenhir){
		this.nbMenhirDuJoueur = nbMenhirDuJoueur + nbAAjouterMenhir;
	}
	
	public void setNbMenhirDuJoueur(int nbMenhir) {
		this.nbMenhirDuJoueur = nbMenhir;
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
	
	public boolean getADejaCommence() {
		return this.aDejaCommence;
	}
	
	public void setADejaCommence(boolean a) {
		this.aDejaCommence = a;
	}
	
	public int getNbChiens () {
		return this.nbChiens;
	}
	
	public void setNbChiens (int chiens) {
		this.nbChiens = chiens;
	}
	
	public void jouerCarte(Manche m, Partie p) {
		if (this.isJoueurPhysique) {
			System.out.println(+this.getNbGraineDuJoueur()+ " graines " +this.getNbMenhirDuJoueur()+ " ménhirs.\n");
			this.choisirCarte(m, p);
			}else{ // joueur virtuel joue
			//	if()
				//Context context = new Context(new OffensiveStrategy());
				//System.out.println(" " + context.executeStrategy());
			}
	}

	//public abstract void jouerCarte(){
	public void choisirCarte(Manche m, Partie p){
	//// déplacer JOUEUR ////
		
		System.out.println("\nChoisir une carte à jouer : ");
		this.afficherMainJoueur();
		// parcourir la liste et indiquer laquelle est choisie en fonction d'un indice
		Scanner scanCarte = new Scanner(System.in); // pour scanner l'indice de la carte choisie
		int choixCarte = scanCarte.nextInt();
		this.mainDuJoueur.get(choixCarte - 1).choisirAction(this, m, p);  // retourne une carte
	}
	

	
	//public void choisirAction(TaupeGeante c, Manche m, Partie p) {
		
	//}
	
	
	
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
				// /!\ nb 
				if(j.getNom() != this.getNom()){
					System.out.println(+i+ " pour choisir " +j.nom+ ", " +j.getNbGraineDuJoueur()+ " graines et " +j.getNbMenhirDuJoueur()+ " ménhirs." );
										
				}
				i++;
			}
	
		
		
		Scanner scanJ = new Scanner(System.in);
		int choixJoueur = scanJ.nextInt();
		
		if (listDeJoueur.get(choixJoueur) == this) {
			System.out.println("Vous vous êtes choisi...");
		}
		
		return listDeJoueur.get(choixJoueur);
	}
	
	public String getNom() {
		return nom;
	}
	
	public int compareTo(Joueur autreJoueur) {
		int nbj1 = this.getNbMenhirTotalDuJoueur();
		int nbj2 = autreJoueur.getNbMenhirTotalDuJoueur();
		int resultat;
		
		if (nbj1 > nbj2) {
			resultat = 1;
		}else{
			if (nbj1 == nbj2) {
				resultat =  0;
			}else{
				resultat = -1;
			}
		}
		return resultat;
		
	}
	
}
