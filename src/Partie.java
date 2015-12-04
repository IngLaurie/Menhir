import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashSet;

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
		this.nbJPhysique = 2; //Penser à en remettre un seul
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
		
		if(nbJVirtuel >= 0 && nbJVirtuel <= 5){
			for(int i=1; i<= nbJVirtuel; i++){
				this.listeJoueur.add(new JoueurVirtuel());
			}
			
		for (Iterator<Joueur> it2 = this.listeJoueur.iterator(); it2.hasNext();) {
			Joueur lJoueur = it2.next();
			lJoueur.setNbGraineDuJoueur(2);			
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
			//Récupérer le nombre de manche
			//Créer toutes les manches et les mettre dans une liste
			//Faire un iterator pour faire défiler toutes les manches
			//A la fin de chaque manche, récupérer le nombre de menhir total de chaque joueur
			//A la fin de toutes les manches, désigner le joueur qui a le plus de menhir comme gagnant
			
			
			// permettre le choix entre une carte allié ou deux graines 
			this.nbManche = this.nbJPhysique + this.nbJVirtuel;
			for(int i=0; i<=this.nbManche; i++){
				this.listeManche.add(new Manche(this));
			}
			for (Iterator<Manche> it = listeManche.iterator(); it.hasNext();) {
				Manche mancheActive = it.next();
				mancheActive.jouerManche(this);
				System.out.println("La manche est terminée.\n");
				for (Iterator<Joueur> it2 = listeJoueur.iterator(); it2.hasNext();) {
					Joueur joueurActif = it2.next();
					joueurActif.setNbMenhirTotalDuJoueur(joueurActif.getNbMenhirDuJoueur());
					joueurActif.setNbMenhirDuJoueur(0);
				}
				this.afficherClassement();
			}
				
			
			
		}else{ //Partie rapide
			//Créer une manche
			//A la fin de la manche, récupérer le nombre de menhirs de chaque joueur
			//Désigner le gagnant comme celui qui a le plus de menhirs
			//Récupérer le nombre de graines en cas d'égalité
			Manche manche = new Manche(this);
			manche.jouerManche(this);
			System.out.println("\nLa partie est terminée.\n");
			this.afficherGagnants();
			}
	}

	public void afficherGagnants() {
		HashSet<Joueur> joueursGagnants = new HashSet<Joueur>();
		int menhirMax = 0;
		int grainesMax = 0;
		for (Iterator<Joueur> it = this.getListeJoueur().iterator(); it.hasNext();) {
			Joueur joueurActif = it.next();
			if (joueurActif.getNbMenhirDuJoueur() > menhirMax) {
				menhirMax = joueurActif.getNbMenhirDuJoueur();
				grainesMax = joueurActif.getNbGraineDuJoueur();
			}
		}
		for (Iterator<Joueur> it = this.getListeJoueur().iterator(); it.hasNext();) {
			Joueur joueurActif = it.next();
			if (joueurActif.getNbMenhirDuJoueur() == menhirMax && joueurActif.getNbGraineDuJoueur() == grainesMax) {
				joueursGagnants.add(joueurActif);
			}
		}
		if (joueursGagnants.size() == 1) {
			System.out.println("Le gagnant est: ");
		} else {
			System.out.println("Les gagnants sont: ");
		}
		for (Iterator<Joueur> it = joueursGagnants.iterator(); it.hasNext();) {
			Joueur gagnant = it.next();
			System.out.print(gagnant.getNom() + " \n");
		}
	}
	
	public void afficherClassement() {
		ArrayList<Joueur> classement = new ArrayList<Joueur>();
		for (Iterator<Joueur> it = listeJoueur.iterator(); it.hasNext();) {
			Joueur joueurActif = it.next();
			classement.add(joueurActif);
		}
		for (Iterator<Joueur> it2 = classement.iterator(); it.hasNext();) {
			
		}
	}
	
	public boolean getPartieAvancee() {
		return partieAvancee;
	}
	
	public ArrayList<Joueur> getListeJoueur(){
		return listeJoueur;
	}

}
