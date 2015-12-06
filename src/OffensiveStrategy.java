import java.util.Iterator;

// EN COURS DE TEST ----

public class OffensiveStrategy implements Strategy {
	private String nomStrat;
	private boolean utiliserFarfadet;
	private final int ENGRAIS = 2;
	private final int FARFADET = 3;
	
	public OffensiveStrategy(String strat) {
		super();
		this.nomStrat = strat;
		this.utiliserFarfadet = false;
	}

	public void jouerCarte(Manche m, Partie p, Joueur j, Ingredient i) {
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
		valSuperieure = choixCartePrivilegie.getForce(FARFADET, saisonEnCours);

		for(Iterator<Carte> it = j.getMainDuJoueur().iterator(); it.hasNext();){
			Carte carteActive = it.next();
			if(carteActive.isAllie != true){
				
				// si encore des g = on fait des menhirs (+ tester si nombre assez de graines pour faire des menhirs
				if(j.getNbGraineDuJoueur() == 0){
					if(carteActive.getForce(FARFADET, saisonEnCours) > valSuperieure){
						choixCartePrivilegie = carteActive;
						valSuperieure = carteActive.getForce(FARFADET, saisonEnCours);
						utiliserFarfadet = true;
					}else{
						choixCartePrivilegie = carteActive;
						valSuperieure = carteActive.getForce(ENGRAIS, saisonEnCours);
						
						if(carteActive.getForce(ENGRAIS, saisonEnCours) > valSuperieure){
							choixCartePrivilegie = carteActive;
							valSuperieure = carteActive.getForce(ENGRAIS, saisonEnCours);
						}
					}
				}
			}
		}
		System.out.println("La méthode choisirCarte de OffensiveStrategy retourne la carte " + choixCartePrivilegie.getNom());
		System.out.println("La valeur de cette carte est : " + choixCartePrivilegie.getForce(FARFADET, saisonEnCours));
	
		return choixCartePrivilegie;
	}

	public void choisirAction(Carte c, Manche m, Partie p, Joueur j, Ingredient i) {
		System.out.println("Le joueur virtuel choisi son action...");
		System.out.println("La strategie est offensive donc il va choisir l'action FARFADET ou bien ENGRAIS");
		
		if(utiliserFarfadet){
			i.choisirFarfadet(j, m, p);
			System.out.println("Le joueur virtuel à joué l'action FARFADET");
		}else{
			if(i.getForce(ENGRAIS, m.getSaisonEnCours()) <= j.getNbMenhirDuJoueur()){
				i.choisirEngrais(j, m, p);
				System.out.println("Le joueur virtuel à joué l'action ENGRAIS");
			}else{
				i.choisirGeant(j, m, p);
				System.out.println("Le joueur virtuel à joué l'action GEANT");
			}
		}
	}

	public void jouerCarte(Manche m, Partie p) {
		// TODO Auto-generated method stub
		
	}

	public void jouerCarte(Joueur j, Manche m, Partie p, Class i) {
		// TODO Auto-generated method stub
		
	}

	public void choisirAction(Carte c, Manche m, Partie p, Joueur j, Class i) {
		// TODO Auto-generated method stub
		
	}
}
