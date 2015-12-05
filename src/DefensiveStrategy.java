import java.util.Iterator;

// EN COURS DE TEST ----
// C'EST ICI QUE L'ON VA CODER LES ALGOS DANS CHAQUE METHODE
public class DefensiveStrategy implements Strategy {
	private String nomStrat;
	
	public DefensiveStrategy(String strat) {
		super();
		this.nomStrat = strat;
	}

	public void jouerCarte(Manche m, Partie p) {
		System.out.println("Execution du joueurCarte de " + this.nomStrat + "Strategy après être passé dans executeStrategy");System.out.println("Execution du joueurCarte de " + this.nomStrat + "Strategy après être passé dans executeStrategy");

		Carte c = this.choisirCarte(m, p);   // coder choisir carte
		this.choisirAction(c, m, p);         // coder choisir action
		// choisirAction(int) ??
	}

	public Carte choisirCarte(Manche m, Partie p) {
		// code de choisirCarte pour le joueurVirtuel
		System.out.println("\nAu tour de joueur virtuel " + "de jouer!\n");
		System.out.println("Le joueur virtuel choisi sa carte...");
		
		// parcourir la main du joueur virtuel
		// choisir la carte qui a le plus grand indice en fonction de la saison 
		//		au niveau de l'action GEANT
		// ensuite retourner la carte choisie 
		
		return this.choisirCarte(m, p);
	}

	public void choisirAction(Carte c, Manche m, Partie p) {
		// code de choisirAction pour le joueurVirtuel
		System.out.println("Le joueur virtuel choisi son action...");
		
		// si le nombre de graines du joueur virtuel > 4
		//	alors on le fait jouer engrais pour faire pousser des menhirs
		// sinon on joue géant 
		// sinon farfadet 
		
	}	
}
