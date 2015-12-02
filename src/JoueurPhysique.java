import java.util.Scanner;


public class JoueurPhysique extends Joueur {

	Joueur joueurChoisi = null;
	
	public JoueurPhysique() {
		super();
	}

	@Override
	public void jouerCarte(Manche m, Partie p) { /// vérifier la liste de carte en possession du joueur
		//Carte c = null;
		//this.afficherMainJoueur();
		System.out.println("Choisir une carte à jouer : \n\n");
		// parcourir la liste et indiquer laquelle est choisie en fonction d'un indice
		Scanner scanCarte = new Scanner(System.in); // pour scanner l'indice de la carte choisie
		int choixCarte = scanCarte.nextInt();
		
		switch(choixCarte){  
			case 1: System.out.println("Vous avez choisi la carte 1\n");
					this.faireAction(this.mainDuJoueur.get(choixCarte), m, p);  // indiquer les actions et valeurs de la bonne carte
				break;
			case 2: System.out.println("Vous avez choisi la carte 2\n");
					this.faireAction(this.mainDuJoueur.get(choixCarte), m, p);
				break;
			case 3: System.out.println("Vous avez choisi la carte 3\n");
					this.faireAction(this.mainDuJoueur.get(choixCarte), m, p);
				break;
			case 4: System.out.println("Vous avez choisi la carte 4\n");
					this.faireAction(this.mainDuJoueur.get(choixCarte), m, p);
				break;
			case 5: System.out.println("Vous avez choisi la carte 5\n");
					this.faireAction(this.mainDuJoueur.get(choixCarte), m, p);
				break;
			default: System.out.println("Veuillez choisir une carte existante\n\n");
				break;
		}	
	}
	
	public void faireAction(Carte c, Manche m, Partie p){
		System.out.println("Choisir action à effectuer : \n\n");
		System.out.println("1- Géant\n");
		System.out.println("2- Engrais\n");
		System.out.println("3- Farfadet\n");
		
		Scanner scanAction = new Scanner(System.in);
		int choixAction = scanAction.nextInt();
		
		if(choixAction == 1){ // GEANT
			String saison = m.getSaisonEnCours();
			this.setNbGraineDuJoueur(this.getNbGraineDuJoueur(), m.getSaisonNb());
		}else{
			if(choixAction == 2){ // ENGRAIS 
				this.setNbMenhirDuJoueur(this.getNbMenhirDuJoueur(), m.getSaisonNb()); 
				// // int nbAjouteSurChamp = c.getForce(saison);
				int nbAjouteSurChamp = 0;
				this.setNbGraineDuJoueur(getNbGraineDuJoueur(), - nbAjouteSurChamp); 
				
			}else{
				if(choixAction == 3){ // FARFADET
					//choisirJoueur();  // return un joueur 
					//nbGraineRecupAuJ = joueurChoisi.getNbGraineDuJoueur(); // prendre nb graines indiqué sur la carte
					
					//joueurChoisi.getNbGraineDuJoueur(this.getNbGraineDuJoueur(), m.getSaisonNb());
					// voler graines à un autre joueur 
					// nb graines du joueur ++ et de l'autre --
				}else{
					System.out.println("Veuillez entrer une valeur juste\n\n");
				}
			}
		}
	}



}
