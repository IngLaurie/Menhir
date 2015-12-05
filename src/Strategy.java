
public interface Strategy {
	
	/*public void jouerDefensif();
	public void jouerOffensif();*/
	public void jouerCarte(Manche m, Partie p, Joueur j);
		public Carte choisirCarte(Manche m, Partie p, Joueur j);
		public void choisirAction(Carte c, Manche m, Partie p, Joueur j);
		
}