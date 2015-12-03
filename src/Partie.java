import java.util.ArrayList;
import java.util.Iterator;
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
		this.nbJPhysique = 2;
		this.listeJoueur.add(new JoueurPhysique());
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
		//scanTypeP.close();
		
	}
	
	public int getNbJPhysique(){
		return this.nbJPhysique;
	}
	
	public int getNbJVirtuel(){
		return this.nbJVirtuel;
	}

	public void lancerPartie() {
		
		if(this.partieAvancee){
			//Récupérer le nombre de manche
			//Créer toutes les manches et les mettre dans une liste
			//Faire un iterator pour faire défiler toutes les manches
			//A la fin de chaque manche, récupérer le nombre de menhir total de chaque joueur
			//A la fin de toutes les manches, désigner le joueur qui a le plus de menhir comme gagnant
			
			this.nbManche = this.nbJPhysique + this.nbJVirtuel;
			for(int i=0; i<=this.nbManche; i++){
				this.listeManche.add(new Manche(this));
			}
			for (Iterator<Manche> it = listeManche.iterator(); it.hasNext();) {
				
				
			}
			
			//this.listeManche.get(i).distribuerCarteJoueur(this);  // i ok ?
			
			for (Joueur j : this.listeJoueur)
				j.afficherMainJoueur();
		}else{ //Partie rapide
			//Créer une manche
			//A la fin de la manche, récupérer le nombre de graines de chaque joueur
			//Désigner le gagnant comme celui qui a le plus de menhirs
			//Récupérer le nombre de graines en cas d'égalité
			new Manche(this);

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
