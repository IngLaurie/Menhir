import java.util.Arrays;


public class Ingredient extends Carte {

	public Ingredient(String nom, int[][] tabValCarte) {
		super(nom, tabValCarte);
	}
	
	public int getForce(int action, int saison) {
		return super.getForce(action, saison);
	}
	
	public String getNom() {
		return super.getNom();
	}

	//private Arrays valeurCarteIngredient;
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("                   " + this.getNom() + "\n");
		sb.append("         Primpt.  Ete  Automne  Hiver\n");
		sb.append("Géant       " + this.getForce(0, 0) + "      " + this.getForce(0, 1) + "      " + this.getForce(0, 2) + "       " + this.getForce(0, 3) + "\n");
		sb.append("Engrais     " + this.getForce(1, 0) + "      " + this.getForce(1, 1) + "      " + this.getForce(1, 2) + "       " + this.getForce(1, 3) + "\n");
		sb.append("Farfadet    " + this.getForce(2, 0) + "      " + this.getForce(2, 1) + "      " + this.getForce(2, 2) + "       " + this.getForce(2, 3) + "\n");
		return sb.toString();
	}
	


}
