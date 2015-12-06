import java.util.InputMismatchException;
import java.util.Scanner;

public class JoueurPhysique extends Joueur {

	Joueur joueurChoisi = null;

	public JoueurPhysique() {
		super();
		
		System.out.println("Nom du joueur :");
		Scanner scanNom = new Scanner(System.in);
		String nomJPhysique = scanNom.nextLine();
		
		System.out.println("Age du joueur :");
		int ageJoueurPhysique = 0;
		do {
			try {
				Scanner scanAge = new Scanner(System.in);
				ageJoueurPhysique = scanAge.nextInt();
				if (ageJoueurPhysique < 8) {
					System.out.println("Vous �tes un peu jeune pour jouer! Le jeu du m�nhir est pour les 8 ans et plus.\nEntrez un autre �ge.\n");
				}
				else{
					if (ageJoueurPhysique > 122) {
						System.out.println("Vous �tes plus vieux que le record de long�vit� humaine!\nS�rieusement, entrez votre VRAI �ge. :)\n");
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

	public void jouerCarte(Manche m, Partie p){
		super.jouerCarte(m, p);
	}
}
