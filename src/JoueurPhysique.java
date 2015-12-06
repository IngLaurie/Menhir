import java.util.InputMismatchException;
import java.util.Scanner;


public class JoueurPhysique extends Joueur {

	Joueur joueurChoisi = null;
	
	

	public JoueurPhysique() {
		super();
		
		System.out.println("Nom du joueur :");
		Scanner scanNom = new Scanner(System.in); //Créer une exception si on ne rentre pas des caractères
		String nomJPhysique = scanNom.nextLine();
		
		System.out.println("Age du joueur :");
		int ageJoueurPhysique = 0;
		do {
			try {
				Scanner scanAge = new Scanner(System.in);
				ageJoueurPhysique = scanAge.nextInt();
				if (ageJoueurPhysique < 8) {
					System.out.println("Vous êtes un peu jeune pour jouer! Le jeu du ménhir est pour les 8 ans et plus.\nEntrez un autre âge.\n");
				}
				else{
					if (ageJoueurPhysique > 122) {
						System.out.println("Vous êtes plus vieux que le record de longévité humaine!\nSérieusement, entrez votre VRAI âge. :)\n");
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("Merci d'entrer un nombre entier.\n");
			}
		}while (ageJoueurPhysique < 8 || ageJoueurPhysique > 122);
		
		this.age = ageJoueurPhysique;
		this.nom = nomJPhysique;
		isJoueurPhysique = true;
	}

	/*@Override
	public Carte choisirCarte(Manche m, Partie p) { 
		System.out.println("\nAu tour de " +this.getNom() + " de jouer!\n");
		this.afficherMainJoueur();
		//System.out.println("Vous avez choisi la carte " + carteChoisie);
		return super.choisirCarte(this, m, p);
		}

	public void choisirAction(Carte c, Manche m, Partie p){
		System.out.println("Vous avez " + this.getNbGraineDuJoueur() + " graines et " +this.getNbMenhirDuJoueur() + " ménhirs");
		super.choisirAction(this, m, p);
		System.out.println("Vous avez maintenant " +this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " ménhirs");
	}
	
	@Override*/
	public void jouerCarte(Manche m, Partie p){
		super.jouerCarte(m, p);
	}

//	public boolean isJoueurPhysique() {
//		return isJoueurPhysique;
//	}

}
