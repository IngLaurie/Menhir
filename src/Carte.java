
public abstract class Carte {

	private String nom;
	private String cheminImage;
	private int num;
	private String identifiant;
	private int[][] tableauIng;
	private int[] tableauAlli;
	protected boolean isAllie;
	
	public Carte(String nom, int[][] tabValCarte) {
		this.nom = nom;
		this.tableauIng = tabValCarte;
		this.tableauAlli = null;
		//this.identifiant = id;
		//this.cheminImage = "img/" + nom + ".png";
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
	
	public String getCheminImage(){
		return this.cheminImage;
	}

	public int getForce(int action, int saison) {
		return this.tableauIng[action][saison];
	}
	
	public int getForce(int saison) {
		return this.tableauAlli[saison];
	}

	public void choisirAction(Joueur j, Manche m, Partie p) {
		
	}
	
	public abstract void choisirGeant(Joueur j, Manche m, Partie p);
	public abstract void choisirEngrais(Joueur j, Manche m, Partie p);
	public abstract void choisirFarfadet(Joueur j, Manche m, Partie p);
}
