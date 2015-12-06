import java.lang.reflect.Method;
import java.util.Iterator;

// EN COURS DE TEST ----

public class DefensiveStrategy implements Strategy {
	private String nomStrat;
	private boolean utiliserGeant;
	private final int GEANT = 1;
	private final int ENGRAIS = 2;
	
	public DefensiveStrategy(String strat) {
		super();
		this.nomStrat = strat;
		this.utiliserGeant = false;
	}
	
	
//	public void jouerCarte(Manche m, Partie p, Joueur j, Ingredient i) {
	//public void jouerCarte(Joueur j, Manche m, Partie p) {
	public void jouerCarte(Joueur j, Manche m, Partie p, Class i) {
		System.out.println("Execution du joueurCarte de " + this.nomStrat + "Strategy après être passé dans executeStrategy");

		Carte c = this.choisirCarte(m, p, j);
		this.choisirAction(c, m, p, j, i);
	}
	
	public Carte choisirCarte(Manche m, Partie p, Joueur j) {
		System.out.println("\nAu tour de joueur virtuel " + "de jouer!\n");
		System.out.println("Le joueur virtuel choisi sa carte...");
		
			int saisonEnCours = m.getSaisonEnCours();
			Carte choixCartePrivilegie = null;
			int valSuperieure = 0;
			
			choixCartePrivilegie = j.getMainDuJoueur().get(0);
			valSuperieure = choixCartePrivilegie.getForce(GEANT, saisonEnCours);

			for(Iterator<Carte> it = j.getMainDuJoueur().iterator(); it.hasNext();){
				Carte carteActive = it.next();
				if(carteActive.isAllie != true){
					if(j.getNbGraineDuJoueur() > 4){
						if(carteActive.getForce(ENGRAIS, saisonEnCours) > valSuperieure){
							choixCartePrivilegie = carteActive;
							valSuperieure = carteActive.getForce(ENGRAIS, saisonEnCours);
						}
					}else{
						choixCartePrivilegie = j.getMainDuJoueur().get(0);
						valSuperieure = choixCartePrivilegie.getForce(GEANT, saisonEnCours);
						
						if(carteActive.getForce(GEANT, saisonEnCours) > valSuperieure){
							choixCartePrivilegie = carteActive;
							valSuperieure = carteActive.getForce(GEANT, saisonEnCours);
						}
					}
				}
		}
			System.out.println("La méthode choisirCarte de DefensiveStrategy retourne la carte " + choixCartePrivilegie.getNom());
			System.out.println("La valeur de cette carte est : " + choixCartePrivilegie.getForce(GEANT, saisonEnCours));
		return choixCartePrivilegie;
	}

	public void choisirAction(Carte c, Manche m, Partie p, Joueur j, Class i) {
		System.out.println("Le joueur virtuel choisi son action...");
		System.out.println("La strategie est defensive donc il va choisir l'action GEANT ou bien ENGRAIS");
		
		if(utiliserGeant){  // Je pense qu'il faudrait déplacer le test pour plus d'optimisation..
			i.choisirGeant(j, m, p);
			Method[] x = i.getClass().getMethods();
			System.out.println("Le joueur virtuel à joué l'action GEANT");
		}else{
			if(i.getForce(ENGRAIS, m.getSaisonEnCours()) <= j.getNbGraineDuJoueur()){
				i.choisirEngrais(j, m, p);
				System.out.println("Le joueur virtuel à joué l'action ENGRAIS");
			}else{
				i.choisirFarfadet(j, m, p);
				System.out.println("Le joueur virtuel à joué l'action FARFADET");
			}	
		}
	}
}
