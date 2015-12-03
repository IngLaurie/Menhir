
public class TaupeGeante extends Carte {

	public TaupeGeante(String nom, int[] tabValCarte) {
		super(nom, tabValCarte);
	}

	public void enleverMenhir(int saisonEnCours, Joueur joueur, int nbMenhirDuJoueur){
		
	}
	
	public int getForce (int saison) {
		return super.getForce(saison);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("                   " + this.getNom() + "\n");
		sb.append("         Primpt.  Ete  Automne  Hiver\n");
		sb.append("Taupe       " + this.getForce(0) + "      " + this.getForce(1) + "      " + this.getForce(2) + "       " + this.getForce(3) + "\n");
		return sb.toString();
	}

}
