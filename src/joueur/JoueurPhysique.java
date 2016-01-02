package joueur;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import partie.Manche;
import partie.Partie;



public class JoueurPhysique extends Joueur {

	Joueur joueurChoisi = null;

	public JoueurPhysique() {
		super();
		this.isJoueurPhysique = false;
		
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
					System.out.println("Vous êtes un peu jeune pour jouer! Le jeu du Menhir est pour les 8 ans et plus.\nEntrez un autre âge.\n");
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

	public void jouerCarte(Manche m, Partie p){
		super.jouerCarte(m, p);
	}
	
	public Joueur choisirJoueur(ArrayList<Joueur> listDeJoueur){
		int i = 0;
			for(Joueur j : listDeJoueur){
				if(j.getNom() != this.getNom()){
					System.out.println(+i+ " pour choisir " +j.nom+ ", " +j.getNbGraineDuJoueur()+ " graines et " +j.getNbMenhirDuJoueur()+ " ménhirs." );					
				}
				i++;
			}
			
		int choixJoueur = -1;
		do {
			try {
				Scanner scanJ = new Scanner(System.in);
				choixJoueur = scanJ.nextInt();
				
				if (listDeJoueur.get(choixJoueur) == this) {
					choixJoueur = -1;
					System.out.println("Ce n'est pas un choix valide, réessayez.\n");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Choisissez un joueur en entrant un nombre entier\n.");
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Il n'y a pas de joueurs correspondant à ce choix.");
			}
		}while(choixJoueur < 0 || choixJoueur > listDeJoueur.size());
		return listDeJoueur.get(choixJoueur);
	}
	
}
