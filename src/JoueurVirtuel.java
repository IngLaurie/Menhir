import java.util.ArrayList;
import java.util.Scanner;


public class JoueurVirtuel extends Joueur {
	
	private int strategie;
	
	// IA :: gérer les stratégies de différents joueurs 
	// voleur
	// espion
	//

	public JoueurVirtuel() {
		super();
	}

	@Override
	public void jouerCarte(Manche m, Partie p) {
		System.out.println("\nAu tour de " + this.getNom() + " de jouer!\n");
		this.afficherMainJoueur();
		System.out.println("Le joueur virtuel " + this.getNom() + " joue une carte !");
		
		Scanner scanCarte = new Scanner(System.in); // pour scanner l'indice de la carte choisie
		int choixCarte = scanCarte.nextInt();
		
		/*
		switch(choixCarte){  
		case 1: System.out.println("Vous avez choisi la carte 1\n");
				this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);
			break;
		case 2: System.out.println("Vous avez choisi la carte 2\n");
				this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);
			break;
		case 3: System.out.println("Vous avez choisi la carte 3\n");
				this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);
			break;
		case 4: System.out.println("Vous avez choisi la carte 4\n");
		// VOIR LE BUG AU NIVEAU DU CHOIX DE LA CARTE NUM 4
				this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);
			break;
		case 5: System.out.println("Vous avez choisi la carte 5\n");
				this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);
			break;
		default: System.out.println("Veuillez choisir une carte existante\n\n");
			break;
		}
		*/
	}
	
//	public void jouerCarte(ArrayList<Carte> carteDuJoueur){
//		
//	}

	@Override
	public void faireAction(Carte c, Manche m, Partie p) {
		System.out.println("Choisir action à effectuer : \n");
		System.out.println("1- Géant");
		System.out.println("2- Engrais");
		System.out.println("3- Farfadet");
		
		// version finale : 
		// 		sleep thread
		// 		aucun affichage
		int saison = m.getSaisonEnCours();
		
		Scanner scanAction = new Scanner(System.in);
		int choixAction = scanAction.nextInt();
		//scanAction.close();
		
		System.out.println("Vous avez choisi l'action : " + choixAction);
		
		// ATTENTION ALGO //
		// ATTENTION ALGO //
		// ATTENTION ALGO //
		if(choixAction == 1){ // GEANT
			/*this.setNbGraineDuJoueur(this.getNbGraineDuJoueur(), c.getForce(choixAction -1, saison)); 
			System.out.println("Vous avez pris " + c.getForce(choixAction -1, saison) + " graines dans le pot commun !\n\n");*/
		}else{
			if(choixAction == 2){ // ENGRAIS 
				if(this.getNbGraineDuJoueur() >= c.getForce(choixAction -1, saison)){
					/*this.setNbMenhirDuJoueur(this.getNbMenhirDuJoueur(), c.getForce(choixAction -1, saison)); 
					int nbAjouteSurChamp =  c.getForce(choixAction -1, saison);
					this.setNbGraineDuJoueur(getNbGraineDuJoueur(), - nbAjouteSurChamp); 
					System.out.println("Résultat : " + c.getForce(choixAction -1, saison) + " de vos graines sont devenues des Menhirs !");
					System.out.println("Vous avez maintenant " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs.\n\n");*/
				}else{
					if(this.getNbGraineDuJoueur() < c.getForce(choixAction -1, saison)){
						/*this.setNbMenhirDuJoueur(this.getNbGraineDuJoueur(), this.getNbGraineDuJoueur()); 
						int nbAjouteSurChamp =  this.getNbGraineDuJoueur();
						this.setNbGraineDuJoueur(getNbGraineDuJoueur(), - nbAjouteSurChamp); 
						System.out.println("Résultat : " + c.getForce(choixAction -1, saison) + " de vos graines sont devenues des Menhirs !");
						System.out.println("Vous avez maintenant " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs.\n\n");*/
					}else{
						System.out.println("Sorry.. vous n'avez plus de graines..");
					}
				}
			}else{
				if(choixAction == 3){ // FARFADET
					/*System.out.println("Veuillez choisir un joueur : ");
					Joueur joueurChoisi = this.choisirJoueur(p.getListeJoueur());
					this.setNbGraineDuJoueur(this.getNbGraineDuJoueur(), c.getForce(choixAction -1, saison));
					int nbAVoler = c.getForce(choixAction -1, saison);
					joueurChoisi.setNbGraineDuJoueur(nbGraineDuJoueur, - nbAVoler);
					System.out.println("Vous avez volé " + c.getForce(choixAction -1, saison) + " graines au joueur " + joueurChoisi.getNom() + " !");
					System.out.println("Vous avez maintenant " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs.\n\n");*/
				}else{
					System.out.println("Veuillez entrer une valeur juste\n\n");
				}
			}
		}
		
	}

	

}
