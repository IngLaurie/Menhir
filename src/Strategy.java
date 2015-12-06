
public interface Strategy {
	
	/*public void jouerDefensif();
	public void jouerOffensif();*/
	//public void jouerCarte(Manche m, Partie p, Joueur j, Ingredient i);
	public void jouerCarte(Joueur j, Manche m, Partie p, Class i);
	//public void jouerCarte(Manche m, Partie p);
		public Carte choisirCarte(Manche m, Partie p, Joueur j);
		public void choisirAction(Carte c, Manche m, Partie p, Joueur j, Class i);
		
}