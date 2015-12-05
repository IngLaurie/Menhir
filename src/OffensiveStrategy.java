// EN COURS DE TEST ----
// C'EST ICI QUE L'ON VA CODER LES ALGOS DANS CHAQUE METHODE
public class OffensiveStrategy implements Strategy {
	private String nomStrat;
	
	public OffensiveStrategy(String strat) {
		super();
		this.nomStrat = strat;
	}

	public void jouerCarte(Manche m, Partie p) {
		System.out.println("Execution du joueurCarte de " + this.nomStrat + "Strategy après être passé dans executeStrategy");

		Carte c = this.choisirCarte(m, p);   // coder choisir carte
		
		
		// VOLER PLUTOT DES GRAINES ET ENSUITE JARDINER
		// CHOIX ACTION 3 farfadet
		// SINON CHOIX ACTION 2 engrais
		
		
		this.choisirAction(c, m, p);		 // coder choisir action
	}

	public Carte choisirCarte(Manche m, Partie p) {
		// code de choisirCarte pour le joueurVirtuel
		System.out.println("Le joueur virtuel choisi sa carte");
		return null; // il faut retourner une carte
	}

	public void choisirAction(Carte c, Manche m, Partie p) {
		// code de choisirAction pour le joueurVirtuel
		System.out.println("Le joueur virtuel choisi son action");
	}
}
