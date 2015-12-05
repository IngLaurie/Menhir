import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JoueurVirtuel extends Joueur implements Strategy {
	
	private static final String Defensive = null;
	private static final String Offensive = null;
	private ArrayList<Strategy> listeStrategies = new ArrayList<Strategy>();
	String strategieDuJVirtuel;
	private int indice;
	private int indiceDeStratDuJoueurVirtuel;
 
	public JoueurVirtuel(int i) {
		this.indice = i;
		this.nom = "JoueurV"+i;  
		this.age = (int) (Math.random() * 88 ); 
		System.out.println("Age de JoueurV" + this.indice + " = " + this.age);
		int leNbRecup = this.attributionStrategieAJoueur();
		//System.out.println("Dans le constructeur de JV, le nb récupéré est " + leNbRecup);
		this.indiceDeStratDuJoueurVirtuel = leNbRecup;
		isJoueurPhysique = false;
		
		/*if(leNbRecup == 0){
			//Context context = new Context(new OffensiveStrategy());
			//System.out.println(" " + context.executeStrategy());
			//System.out.println("");
		}else{
			this.strategieDuJVirtuel = "Defensif";
		}*/
		
	}


	public void jouerCarte(Manche m, Partie p, Joueur j) {
		// le joueur virtuel choisi sa carte
		//super.jouerCarte(m, p);
		//this.choisirCarte(m, p);
		
		if(this.indiceDeStratDuJoueurVirtuel == 0){
			Context context0 = new Context(new OffensiveStrategy(Offensive));
			context0.executeStrategy(m,p,j);
		}else{
			Context context1 = new Context(new DefensiveStrategy(Defensive));
			context1.executeStrategy(m,p,j);
		}
	}

	/*@Override
	public Carte choisirCarte(Manche m, Partie p) {
		System.out.println("\nAu tour de " + this.getNom() + " de jouer!\n");
		this.afficherMainJoueur();
		System.out.println("Le joueur virtuel " + this.getNom() + " joue une carte !");
		
		Scanner scanCarte = new Scanner(System.in);
		int choixCarte = scanCarte.nextInt();
		
		return super.choisirCarte(m,p);
		
		
	}*/
	
	
	public int attributionStrategieAJoueur(){
		Strategy strat;
		Random rn = new Random();
		int leNbAleatoire = rn.nextInt(2);
		
		System.out.println("Le nb aleatoire est " + leNbAleatoire);
			
		return leNbAleatoire;
	}
	
	

	public String getNom() {
		return nom;
	}


	/*@Override
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
	}*/


	/*public void jouerCarte() {
		// TODO Auto-generated method stub
		
	}*/
}
