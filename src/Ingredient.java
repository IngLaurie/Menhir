import java.util.Arrays;


public class Ingredient extends Carte {

	public Ingredient(String nom, int[][] tabValCarte) {
		super(nom, tabValCarte);
	}

	//private Arrays valeurCarteIngredient;
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" P  E  A  H\n");
		//sb.append(this.getTableau());
		return sb.toString();
	}
	//AFfichage d'une carte ingrédient


}
