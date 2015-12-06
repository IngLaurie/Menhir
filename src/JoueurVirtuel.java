import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JoueurVirtuel extends Joueur implements Strategy {
	
	String strategieDuJVirtuel;
	private int indice;
	private Strategy strategy;	
 
	public JoueurVirtuel(int i) {
		this.indice = i;
		this.nom = "JoueurV"+i;  
		this.age = (int) (Math.random() * 88 ); 
		System.out.println("Age de JoueurV" + this.indice + " = " + this.age);
		int leNbRecup = this.attributionStrategieAJoueur();
		this.indiceDeStratDuJoueurVirtuel = leNbRecup;
		isJoueurPhysique = false;
		
		if(this.indiceDeStratDuJoueurVirtuel == 0){
			this.strategy = new OffensiveStrategy();
			//Context context0 = new Context(new OffensiveStrategy(Offensive));
			//strat.executeStrategy(m,p,j,i);
		}else{
			this.strategy = new DefensiveStrategy();
			//Context context1 = new Context(new DefensiveStrategy(Defensive));
			//context1.executeStrategy(m,p,j,i);
		}
	}

	/*public void executeStrategy(Joueur j, Manche m, Partie p, Carte c){
		// on execute la strategy
		// exemple de return :
		System.out.println("Execution de executeStrategy dans context");
		//strategy.jouerCarte(m,p,j,i);
		strategy.jouerCarte(j,m,p,c);
	}*/

/* 		
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

	public Strategy getStrategy() {
		super.getStrategy();
		return strategy;
	}

	public void jouerCarte(Joueur j, Manche m, Partie p) {
		// TODO Auto-generated method stub
		
	}

	public void choisirCarte(Manche m, Partie p, Joueur j) {
		// TODO Auto-generated method stub
	}

	public void choisirAction(Carte c, Manche m, Partie p, Joueur j) {
		// TODO Auto-generated method stub
		
	}
}
