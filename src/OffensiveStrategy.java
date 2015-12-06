import java.util.Iterator;

// EN COURS DE TEST ----

public class OffensiveStrategy implements Strategy {
	private String nomStrat;
	private boolean utiliserFarfadet;
	private final int ENGRAIS = 2;
	private final int FARFADET = 3;
	
	public OffensiveStrategy() {
		super();
		this.utiliserFarfadet = false;
	}

	/*public void jouerCarte(Manche m, Partie p, Joueur j, Ingredient i) {
		System.out.println("Execution du joueurCarte de " + this.nomStrat + "Strategy apr�s �tre pass� dans executeStrategy");

		Carte c = this.choisirCarte(m, p, j);
		this.choisirAction(c, m, p, j, i);
	}*/

	public Carte choisirCarte(Manche m, Partie p, Joueur j) {
		System.out.println("\nAu tour de joueur virtuel " + "de jouer!\n");
		System.out.println("Le joueur virtuel choisi sa carte...");
		
		int saisonEnCours = m.getSaisonEnCours();
		Carte choixCartePrivilegie = null;
		int valSuperieure = 0;
		
		choixCartePrivilegie = j.getMainDuJoueur().get(0);
		valSuperieure = choixCartePrivilegie.getForce(FARFADET -1, saisonEnCours);

		for(Iterator<Carte> it = j.getMainDuJoueur().iterator(); it.hasNext();){
			Carte carteActive = it.next();
			if(carteActive.isAllie != true){
				if(j.getNbGraineDuJoueur() == 0){
					if(carteActive.getForce(FARFADET -1, saisonEnCours) > valSuperieure){
						choixCartePrivilegie = carteActive;
						valSuperieure = carteActive.getForce(FARFADET -1, saisonEnCours);
						utiliserFarfadet = true;
					}else{
						choixCartePrivilegie = carteActive;
						valSuperieure = carteActive.getForce(ENGRAIS -1, saisonEnCours);
						
						if(carteActive.getForce(ENGRAIS -1, saisonEnCours) > valSuperieure){
							choixCartePrivilegie = carteActive;
							valSuperieure = carteActive.getForce(ENGRAIS -1, saisonEnCours);
						}
					}
				}
			}
		}
		System.out.println("La m�thode choisirCarte de OffensiveStrategy retourne la carte " + choixCartePrivilegie.getNom());
		System.out.println("La valeur de cette carte est : " + choixCartePrivilegie.getForce(FARFADET -1, saisonEnCours));
	
		return choixCartePrivilegie;
	}

	public void choisirAction(Carte c, Manche m, Partie p, Joueur j) {
		System.out.println("Le joueur virtuel choisi son action...");
		System.out.println("La strategie est offensive donc il va choisir l'action FARFADET ou bien ENGRAIS");
		
		if(utiliserFarfadet){
			c.choisirFarfadet(j, m, p);
			System.out.println("Le joueur virtuel � jou� l'action FARFADET");
		}else{
			if(c.getForce(ENGRAIS, m.getSaisonEnCours()) <= j.getNbMenhirDuJoueur()){
				c.choisirEngrais(j, m, p);
				System.out.println("Le joueur virtuel � jou� l'action ENGRAIS");
			}else{
				c.choisirGeant(j, m, p);
				System.out.println("Le joueur virtuel � jou� l'action GEANT");
			}
		}
	}
}
