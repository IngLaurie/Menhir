import java.util.Scanner;


public class JoueurPhysique extends Joueur {

	Joueur joueurChoisi = null;
	
	

	public JoueurPhysique() {
		super();
		
		System.out.println("Nom du joueur :");
		Scanner scanNom = new Scanner(System.in); //Créer une exception si on ne rentre pas des caractères
		String nomJPhysique = scanNom.nextLine();
		
		System.out.println("Age du joueur :");
		Scanner scanAge = new Scanner(System.in); //Créer une exception si on ne rentre pas un nombre
		int ageJoueurPhysique = scanAge.nextInt();
		
		this.age = ageJoueurPhysique;
		this.nom = nomJPhysique;
		isJoueurPhysique = true;
	}

	@Override
	public Carte choisirCarte(Manche m, Partie p) { 
		System.out.println("\nAu tour de " +this.getNom() + " de jouer!\n");
		this.afficherMainJoueur();
		//System.out.println("Vous avez choisi la carte " + carteChoisie);
		return super.choisirCarte(m, p);
		}

	public void choisirAction(Carte c, Manche m, Partie p){
		System.out.println("Vous avez " + this.getNbGraineDuJoueur() + " graines et " +this.getNbMenhirDuJoueur() + " ménhirs");
		super.choisirAction(c, m, p);
		System.out.println("Vous avez maintenant " +this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " ménhirs");
	}
	
	@Override
	public void jouerCarte(Manche m, Partie p){
		super.jouerCarte(m, p);
	}

//	public boolean isJoueurPhysique() {
//		return isJoueurPhysique;
//	}

}
