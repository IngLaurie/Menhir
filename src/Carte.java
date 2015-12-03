
public class Carte {

	private String nom;
	private String cheminImage;
	private int num;
	private String identifiant;
	private int[][] tableauIng;
	private int[] tableauAlli;
	
	public Carte(String nom, int[][] tabValCarte) {
		this.nom = nom;
		this.tableauIng = tabValCarte;
		this.tableauAlli = null;
		//this.identifiant = id;
		//this.cheminImage = "img/" + nom + ".png";
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


	// test
	public int getForce(int action, int saison) {
	//public int getForce(int action, String saison) {
		return this.tableauIng[action][saison];
	}
	
	public int getForce(int saison) {
		return this.tableauAlli[saison];
	}
	
	
	// public static Carte[] initialiserCarte(){}
	
}
