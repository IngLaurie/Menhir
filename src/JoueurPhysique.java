import java.util.Scanner;


public class JoueurPhysique extends Joueur {

	Joueur joueurChoisi = null;
	
	public JoueurPhysique() {
		super();
	}

	@Override
	public void jouerCarte() { /// vérifier la liste de carte en possession du joueur
		Carte c = null;
		this.afficherMainJoueur();
		System.out.println("Choisir une carte à jouer : \n\n");
		// parcourir la liste et indiquer laquelle est choisie en fonction d'un indice
		Scanner scanCarte = new Scanner(System.in); // pour scanner l'indice de la carte choisie
		int choixCarte = scanCarte.nextInt();
		
		switch(choixCarte){  // OU UNE BOUCLE WHILE ?
			case 1: System.out.println("Vous avez choisi la carte 1\n");
					this.faireAction(c);  // indiquer les actions et valeurs de la bonne carte
				break;
			case 2: System.out.println("Vous avez choisi la carte 2\n");
					this.faireAction(c);
				break;
			case 3: System.out.println("Vous avez choisi la carte 3\n");
					this.faireAction(c);
				break;
			case 4: System.out.println("Vous avez choisi la carte 4\n");
					this.faireAction(c);
				break;
			case 5: System.out.println("Vous avez choisi la carte 5\n");
					this.faireAction(c);
				break;
			default: System.out.println("Veuillez choisir une carte existante\n\n");
				break;
		}	
	}
	
	public void faireAction(Carte c){
		System.out.println("Choisir action à effectuer : \n\n");
		System.out.println("1- Géant\n");
		System.out.println("2- Engrais\n");
		System.out.println("3- Farfadet\n");
		
		Scanner scanAction = new Scanner(System.in);
		int choixAction = scanAction.nextInt();
		
		if(choixAction == 1){ // GEANT
			// parcourir la carte et voir le nb graine 
			// /!\ en fonction de la saison = indice de la carte 
			this.setNbGraineDuJoueur(this.getNbGraineDuJoueur(), 1); // incrémenter en fonction du nb indiqué
			
		}else{
			if(choixAction == 2){ // ENGRAIS 
				this.setNbMenhirDuJoueur(this.getNbMenhirDuJoueur(), 1);  // /!\ incrémenter en fonction du nb indiqué
				int nbAjouteSurChamp = 0;  // récupérer la valeur de la carte 
				this.setNbGraineDuJoueur(getNbGraineDuJoueur(), - nbAjouteSurChamp);  // /!\ décrémenter du nombre ajouté
				
			}else{
				if(choixAction == 3){ // FARFADET
					this.choisirJoueur();  // return un joueur 
					//nbGraineRecupAuJ = joueurChoisi.getNbGraineDuJoueur(); // prendre nb graines indiqué sur la carte
					// voler graines à un autre joueur 
					// nb graines du joueur ++ et de l'autre --
				}else{
					System.out.println("Veuillez entrer une valeur juste\n\n");
				}
			}
		}
	}
	
	public Joueur choisirJoueur(){
		// choisir le joueur parmi la liste de joueurs 
	//	Joueur joueurChoisi = null;
		
		return joueurChoisi;
	}



}
