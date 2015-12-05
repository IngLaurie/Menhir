
public class ChienDeGarde extends Carte{

	public ChienDeGarde(String nom, int[] tabValCarte) {
		super(nom, tabValCarte);
	}

	public int getForce (int saison) {
		return super.getForce(saison);
	}
	
	public void choisirAction(Joueur j, Manche m, Partie p) {
		super.choisirAction(j, m, p);
		j.setNbChiens(this.getForce(m.getSaisonEnCours()));
		System.out.println("Vos chiens de garde permettent d'empêcher le vol de " +j.getNbChiens()+ " graines");
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("                   " + this.getNom() + "\n");
		sb.append("         Primpt.  Ete  Automne  Hiver\n");
		sb.append("Chien       " + this.getForce(0) + "      " + this.getForce(1) + "      " + this.getForce(2) + "       " + this.getForce(3) + "\n");
		return sb.toString();
	}

}
