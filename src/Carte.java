
public class Carte {

	private String nom;
	private int[][] tableauIng;
	private int[] tableauAlli;
	protected boolean isAllie;
	
	public Carte(String nom, int[][] tabValCarte) {
		this.nom = nom;
		this.tableauIng = tabValCarte;
		this.tableauAlli = null;
		this.isAllie = false;
	}
	
	public Carte(String nom, int[] tabValCarte) {
		this.nom = nom;
		this.tableauIng = null;
		this.tableauAlli = tabValCarte;
	}
	
	public String getNom(){
		return this.nom;
	}
	

	public int getForce(int action, int saison) {
		return this.tableauIng[action][saison];
	}
	
	public int getForce(int saison) {
		return this.tableauAlli[saison];
	}

	public void choisirAction(Joueur j, Manche m, Partie p) {
		
	}
	
	public void choisirGeant(Joueur j, Manche m, Partie p) {
		
	};
	public void choisirEngrais(Joueur j, Manche m, Partie p) {
		
	};
	public void choisirFarfadet(Joueur j, Manche m, Partie p) {
		
	};
}
