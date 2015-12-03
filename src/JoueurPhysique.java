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

		Carte carteChoisie = super.choisirCarte(m, p);

		System.out.println("Vous avez choisi la carte " + carteChoisie);
		return carteChoisie;
		}

	
	public void faireAction(Carte c, Manche m, Partie p){
		System.out.println("Choisir action à effectuer : \n");
		System.out.println("1- Géant");
		System.out.println("2- Engrais");
		System.out.println("3- Farfadet");
		

		int saison = m.getSaisonEnCours();
		
		Scanner scanAction = new Scanner(System.in);
		int choixAction = scanAction.nextInt();
		//scanAction.close();
		
		System.out.println("Vous avez choisi l'action : " + choixAction);
		
		// ATTENTION ALGO //
		// ATTENTION ALGO //
		// ATTENTION ALGO //
		// ATTENTION ALGO //
		// ATTENTION ALGO //
		// ATTENTION ALGO //
		if(choixAction == 1){ // GEANT
			this.setNbGraineDuJoueur(this.getNbGraineDuJoueur(), c.getForce(choixAction -1, saison)); 
			
			System.out.println("Vous avez pris " + c.getForce(choixAction -1, saison) + " graines dans le pot commun !\n\n");
		}else{
			if(choixAction == 2){ // ENGRAIS 
				if(this.getNbGraineDuJoueur() >= c.getForce(choixAction -1, saison)){
					this.setNbMenhirDuJoueur(this.getNbMenhirDuJoueur(), c.getForce(choixAction -1, saison)); 
					int nbAjouteSurChamp =  c.getForce(choixAction -1, saison);
					this.setNbGraineDuJoueur(getNbGraineDuJoueur(), - nbAjouteSurChamp); 
					
					System.out.println("Résultat : " + c.getForce(choixAction -1, saison) + " de vos graines sont devenues des Menhirs !");
					System.out.println("Vous avez maintenant " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs.\n\n");
				}else{
					if(this.getNbGraineDuJoueur() < c.getForce(choixAction -1, saison)){
						this.setNbMenhirDuJoueur(this.getNbGraineDuJoueur(), this.getNbGraineDuJoueur()); 
						int nbAjouteSurChamp =  this.getNbGraineDuJoueur();
						this.setNbGraineDuJoueur(getNbGraineDuJoueur(), - nbAjouteSurChamp); 
						
						System.out.println("Résultat : " + c.getForce(choixAction -1, saison) + " de vos graines sont devenues des Menhirs !");
						System.out.println("Vous avez maintenant " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs.\n\n");
					}else{
						System.out.println("Sorry.. vous n'avez plus de graines..");
					}
				}
			}else{
				if(choixAction == 3){ // FARFADET
					System.out.println("Veuillez choisir un joueur : ");
					
					Joueur joueurChoisi = this.choisirJoueur(p.getListeJoueur());
					this.setNbGraineDuJoueur(this.getNbGraineDuJoueur(), c.getForce(choixAction -1, saison));
					int nbAVoler = c.getForce(choixAction -1, saison);
					joueurChoisi.setNbGraineDuJoueur(nbGraineDuJoueur, - nbAVoler);
					
					System.out.println("Vous avez volé " + c.getForce(choixAction -1, saison) + " graines au joueur " + joueurChoisi.getNom() + " !");
					System.out.println("Vous avez maintenant " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs.\n\n");
				}else{
					System.out.println("Veuillez entrer une valeur juste\n\n");
					// /!\ faire reboucler sur le menu (choix de l'action)
				}
			}
		}
		this.getMainDuJoueur().remove(c);
	}



}
