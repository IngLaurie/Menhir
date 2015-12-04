
public interface Strategy {
	
	/*public void jouerDefensif();
	public void jouerOffensif();*/
	public void jouerCarte(Manche m, Partie p);
		public Carte choisirCarte(Manche m, Partie p);
		public void choisirAction(Carte c, Manche m, Partie p);
		
}