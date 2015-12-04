import java.util.ArrayList;
import java.util.Scanner;

public class JoueurVirtuel extends Joueur implements Strategy {
	
	private ArrayList<Strategy> listeStrategies = new ArrayList<Strategy>();
	Strategy stratDuJVirtuel;
 
	public JoueurVirtuel() {
		super();
		
		//// VOIR OU LE PLACER
		// on utilise un contexte pour voir le changement de comportement lorsque la stratégie change
		Context context = new Context(new OffensiveStrategy());
		//System.out.println(" " + context.executeStrategy());   // executeStrategy est placé dans la classe Context
	}
	
	public void jouerCarte(Manche m, Partie p) {
		
	}

	@Override
	public Carte choisirCarte(Manche m, Partie p) {
		System.out.println("\nAu tour de " + this.getNom() + " de jouer!\n");
		this.afficherMainJoueur();
		System.out.println("Le joueur virtuel " + this.getNom() + " joue une carte !");
		
		Scanner scanCarte = new Scanner(System.in);
		int choixCarte = scanCarte.nextInt();
		
		return super.choisirCarte(m,p);
		
		
	}
	

	@Override
	public void choisirAction(Carte c, Manche m, Partie p) {
			int choixAction = 0;	 // a supp, juste pour tester
		int saison = m.getSaisonEnCours();		
		//System.out.println("Le joueur virtuel a choisie l'action : " + choixAction);

		if(choixAction == 1){ // GEANT
		
		}else{
			if(choixAction == 2){ // ENGRAIS 
				if(this.getNbGraineDuJoueur() >= c.getForce(choixAction -1, saison)){
					
				}else{
					if(this.getNbGraineDuJoueur() < c.getForce(choixAction -1, saison)){
						
					}
				}
			}else{
				if(choixAction == 3){ // FARFADET
					
				
				}
			}
		}
	}
}
