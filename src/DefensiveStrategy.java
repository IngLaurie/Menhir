import java.util.Iterator;

public class DefensiveStrategy implements Strategy {

	private boolean utiliserGeant;
	private final int GEANT = 1;
	private final int ENGRAIS = 2;
	
	public DefensiveStrategy() {
		super();
		this.utiliserGeant = false;
	}

	public Carte choisirCarte(Manche m, Partie p, Joueur j) {
		System.out.println("\nAu tour de joueur virtuel " + "de jouer!\n");
		System.out.println("Le joueur virtuel choisi sa carte...");
		
		int saisonEnCours = m.getSaisonEnCours();
		Carte choixCartePrivilegie = null;
		int valSuperieure = 0;
			
		choixCartePrivilegie = j.getMainDuJoueur().get(0);
		valSuperieure = choixCartePrivilegie.getForce(GEANT -1, saisonEnCours);

		for(Iterator<Carte> it = j.getMainDuJoueur().iterator(); it.hasNext();){
			Carte carteActive = it.next();
			if(carteActive.isAllie = false){
				if(j.getNbGraineDuJoueur() > 4){
					if(carteActive.getForce(ENGRAIS -1, saisonEnCours) > valSuperieure){
						choixCartePrivilegie = carteActive;
						valSuperieure = carteActive.getForce(ENGRAIS -1, saisonEnCours);
					}
				}else{
					utiliserGeant = true;
					choixCartePrivilegie = j.getMainDuJoueur().get(0);
					valSuperieure = choixCartePrivilegie.getForce(GEANT -1, saisonEnCours);
					
					if(carteActive.getForce(GEANT -1, saisonEnCours) > valSuperieure){
						choixCartePrivilegie = carteActive;
						valSuperieure = carteActive.getForce(GEANT -1, saisonEnCours);
					}
				}
			}
		}
		System.out.println("La m�thode choisirCarte de DefensiveStrategy retourne la carte " + choixCartePrivilegie.getNom());
		System.out.println("La valeur de cette carte est : " + choixCartePrivilegie.getForce(GEANT -1, saisonEnCours));
		return choixCartePrivilegie;
	}

	public void choisirAction(Carte c, Manche m, Partie p, Joueur j) {
		System.out.println("Le joueur virtuel choisi son action...");
		System.out.println("La strategie est defensive donc il va choisir l'action GEANT ou bien ENGRAIS, voire FARFADET");
		
		if(utiliserGeant){ 
			c.choisirGeant(j,m,p);		
			System.out.println("Le joueur virtuel � jou� l'action GEANT");
		}else{
			if(c.getForce(ENGRAIS, m.getSaisonEnCours()) <= j.getNbGraineDuJoueur()){
				c.choisirEngrais(j, m, p);
				System.out.println("Le joueur virtuel � jou� l'action ENGRAIS");
			}else{
				c.choisirFarfadet(j, m, p);
				System.out.println("Le joueur virtuel � jou� l'action FARFADET");
			}	
		}
	}
}
