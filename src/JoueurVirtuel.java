import java.util.Random;

public class JoueurVirtuel extends Joueur {
	
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
		}else{
			this.strategy = new DefensiveStrategy();
		}
	}

/* 		
	}*/
	
	public int attributionStrategieAJoueur(){
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
}
