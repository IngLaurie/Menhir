import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import javax.swing.text.html.HTMLDocument.Iterator;
// gérer le nombre de points de chaque joueurs 

public class Manche {

	private static final int NBMAXCARTEPRAPIDE = 4;
	private int nbManche;
	// private int saisonEnCours;
	private String listeSaison[] = new String[4]; // hiver printemps été automne
	
	private ArrayList<Carte> listeCartesJ = new ArrayList<Carte>();

		
	// /!\ faire 2 listes de cartes ? + faire appel aux listes en fonction du type de partie ??
	// faire un SET ? 
	public Manche(Partie p){
		if(p.getPartieAvancee()){
			// autant de manches que de joueurs
			this.nbManche = p.getNbJPhysique() + p.getNbJVirtuel();
			// cartes de la partie rapide + cartes alliés
			
			int tabIng1[][] = {{1, 1, 1, 1},{2, 0, 1, 1},{2, 0, 2, 0}};
			int tabIng2[][] = {{2, 0, 1, 1},{1, 3, 0, 0},{0, 1, 2, 1}};
			int tabIng3[][] = {{0, 0, 4, 0},{0, 2, 2, 0},{0, 0, 1, 3}};
			int tabIng4[][] = {{1, 3, 1, 0},{1, 2, 1, 1},{0, 1, 4, 0}};
			int tabIng5[][] = {{2, 1, 1, 1},{1, 0, 2, 2},{3, 0, 0, 2}};
			int tabIng6[][] = {{1, 2, 2, 0},{1, 1, 2, 1},{2, 0, 1, 2}};
			int tabIng7[][] = {{2, 1, 1, 2},{1, 1, 1, 3},{2, 0, 2, 2}};
			int tabIng8[][] = {{0, 3, 0, 3},{2, 1, 3, 0},{1, 1, 3, 1}};
			int tabIng9[][] = {{1, 2, 1, 2},{1, 0, 1, 4},{2, 4, 0, 0}};
			int tabIng10[][] = {{1, 3, 1, 2},{2, 1, 2, 2},{0, 0, 3, 4}};
			int tabIng11[][] = {{2, 2, 0, 3},{1, 1, 4, 1},{1, 2, 1, 3}};
			int tabIng12[][] = {{2, 2, 3, 1},{2, 3, 0, 3},{1, 1, 3, 3}};	
			int tabIng13[][] = {{2, 2, 3, 1},{2, 3, 0, 3},{1, 1, 3, 3}};
			int tabIng14[][] = {{2, 2, 2,2},{0, 4, 4,0},{1, 3, 2, 2}};
			int tabIng15[][] = {{3, 1, 3, 1},{1, 4, 2, 1},{2, 4, 1, 1}};
			int tabIng16[][] = {{4, 1, 1, 1},{1, 2, 1, 3},{1, 2, 2, 2}};
			int tabIng17[][] = {{2, 3, 2, 0},{0, 4, 3, 0},{2, 1, 1, 3}};
			int tabIng18[][] = {{2, 2, 3, 0},{1, 1, 1, 4},{2, 0, 3, 2}};
			int tabIng19[][] = {{3, 1, 4, 1},{2, 1, 3, 3},{2, 3, 2, 2}};
			int tabIng20[][] = {{2, 4, 1, 2},{2, 2, 2, 3},{1, 4, 3, 1}};	
			int tabIng21[][] = {{3, 3, 3, 0},{1, 3, 3, 2},{2, 3, 1, 3}};
			int tabIng22[][] = {{1, 2, 2, 1},{1, 2, 3, 0},{0, 2, 2, 2}};
			int tabIng23[][] = {{4, 0, 1, 1},{1, 1, 3, 1},{0, 0, 3, 3}};
			int tabIng24[][] = {{2, 0, 1, 3},{0, 3, 0, 3},{1, 2, 2, 1}};
			
			int tabChienDeGarde1[] = {1, 1, 1, 1};
			int tabChienDeGarde2[] = {0, 2, 2, 0};
			int tabChienDeGarde3[] = {0, 1, 2, 1};
			int tabTaupeGeante1[] = {2, 0, 2, 0};
			int tabTaupeGeante2[] = {1, 2, 0, 1};
			int tabTaupeGeante3[] = {0, 1, 3, 0};
			
			/* CARTES RESTANTES :
			 * 
			 * verso Menhir
			 * champ
			 * autre verso (verso alliés ?)
			 * comptage de points
			 */
			
			// max 6 joueurs / 1 type de cartes = 3 actions possibles 
			this.listeCartesJ.add(new Ingredient("ing1", tabIng1));
			this.listeCartesJ.add(new Ingredient("ing2", tabIng2));
			this.listeCartesJ.add(new Ingredient("ing3", tabIng3));
			this.listeCartesJ.add(new Ingredient("ing4", tabIng4));
			this.listeCartesJ.add(new Ingredient("ing5", tabIng5));
			this.listeCartesJ.add(new Ingredient("ing6", tabIng6));
			this.listeCartesJ.add(new Ingredient("ing7", tabIng7));
			this.listeCartesJ.add(new Ingredient("ing8", tabIng8));
			this.listeCartesJ.add(new Ingredient("ing9", tabIng9));
			this.listeCartesJ.add(new Ingredient("ing10", tabIng10));
			this.listeCartesJ.add(new Ingredient("ing11", tabIng11));
			this.listeCartesJ.add(new Ingredient("ing12", tabIng12));
			this.listeCartesJ.add(new Ingredient("ing13", tabIng13));
			this.listeCartesJ.add(new Ingredient("ing14", tabIng14));
			this.listeCartesJ.add(new Ingredient("ing15", tabIng15));
			this.listeCartesJ.add(new Ingredient("ing16", tabIng16));
			this.listeCartesJ.add(new Ingredient("ing17", tabIng17));
			this.listeCartesJ.add(new Ingredient("ing18", tabIng18));
			this.listeCartesJ.add(new Ingredient("ing19", tabIng19));
			this.listeCartesJ.add(new Ingredient("ing20", tabIng20));
			this.listeCartesJ.add(new Ingredient("ing21", tabIng21));
			this.listeCartesJ.add(new Ingredient("ing22", tabIng22));
			this.listeCartesJ.add(new Ingredient("ing23", tabIng23));
			this.listeCartesJ.add(new Ingredient("ing24", tabIng24));
			
			
			this.listeCartesJ.add(new ChienDeGarde("CdG1", tabChienDeGarde1));
			this.listeCartesJ.add(new ChienDeGarde("CdG2", tabChienDeGarde2));
			this.listeCartesJ.add(new ChienDeGarde("CdG3", tabChienDeGarde3));
			this.listeCartesJ.add(new ChienDeGarde("TaupeG1", tabTaupeGeante1));
			this.listeCartesJ.add(new ChienDeGarde("TaupeG2", tabTaupeGeante2));
			this.listeCartesJ.add(new ChienDeGarde("TaupeG3", tabTaupeGeante3));
			

			// on mélange les cartes 
			Collections.shuffle(listeCartesJ);	
			
			// 
		}else{  // partie rapide
			this.nbManche = 1;
			// création de la manche
			// cartes de la partie rapide seulement
			int tabIng1[][] = {{1, 1, 1, 1},{2, 0, 1, 1},{2, 0, 2, 0}};
			int tabIng2[][] = {{2, 0, 1, 1},{1, 3, 0, 0},{0, 1, 2, 1}};
			int tabIng3[][] = {{0, 0, 4, 0},{0, 2, 2, 0},{0, 0, 1, 3}};
			int tabIng4[][] = {{1, 3, 1, 0},{1, 2, 1, 1},{0, 1, 4, 0}};
			int tabIng5[][] = {{2, 1, 1, 1},{1, 0, 2, 2},{3, 0, 0, 2}};
			int tabIng6[][] = {{1, 2, 2, 0},{1, 1, 2, 1},{2, 0, 1, 2}};
			int tabIng7[][] = {{2, 1, 1, 2},{1, 1, 1, 3},{2, 0, 2, 2}};
			int tabIng8[][] = {{0, 3, 0, 3},{2, 1, 3, 0},{1, 1, 3, 1}};
			int tabIng9[][] = {{1, 2, 1, 2},{1, 0, 1, 4},{2, 4, 0, 0}};
			int tabIng10[][] = {{1, 3, 1, 2},{2, 1, 2, 2},{0, 0, 3, 4}};
			int tabIng11[][] = {{2, 2, 0, 3},{1, 1, 4, 1},{1, 2, 1, 3}};
			int tabIng12[][] = {{2, 2, 3, 1},{2, 3, 0, 3},{1, 1, 3, 3}};	
			int tabIng13[][] = {{2, 2, 3, 1},{2, 3, 0, 3},{1, 1, 3, 3}};
			int tabIng14[][] = {{2, 2, 2,2},{0, 4, 4,0},{1, 3, 2, 2}};
			int tabIng15[][] = {{3, 1, 3, 1},{1, 4, 2, 1},{2, 4, 1, 1}};
			int tabIng16[][] = {{4, 1, 1, 1},{1, 2, 1, 3},{1, 2, 2, 2}};
			int tabIng17[][] = {{2, 3, 2, 0},{0, 4, 3, 0},{2, 1, 1, 3}};
			int tabIng18[][] = {{2, 2, 3, 0},{1, 1, 1, 4},{2, 0, 3, 2}};
			int tabIng19[][] = {{3, 1, 4, 1},{2, 1, 3, 3},{2, 3, 2, 2}};
			int tabIng20[][] = {{2, 4, 1, 2},{2, 2, 2, 3},{1, 4, 3, 1}};	
			int tabIng21[][] = {{3, 3, 3, 0},{1, 3, 3, 2},{2, 3, 1, 3}};
			int tabIng22[][] = {{1, 2, 2, 1},{1, 2, 3, 0},{0, 2, 2, 2}};
			int tabIng23[][] = {{4, 0, 1, 1},{1, 1, 3, 1},{0, 0, 3, 3}};
			int tabIng24[][] = {{2, 0, 1, 3},{0, 3, 0, 3},{1, 2, 2, 1}};
			
			
			/* CARTES RESTANTES :
			 * 
			 * verso Menhir
			 * champ
			 * autre verso (verso alliés ?)
			 * comptage de points
			 */
			
			// max 6 joueurs / 1 type de cartes = 3 actions possibles 
			this.listeCartesJ.add(new Ingredient("ing1", tabIng1));
			this.listeCartesJ.add(new Ingredient("ing2", tabIng2));
			this.listeCartesJ.add(new Ingredient("ing3", tabIng3));
			this.listeCartesJ.add(new Ingredient("ing4", tabIng4));
			this.listeCartesJ.add(new Ingredient("ing5", tabIng5));
			this.listeCartesJ.add(new Ingredient("ing6", tabIng6));
			this.listeCartesJ.add(new Ingredient("ing7", tabIng7));
			this.listeCartesJ.add(new Ingredient("ing8", tabIng8));
			this.listeCartesJ.add(new Ingredient("ing9", tabIng9));
			this.listeCartesJ.add(new Ingredient("ing10", tabIng10));
			this.listeCartesJ.add(new Ingredient("ing11", tabIng11));
			this.listeCartesJ.add(new Ingredient("ing12", tabIng12));
			this.listeCartesJ.add(new Ingredient("ing13", tabIng13));
			this.listeCartesJ.add(new Ingredient("ing14", tabIng14));
			this.listeCartesJ.add(new Ingredient("ing15", tabIng15));
			this.listeCartesJ.add(new Ingredient("ing16", tabIng16));
			this.listeCartesJ.add(new Ingredient("ing17", tabIng17));
			this.listeCartesJ.add(new Ingredient("ing18", tabIng18));
			this.listeCartesJ.add(new Ingredient("ing19", tabIng19));
			this.listeCartesJ.add(new Ingredient("ing20", tabIng20));
			this.listeCartesJ.add(new Ingredient("ing21", tabIng21));
			this.listeCartesJ.add(new Ingredient("ing22", tabIng22));
			this.listeCartesJ.add(new Ingredient("ing23", tabIng23));
			this.listeCartesJ.add(new Ingredient("ing24", tabIng24));
			
			
			// on mélange les cartes 
			Collections.shuffle(listeCartesJ);	
			
		}
	}
	
	public void distribuerCarteJoueur(Partie p){
		if(p.getPartieAvancee()){
			
		}else{ // partie rapide
			// une partie rapide = 4 tours de jeu 
			// chaque joueur place devant lui un champ et pose à côté 2 graines 
			
			
			
			// on distribue 4 cartes ingrédient par joueur	
			int cpt = 1;
				for(Joueur joueur: p.getListeJoueur()){
					for(Carte carte: this.listeCartesJ){
						joueur.getMainDuJoueur().add(carte);
						// on distribue que cartes par joueur 
						if(cpt == 4){
							break;
						}else{
							cpt++;
						}
					}
					
					// on supprime les cartes dans listeCartesJ
					/* on supp uniquement les cartes que l'on a mis dans la main du joueur
					   pour que les joueurs aient des cartes différentes */
					this.listeCartesJ.removeAll(joueur.getMainDuJoueur());
					cpt = 1;
				}
		}
	}
	
	public void jouerManche(){
		// gérer les graines 	
		// faire jouer le plus jeune joueur
		
		// à tour de rôle, les joueurs posent une carte 
		// + choisir action à effectuer
		
	}
	
	public void nouvelleManche(){
		
	}
	
	public void changerSaison(){
		
	}

}
