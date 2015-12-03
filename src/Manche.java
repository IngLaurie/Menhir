import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
// g�rer le nombre de points de chaque joueurs - partie complexe surtout
// /!\ si demande d'ajouter une carte au jeu..

public class Manche {

	private static final int NBMAXCARTEPRAPIDE = 4;
	private int nbManche;
	private int saisonEnCours;
	private String listeSaison[] = {"printemps", "�t�", "automne", "hiver"};

	private ArrayList<Carte> listeCartesPA = new ArrayList<Carte>();
	private ArrayList<Carte> listeCPRapide = new ArrayList<Carte>();
	private ArrayList<Carte> listeCPAvancee = new ArrayList<Carte>();
		
	
	// faire un SET ?
	// v�rifier s'il y a pas trop de choses / � d�placer
	public Manche(Partie p){
		
		saisonEnCours = 0;
		
		if(p.getPartieAvancee()){
			// autant de manches que de joueurs
			this.nbManche = p.getNbJPhysique() + p.getNbJVirtuel();
			this.listeCartesPA.addAll(listeCPAvancee);
			this.listeCartesPA.addAll(listeCPRapide);
			// cartes de la partie rapide + cartes alli�s
			// on a ici l'ensemble des cartes n�cessaires pour la partie avancee 
			// on m�lange les cartes 
			// Collections.shuffle(listeCartesPA);	
			// 
		}else{  // partie rapide
			this.nbManche = 1;
			this.listeCartesPA.addAll(listeCPRapide);
			// cr�ation de la manche
			// cartes de la partie rapide seulement
			// on m�lange les cartes 
			
		}
	}
	
	public void setSaisonEnCours(int saisonEnCours) {
		this.saisonEnCours = saisonEnCours;
	}

	public void distribuerCarteJoueur(Partie p){
		if(p.getPartieAvancee()){
			// ici on utilise les cartes de listeCPRapide + listeCPAvancee 			
			// constructeur de manche mettre en param la liste de cartes  //
			// mettre en static final .. //
		}else{ 
			// partie rapide
			// une partie rapide = 4 tours de jeu 
			// chaque joueur place devant lui un champ et pose � c�t� 2 graines
				
			// ici on utilise les cartes de listeCPRapide
			
			this.initialisationListeCarte();
			Collections.shuffle(listeCPRapide);
			
			int cpt = 1;
				for(Joueur joueur: p.getListeJoueur()){
					for(Carte carte: this.listeCPRapide){
						joueur.getMainDuJoueur().add(carte);
						// on distribue que 4 cartes par joueur 
						if(cpt == 4){
							break;
						}else{
							cpt++;
						}
					}
					
					this.listeCPRapide.removeAll(joueur.getMainDuJoueur());
					cpt = 1;
				}
			   /*	
			    Joueur JoueurTmp;
				JoueurTmp = this.attribuerJoueurDeDebut(p);
				p.getListeJoueur().set(p.getListeJoueur().indexOf(JoueurTmp),p.getListeJoueur().get(0));
				p.getListeJoueur().set(0, JoueurTmp);
				*/
				// utilisation d'un swap � la place 
		}
	}

	public void attribuerJoueurDeDebut(Partie p){
		Joueur jQuiCommence = null;
		int cptLJ = 0;
		
		if(p.getListeJoueur().get(0).getAge() < p.getListeJoueur().get(1).getAge()){	
			jQuiCommence = p.getListeJoueur().get(0);
		}else{
			jQuiCommence = p.getListeJoueur().get(1);
		}
		for(int i=2; i<p.getListeJoueur().size(); i++){
			
			// voir si le joueur est le dernier element
			if(p.getListeJoueur().get(i).getAge() < jQuiCommence.getAge()){	
				jQuiCommence = p.getListeJoueur().get(i);
			}
			
		}
		int a = p.getListeJoueur().indexOf(p.getListeJoueur().get(0));
		int b = p.getListeJoueur().indexOf(jQuiCommence);
		
		Collections.swap(p.getListeJoueur(), a, b);
	}
	
	public int getSaisonEnCours() {
		return this.saisonEnCours;
	}
	
	public void jouerManche(Partie p){
		boolean partieAvancee = p.getPartieAvancee();
		if (partieAvancee) {
			//Distribuer les cartes
			//Faire jouer chaque joueur
			//Changer la saison
			//R�p�ter pour toutes les saisons
			//Lorsqu'on a fait toutes les saisons, retourner le nombre de graines de chaque joueur
		} else {
			//Distribuer les cartes
			this.attribuerJoueurDeDebut(p);
			this.distribuerCarteJoueur(p);
			//Faire jouer chaque joueur

			
			for (int i=0; i<4; i++) {
				for (Iterator<Joueur> it = p.getListeJoueur().iterator(); it.hasNext(); ) {
					Joueur joueurActif = it.next();
					System.out.println("SAISON EN COURS : " + this.listeSaison[this.getSaisonEnCours()]);
					joueurActif.jouerCarte(this, p);
				}
				this.changerSaison();

			}
			for (Iterator<Joueur> it = p.getListeJoueur().iterator(); it.hasNext();) {
				Joueur joueurActif = it.next();
				int tableauScore[] = new int[p.getListeJoueur().size()];
				tableauScore[p.getListeJoueur().indexOf(joueurActif)] = joueurActif.getNbMenhirDuJoueur();
			}
			
			
			//Changer la saison
			//R�p�ter pour toutes les saisons
			// A la fin de toutes les saison:
			//R�cup�rer le nombre de m�nhir de chaque joueur
			//En cas d'�galit�, r�cup�rer le nombre de graines
			//Mettre le(s) gagnants dans un tableau de joueur gagnant
		}
		
	}
	
	


	public void changerSaison(){
		int nouvSaison = this.saisonEnCours;
		System.out.println("La saison " + this.listeSaison[this.saisonEnCours] + "est termin�e.\n");
		nouvSaison++;
		if (nouvSaison == 4) {
			nouvSaison = 0;
			System.out.println("La manche est termin�e.");
		} else {
			System.out.println("La nouvelle saison est" +this.listeSaison[this.saisonEnCours]);
		}
		this.saisonEnCours = nouvSaison;
	}

	public void initialisationListeCarte(){
		
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
		int tabIng14[][] = {{2, 2, 2, 2},{0, 4, 4, 0},{1, 3, 2, 2}};
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
		//int tabIng25[][] = {{2, 0, 1, 3},{0, 3, 0, 3},{1, 2, 2, 1}};      // v�rifier s'il faut l'ajouter 
		
		
		// /!\ VERIFIER LES VALEURS
		int tabChienDeGarde1[] = {2, 0, 1, 3};
		int tabChienDeGarde2[] = {1, 2, 2, 1};
		int tabChienDeGarde3[] = {2, 0, 1, 3};
		int tabTaupeGeante1[] = {2, 0, 1, 3};
		int tabTaupeGeante2[] = {2, 0, 1, 3};
		int tabTaupeGeante3[] = {2, 0, 1, 3};
		
		this.listeCPRapide.add(new Ingredient("ing1", tabIng1));
		this.listeCPRapide.add(new Ingredient("ing2", tabIng2));
		this.listeCPRapide.add(new Ingredient("ing3", tabIng3));
		this.listeCPRapide.add(new Ingredient("ing4", tabIng4));
		this.listeCPRapide.add(new Ingredient("ing5", tabIng5));
		this.listeCPRapide.add(new Ingredient("ing6", tabIng6));
		this.listeCPRapide.add(new Ingredient("ing7", tabIng7));
		this.listeCPRapide.add(new Ingredient("ing8", tabIng8));
		this.listeCPRapide.add(new Ingredient("ing9", tabIng9));
		this.listeCPRapide.add(new Ingredient("ing10", tabIng10));
		this.listeCPRapide.add(new Ingredient("ing11", tabIng11));
		this.listeCPRapide.add(new Ingredient("ing12", tabIng12));
		this.listeCPRapide.add(new Ingredient("ing13", tabIng13));
		this.listeCPRapide.add(new Ingredient("ing14", tabIng14));
		this.listeCPRapide.add(new Ingredient("ing15", tabIng15));
		this.listeCPRapide.add(new Ingredient("ing16", tabIng16));
		this.listeCPRapide.add(new Ingredient("ing17", tabIng17));
		this.listeCPRapide.add(new Ingredient("ing18", tabIng18));
		this.listeCPRapide.add(new Ingredient("ing19", tabIng19));
		this.listeCPRapide.add(new Ingredient("ing20", tabIng20));
		this.listeCPRapide.add(new Ingredient("ing21", tabIng21));
		this.listeCPRapide.add(new Ingredient("ing22", tabIng22));
		this.listeCPRapide.add(new Ingredient("ing23", tabIng23));
		this.listeCPRapide.add(new Ingredient("ing24", tabIng24));
		//this.listeCPRapide.add(new Ingredient("ing25", tabIng25));
		
		this.listeCPAvancee.add(new ChienDeGarde("CdG1", tabChienDeGarde1));
		this.listeCPAvancee.add(new ChienDeGarde("CdG2", tabChienDeGarde2));
		this.listeCPAvancee.add(new ChienDeGarde("CdG3", tabChienDeGarde3));
		this.listeCPAvancee.add(new TaupeGeante("TaupeG1", tabTaupeGeante1));
		this.listeCPAvancee.add(new TaupeGeante("TaupeG2", tabTaupeGeante2));
		this.listeCPAvancee.add(new TaupeGeante("TaupeG3", tabTaupeGeante3));
		
		/* CARTES RESTANTES :
		 * 
		 * verso Menhir (vraiment besoin du verso? pas d'importance pour la console de toute fa�on)
		 * champ (n�cessaire?)
		 * autre verso (verso alli�s ?) (pas encore besoin)
		 * comptage de points (n�cessaire?)
		 */
	}
	

}
