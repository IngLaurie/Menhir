
public interface Strategy {
	
	//public void jouerCarte(Joueur j, Manche m, Partie p);
		public Carte choisirCarte(Manche m, Partie p, Joueur j);
		public void choisirAction(Carte c, Manche m, Partie p, Joueur j);
}