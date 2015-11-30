
public class JeuDuMenhir {

	public static void main(String[] args) {
				
		//Partie p = new Partie();
		//p.lancerPartie(); 

		int tabIng1[][] = {{1, 1, 1, 1},{2, 0, 1, 1},{2, 0, 2, 0}};
		
		Ingredient ingtest = new Ingredient("test", tabIng1);
		
		System.out.println("test");
		
		System.out.println(ingtest.toString());
		
		System.out.println("test"); 
		
		StringBuffer sb = new StringBuffer();
		sb.append(" P  E  A  H\n");
		sb.append("blabla");
		
		System.out.println(sb);
		System.out.println(sb.toString());
		
		//Test de l'affichage des cartes OK BORDEL J'AI COMPRIS
		
		
	}

}
