import java.util.*;

public abstract class Joueur {
//   /!\ GRAINES 
	private String nom;
	private int age;

	private int nombreDePointTotal = 0;
	protected ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();
	private int nbMenhirDuJoueur;
	private int nbMenhirTotalDuJoueur = 0;
	protected int nbGraineDuJoueur = 0;
	private boolean actif;
	private int choixAction;

	

	// /!\ gérer pour 2 à 6 joueurs
	public Joueur(){
		System.out.println("Nom du joueur :");
		Scanner scanNom = new Scanner(System.in); //Créer une exception si on ne rentre pas des caractères
		String nomJPhysique = scanNom.nextLine();
		
		System.out.println("Age du joueur :");
		Scanner scanAge = new Scanner(System.in); //Créer une exception si on ne rentre pas un nombre
		int ageJoueurPhysique = scanAge.nextInt();
		
		this.age = ageJoueurPhysique;
		this.nom = nomJPhysique;
		//main = new ArrayList<Carte>();
		this.nbGraineDuJoueur = 0;
		this.nbMenhirDuJoueur = 0;
	}
	
	public void afficherMainJoueur(){
		int i = 1;
		for(Carte c: this.mainDuJoueur){
			// pour permettre au USER de faire afficher les valeurs de la carte

			System.out.println("Carte " + i + " :");
			// travailler la méthode afficherCarte() de carte pour permettre l'affichage de chaque cartes des joueurs

			//System.out.println(c.afficherCarte() + "\n taper " + i);
			i++;
			
			System.out.println(c.toString());
		}
	}
	
	public int getNbGraineDuJoueur(){
		return nbGraineDuJoueur;
	}
	
	public void setNbGraineDuJoueur(int nbGraineDuJoueur, int nbAAjouterGraine){
		this.nbGraineDuJoueur = nbGraineDuJoueur + nbAAjouterGraine;
	}
	
	public void setNbGraineDuJoueur(int nbGraineADonner){
		this.nbGraineDuJoueur = nbGraineADonner;
	}
	
	public int getNbMenhirDuJoueur(){
		return nbMenhirDuJoueur;
	}
	
	public void setNbMenhirDuJoueur(int nbMenhirDuJoueur, int nbAAjouterMenhir){
		this.nbMenhirDuJoueur = nbMenhirDuJoueur + nbAAjouterMenhir;
	}
	
	public void setNbMenhirTotalDuJoueur(int nbMenhirDuJoueur) {
		this.nbMenhirTotalDuJoueur = this.nbMenhirTotalDuJoueur + nbMenhirDuJoueur;
	}
	
	public int getNbMenhirTotalDuJoueur() {
		return this.nbMenhirTotalDuJoueur;
	}
	
		
	public ArrayList<Carte> getMainDuJoueur() {
		return this.mainDuJoueur;
	}
	
	public void jouerCarte(Manche m, Partie p) {
		Carte c = this.choisirCarte(m, p);
		this.choisirAction(c, m, p);
	}

	//public abstract void jouerCarte(){
	public Carte choisirCarte(Manche m, Partie p){
	//// déplacer JOUEUR ////
		
		System.out.println("\nChoisir une carte à jouer : ");
		// parcourir la liste et indiquer laquelle est choisie en fonction d'un indice
		Scanner scanCarte = new Scanner(System.in); // pour scanner l'indice de la carte choisie
		int choixCarte = scanCarte.nextInt();
		
		//System.out.println("Vous avez choisi la carte " + choixCarte);
		
			/*switch(choixCarte){  
				case 1:
						this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);  // indiquer les actions et valeurs de la bonne carte
					break;
				case 2:
						this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);
					break;
				case 3:
						this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);
					break;
				case 4:
						this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);
					break;
				case 5: 
						this.faireAction(this.mainDuJoueur.get(choixCarte -1), m, p);
					break;
				default: System.out.println("Veuillez choisir une carte existante\n\n");
				// /!\ reboucler
					break;
			}*/	
			return this.mainDuJoueur.get(choixCarte - 1);
	}
	public void choisirAction(Carte c, Manche m, Partie p) {
		System.out.println(c.toString());
		System.out.println("Choisir l'action à effectuer : \n");
		System.out.println("1- Géant");
		System.out.println("2- Engrais");
		System.out.println("3- Farfadet");
		

		int saison = m.getSaisonEnCours();
		
		Scanner scanAction = new Scanner(System.in);
		int choixAction = scanAction.nextInt();
		//scanAction.close();
		
		System.out.println("Vous avez choisi l'action : " + choixAction);
		
		System.out.println("Vous avez " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs\n");
		
		if(choixAction == 1){ // GEANT
			
			this.setNbGraineDuJoueur(this.getNbGraineDuJoueur(), c.getForce(choixAction -1, saison)); 
			System.out.println("Vous avez pris " + c.getForce(choixAction -1, saison) + " graines dans le pot commun !");
			System.out.println("Vous avez " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs\n");
		}else{
			if(choixAction == 2){ // ENGRAIS 
				if(this.getNbGraineDuJoueur() >= c.getForce(choixAction -1, saison)){
					this.setNbMenhirDuJoueur(this.getNbMenhirDuJoueur(), c.getForce(choixAction -1, saison)); 
					int nbAjouteSurChamp =  c.getForce(choixAction -1, saison);
					this.setNbGraineDuJoueur(getNbGraineDuJoueur(), - nbAjouteSurChamp); 
					
					System.out.println("Résultat : " + c.getForce(choixAction -1, saison) + " de vos graines sont devenues des Menhirs !");
					System.out.println("Vous avez maintenant " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs\n");
				}else{
					if(this.getNbGraineDuJoueur() < c.getForce(choixAction -1, saison)){
						this.setNbMenhirDuJoueur(this.getNbGraineDuJoueur(), this.getNbGraineDuJoueur()); 
						int nbAjouteSurChamp =  this.getNbGraineDuJoueur();
						this.setNbGraineDuJoueur(getNbGraineDuJoueur(), - nbAjouteSurChamp); 
						
						System.out.println("Résultat : " + c.getForce(choixAction -1, saison) + " de vos graines sont devenues des Menhirs !");
						System.out.println("Vous avez maintenant " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs\n");
					}else{
						System.out.println("Sorry.. vous n'avez plus de graines..\n");
					}
				}
			}else{
				if(choixAction == 3){ // FARFADET
					System.out.println("Veuillez choisir un joueur : ");
					Joueur joueurChoisi = this.choisirJoueur(p.getListeJoueur());
					
					//if(joueurChoisi.getNom() != this.getNom()){
					System.out.println("Nb Graines du joueur choisi : " + joueurChoisi.getNbGraineDuJoueur() + " + Nb Menhirs : " + joueurChoisi.getNbMenhirDuJoueur());
					this.setNbGraineDuJoueur(this.getNbGraineDuJoueur(), c.getForce(choixAction -1, saison));
					int nbAVoler = c.getForce(choixAction -1, saison);
					joueurChoisi.setNbGraineDuJoueur(joueurChoisi.getNbGraineDuJoueur(), - nbAVoler);
					System.out.println("Vous volez " + nbAVoler + " graines au joueur " + joueurChoisi.getNom());
					System.out.println("Nb Graines du joueur choisi : " + joueurChoisi.getNbGraineDuJoueur() + " + Nb Menhirs : " + joueurChoisi.getNbMenhirDuJoueur());
					// ATTENTION AUX INDICE.. si on tape 2 alors que le choix est 0 ou 1, ça marche quand même.. 
					System.out.println("Vous avez volé " + c.getForce(choixAction -1, saison) + " graines au joueur " + joueurChoisi.getNom() + " !");
					/*}else{
						//Joueur joueurChoisi = this.choisirJoueur(p.getListeJoueur());
						System.out.println("ERROR");
					}*/
					// NOP ! 
					// ne pas faire de cette façon.. 
					//System.out.println("Veuillez choisir un joueur différent du votre");
					
				}else{
					System.out.println("Veuillez entrer une valeur juste\n\n");
					// /!\ faire reboucler sur le menu (choix de l'action)
				}
				// gérer les OutOfIndice
			}
		}
		this.getMainDuJoueur().remove(c);
	}
	
	/*public void faireAction(){		
		
	}*/
	
	/*public String getJoueurDeDebut() {
		return jQuiCommence;
	}

	public void setJoueurDeDebut(String jQuiCommence) {
		this.jQuiCommence = jQuiCommence;
	}*/

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Joueur choisirJoueur(ArrayList<Joueur> listDeJoueur){
		int i = 0;
		
			for(Joueur j : listDeJoueur){
				if(j.getNom() != this.getNom()){
					System.out.println(j.nom + " taper " + i);
					i++;
				}
			}
	
		
		
		Scanner scanJ = new Scanner(System.in);
		int choixJoueur = scanJ.nextInt();
		
		return listDeJoueur.get(choixJoueur);
	}
	
	public String getNom() {
		return nom;
	}
	
}
