import java.util.*;

public class Joueur {
//   /!\ GRAINES 
	private String nom;
	private int age;
	private int nombreDePointTotal;
	private ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();
	private int nbMenhirDuJoueur;
	private int nbGraineDuJoueur; 
	private boolean actif;
	private int choixAction;
	private int nbGraine;

	// /!\ gérer pour 2 à 6 joueurs
	public Joueur(){
		System.out.println("Nom du joueur :");
		Scanner scanNom = new Scanner(System.in);
		String nomJPhysique = scanNom.nextLine();
		
		System.out.println("Age du joueur :");
		Scanner scanAge = new Scanner(System.in);
		int ageJoueurPhysique = scanAge.nextInt();
		
		this.age = ageJoueurPhysique;
		this.nom = nomJPhysique;
		//main = new ArrayList<Carte>();
		this.nbGraineDuJoueur = 0;
		this.nbMenhirDuJoueur = 0;
	}
	
	// getGraine ?
	public void prendreGraine(){
		//this.nbGraineDuJoueur = nbGraineDuJoueur + 1;
	}
	
	public void afficherMainJoueur(){
		int i = 1;
		for(Carte c: this.mainDuJoueur){
			// pour permettre au USER de faire afficher les valeurs de la carte
			System.out.println(c.afficherCarte() + " taper " + i);
			i++;
		}
	}
	
	public int getGraine(){
		return nbGraine;
	}
	
	public void setGraine(int nbGraineDuJoueur){
		this.nbGraineDuJoueur = nbGraineDuJoueur +1;
	}
	
	public int getMenhir(){
		return nbMenhirDuJoueur;
	}
	
	public void setMenhir(int nbMenhirDuJoueur){
		this.nbMenhirDuJoueur = nbMenhirDuJoueur + 1;
	}
	
	
	
	public ArrayList<Carte> getMainDuJoueur() {
		return this.mainDuJoueur;
	}

	public void jouerCarte(){
		
	}

}
