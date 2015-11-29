
public class Carte {

	private String nom;
	private String cheminImage;
	private int num;
	private String identifiant;
	private int[][] tableau;
	
	public Carte(String nom, int[][] tabValCarte) {
		//super();
		//this.num = numero;
		this.nom = nom;
		this.tableau = tabValCarte;
		//this.identifiant = id;
		//this.cheminImage = "img/" + nom + ".png";
	}
	
	public Carte(String nom, int[] tabValCarte) {
		this.nom = nom;
	}
	//Constructeur carte allié
	
	public String getNom(){
		return this.nom;
	}
	
	public String getCheminImage(){
		return this.cheminImage;
	}

	public String afficherCarte(){
		//System.out.println(this.nom);
		return this.nom ;
	}
	
	public int[][] getTableau() {
		return this.tableau;
	}
	
	
	// public static Carte[] initialiserCarte(){}
	
}
