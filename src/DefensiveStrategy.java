import java.util.Iterator;

// EN COURS DE TEST ----
// C'EST ICI QUE L'ON VA CODER LES ALGOS DANS CHAQUE METHODE
public class DefensiveStrategy implements Strategy {
	private String nomStrat;
	
	public DefensiveStrategy(String strat) {
		super();
		this.nomStrat = strat;
	}

	public void jouerCarte(Manche m, Partie p, Joueur j) {
		System.out.println("Execution du joueurCarte de " + this.nomStrat + "Strategy après être passé dans executeStrategy");

		Carte c = this.choisirCarte(m, p, j);   // coder choisir carte
		this.choisirAction(c, m, p, j);         // coder choisir action
		// choisirAction(int) ??
	}

	public Carte choisirCarte(Manche m, Partie p, Joueur j) {
		// code de choisirCarte pour le joueurVirtuel
		System.out.println("\nAu tour de joueur virtuel " + "de jouer!\n");
		System.out.println("Le joueur virtuel choisi sa carte...");
		
		// parcourir la main du joueur virtuel
		// choisir la carte qui a le plus grand indice en fonction de la saison 
		//		au niveau de l'action GEANT
		 					// appeler choisirGeant qui se trouve dans la classe Ingrédient !
		// ensuite retourner la carte choisie 
		
			int geant = 1;
			int saisonEnCours = m.getSaisonEnCours();
			Carte choixCartePrivilegie = null;
			int valSuperieure = 0;
			
			choixCartePrivilegie = j.getMainDuJoueur().get(0);
			valSuperieure = choixCartePrivilegie.getForce(geant, saisonEnCours);
			
			for(Iterator<Carte> it = j.getMainDuJoueur().iterator(); it.hasNext();){
				Carte carteActive = it.next();
				if(carteActive.getForce(geant, saisonEnCours) > valSuperieure){
					choixCartePrivilegie = carteActive;
					valSuperieure = carteActive.getForce(geant, saisonEnCours);
				}
		}// attention à faire planter des graines à ce joueurs de temps en temps... 
			System.out.println("La méthode choisirCarte de DefensiveStrategy retourne la carte " + choixCartePrivilegie.getNom());
			System.out.println("La valeur de cette carte est : " + choixCartePrivilegie.getForce(geant, saisonEnCours));
		return choixCartePrivilegie;
	}

	public void choisirAction(Carte c, Manche m, Partie p, Joueur j) {
		// code de choisirAction pour le joueurVirtuel
		System.out.println("Le joueur virtuel choisi son action...");
		System.out.println("La strategie est defensive donc il va choisir l'action GEANT");
		// si le nombre de graines du joueur virtuel > 4
		//	alors on le fait jouer engrais pour faire pousser des menhirs
		// sinon on joue géant 
		// sinon farfadet 
		
		
		// jouer le GEANT via la classe ingredient !!!
		
	}

}
