import java.util.ArrayList;
import java.util.Scanner;

// PENSER AU SINGLETON
// THREAD ?
// MVC ?
// 
public class Partie {

	private boolean partieAvancee;
	private ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>();
	private ArrayList<Manche> listeManche = new ArrayList<Manche>();
	
	private int nbJPhysique;
	private int nbJVirtuel;
	private int nbManche = 0;
	
	public Partie(){
		
		final int NBMAXJOUEUR = 6;
		final int NBMINJOUEUR = 1;
	
		System.out.println("Partie RAPIDE (0) ou avec des REGLES AVANCEES (1) ?");
		Scanner scanTypeP = new Scanner(System.in);
		int typePartie = scanTypeP.nextInt();
		scanTypeP.close();
		
		if(typePartie == 0){
			this.partieAvancee = false;
			
		}else{
			if(typePartie == 1){
				this.partieAvancee = true;
			}else{
				System.out.println("Nombre non valide, veuillez saisir 0 ou 1");
			}
		}
		
		
		// /!\ 1 seul joueur physique !
		this.nbJPhysique = 1;
		this.listeJoueur.add(new JoueurPhysique());
		
		/*System.out.println("Combien y a t'il de joueur(s) physique(s) ?");
		Scanner scanNbJ = new Scanner(System.in);
		this.nbJPhysique = scanNbJ.nextInt();
		
		if(nbJPhysique >= 1 && nbJPhysique <= 6){
			for(int i=1; i<= nbJPhysique; i++){
				this.listeJoueur.add(new JoueurPhysique());
			}

		}else{
		System.out.println("Nombre non valide, veuillez saisir 0 ou 1");
	    }*/
		
		System.out.println("Combien y a t'il de joueur(s) virtuel(s) ?");
		Scanner scanNbJ = new Scanner(System.in);
		this.nbJVirtuel = scanNbJ.nextInt();
		scanNbJ.close();
		
		if(nbJVirtuel >= 1 && nbJVirtuel <= 5){
			for(int i=1; i<= nbJVirtuel; i++){
				this.listeJoueur.add(new JoueurVirtuel());
			}

		}else{
		System.out.println("Nombre non valide, veuillez saisir 0 ou 1");
	    }
		
	}
	
	public int getNbJPhysique(){
		return this.nbJPhysique;
	}
	
	public int getNbJVirtuel(){
		return this.nbJVirtuel;
	}

	public void lancerPartie() {
		
		if(this.partieAvancee){
			/*this.nbManche = this.nbJPhysique + this.nbJVirtuel;
			for(int i=0; i<=this.nbManche; i++){
				this.listeManche.add(new Manche(this));
				this.listeManche.get(i).distribuerCarteJoueur(this);  // i ok ?
			}*/
			
			for (Joueur j : this.listeJoueur)
				j.afficherMainJoueur();
		}else{
			// Partie rapide 
			// Lancer la fonction nouvelle manche!
			this.listeManche.add(new Manche(this));
			
			this.listeManche.get(0).distribuerCarteJoueur(this);
			for (Joueur j : this.listeJoueur){
				j.afficherMainJoueur();
				j.jouerCarte(this.listeManche.get(0), this);
			}
		}
	}

	public boolean getPartieAvancee() {
		return partieAvancee;
	}
	
	public ArrayList<Joueur> getListeJoueur(){
		return listeJoueur;
	}

}
