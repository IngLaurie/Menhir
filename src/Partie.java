import java.util.ArrayList;
import java.util.Collections;
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
	private int mancheNumero = 0;
	
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
				this.listeJoueur.add(new JoueurVirtuel(i));
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
			
			this.nbManche = this.nbJPhysique + this.nbJVirtuel;
			for(int i=0; i<this.nbManche; i++){
				this.listeManche.add(new Manche());
			}
			for (Iterator<Manche> it = listeManche.iterator(); it.hasNext();) {
				Manche mancheActive = it.next();
				this.mancheNumero++;
				mancheActive.jouerManche(this);
				System.out.println("La manche est terminée.\n");
				int j = 0;
				for (Iterator<Joueur> it2 = listeJoueur.iterator(); it2.hasNext();) {
					Joueur joueurActif = it2.next();
					joueurActif.setNbMenhirTotalDuJoueur(joueurActif.getNbMenhirDuJoueur());
					joueurActif.setNbMenhirDuJoueur(0);
				}
				this.afficherClassement();
			}
			
			System.out.println("\nFin de la partie!\nClassement final:\n");
			this.afficherClassement();
			
			
		}else{ 
			Manche manche = new Manche();
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
			System.out.print(gagnant.getNom() + " avec " +gagnant.getNbMenhirDuJoueur()+ " ménhir(s) et " +gagnant.getNbGraineDuJoueur()+ " graine(s).\n");
		}
	}
	
	public void afficherClassement() {
		ArrayList<Joueur> classement = new ArrayList<Joueur>();
		int position = 0;
		int egalite = 0;
		for (Iterator<Joueur> it = listeJoueur.iterator(); it.hasNext();) {
			Joueur joueurActif = it.next();
			classement.add(joueurActif);
			Collections.sort(classement);
		}
		
		int nbMenhirsTotal = -1;
		for (Iterator<Joueur> it = classement.iterator(); it.hasNext();){
			Joueur joueurActif = it.next();
			if (nbMenhirsTotal != joueurActif.getNbMenhirTotalDuJoueur()) {
				position = position + 1 + egalite;
				egalite = 0;
				nbMenhirsTotal = joueurActif.getNbMenhirTotalDuJoueur();
			}else{
				egalite++;
			}
			System.out.println(position + ". " +joueurActif.getNom()+ " avec: " +joueurActif.getNbMenhirTotalDuJoueur());
		}
		
	}
	
	public boolean getPartieAvancee() {
		return partieAvancee;
	}
	
	public ArrayList<Joueur> getListeJoueur(){
		return listeJoueur;
	}
	
	public int getMancheNumero() {
		return this.mancheNumero;
	}

}
