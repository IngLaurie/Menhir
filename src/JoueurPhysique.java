import java.util.Scanner;


public class JoueurPhysique extends Joueur {

	Joueur joueurChoisi = null;
	
	public JoueurPhysique() {
		super();
	}

	@Override
	public Carte choisirCarte(Manche m, Partie p) { 
		System.out.println("\nAu tour de " +this.getNom() + " de jouer!\n");
		this.afficherMainJoueur();

		System.out.println("test1\n");
		//System.out.println("Vous avez choisi la carte " + carteChoisie);
		return super.choisirCarte(m, p);
		}

	
	public void choisirAction(Carte c, Manche m, Partie p){
		System.out.println("Vous avez " + this.getNbGraineDuJoueur() + " graines et " +this.getNbMenhirDuJoueur() + " ménhirs");
		super.choisirAction(c, m, p);
	}
	@Override
	public void jouerCarte(Manche m, Partie p){
		super.jouerCarte(m, p);
	}



}
