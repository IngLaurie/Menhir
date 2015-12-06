
public class TaupeGeante extends Carte {
	
	
	public TaupeGeante(String nom, int[] tabValCarte) {
		super(nom, tabValCarte);
		this.isAllie = true;
	}
	
	public int getForce (int saison) {
		return super.getForce(saison);
	}
	
	public void choisirAction(Joueur j, Manche m, Partie p) {
		super.choisirAction(j, m, p);
		System.out.println("Veuillez choisir un joueur: \n");
		Joueur joueurChoisi = j.choisirJoueur(p.getListeJoueur());
		if (joueurChoisi.getNbMenhirDuJoueur() < this.getForce(m.getSaisonEnCours())) {
			joueurChoisi.setNbMenhirDuJoueur(0);
			System.out.println(joueurChoisi.getNom()+ " avait moins de ménhirs que la force de votre carte, il a désormais 0 ménhirs!");
		}else{
			if (joueurChoisi.getNbMenhirDuJoueur() <= this.getForce(m.getSaisonEnCours())) {
				joueurChoisi.setNbMenhirDuJoueur(joueurChoisi.getNbMenhirDuJoueur()-this.getForce(m.getSaisonEnCours()));
				System.out.println("Vous avez retiré " +this.getForce(m.getSaisonEnCours())+ "ménhirs du champe de " +joueurChoisi.getNom()+ ", il lui en reste " +joueurChoisi.getNbMenhirDuJoueur());
			}
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("                   " + this.getNom() + "\n");
		sb.append("         Primpt.  Ete  Automne  Hiver\n");
		sb.append("Taupe       " + this.getForce(0) + "      " + this.getForce(1) + "      " + this.getForce(2) + "       " + this.getForce(3) + "\n");
		return sb.toString();
	}

}
