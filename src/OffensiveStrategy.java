// EN COURS DE TEST ----
// C'EST ICI QUE L'ON VA CODER LES ALGOS DANS CHAQUE METHODE
public class OffensiveStrategy implements Strategy {
	private String nomStrat;
	/*
	 * liste d'attributs n�cessaire ? 
	 */
	
	// Constructeur
	public OffensiveStrategy(String strat) {
		super();
		this.nomStrat = strat;
	}


	public void jouerCarte(Manche m, Partie p) {
		System.out.println("Strat�gie jou�e "/*par  " +*/  + " est : " + this.nomStrat);
		System.out.println("Execution du joueurCarte de OffensiveStrategy apr�s �tre pass� dans executeStrategy");
		
		// CODE DE JOUER CARTE
		Carte c = this.choisirCarte(m, p);  // coder choisir carte
		this.choisirAction(c, m, p);		 // coder choisir action
	}

	public Carte choisirCarte(Manche m, Partie p) {
		// code de choisirCarte pour le joueurVirtuel
		return null;
	}

	public void choisirAction(Carte c, Manche m, Partie p) {
		// code de choisirAction pour le joueurVirtuel
		
	}


	public String getNomStrat() {
		return nomStrat;
	}
	
	


}
