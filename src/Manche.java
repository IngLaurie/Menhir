import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;
// g�rer le nombre de points de chaque joueurs - partie complexe surtout
// /!\ si demande d'ajouter une carte au jeu..

public class Manche {

	private static final int NBMAXCARTEPRAPIDE = 4;
	private int nbManche;
	private int saisonEnCours;
	private String listeSaison[] = {"printemps", "�t�", "automne", "hiver"};

	//private ArrayList<Carte> listeCartesPA = new ArrayList<Carte>();
	private ArrayList<Carte> listeCIngredients = new ArrayList<Carte>();
	private ArrayList<Carte> listeCAllies = new ArrayList<Carte>();
		
	
	// faire un SET ?
	// v�rifier s'il y a pas trop de choses / � d�placer
	public Manche(Partie p){
		
		saisonEnCours = 0;
		
		if(p.getPartieAvancee()){
			// autant de manches que de joueurs
			this.nbManche = p.getNbJPhysique() + p.getNbJVirtuel();
			//this.listeCartesPA.addAll(listeCAllies);
			//this.listeCartesPA.addAll(listeCIngredients);
			// cartes de la partie rapide + cartes alli�s
			// on a ici l'ensemble des cartes n�cessaires pour la partie avancee 
			// on m�lange les cartes 
			 //Collections.shuffle(listeCIngredients);
			 //Collections.shuffle(listeCAllies);
			// 
		}else{  // partie rapide
			this.nbManche = 1;
			//Collections.shuffle(listeCIngredients);
			//this.listeCartesPA.addAll(listeCIngredients);
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
			// ici on utilise les cartes de listeCIngredients + listeCAllies 			
			// constructeur de manche mettre en param la liste de cartes  //
			// mettre en static final .. //
			this.initialisationListeCarte();
			
			for(Iterator<Joueur> it = p.getListeJoueur().iterator(); it.hasNext();) {
				Joueur joueurActif = it.next();
				demanderGrainesOuCarteAllie(p,joueurActif);
			}
		}else{ 
			// partie rapide
			// une partie rapide = 4 tours de jeu 
			// chaque joueur place devant lui un champ et pose � c�t� 2 graines
				
			// ici on utilise les cartes de listeCIngredients
			
			this.initialisationListeCarte();
			Collections.shuffle(listeCIngredients);
			
			int cpt = 1;
				for(Joueur joueur: p.getListeJoueur()){
					for(Carte carte: this.listeCIngredients){
						joueur.getMainDuJoueur().add(carte);
						// on distribue que 4 cartes par joueur 
						if(cpt == 4){
							break;
						}else{
							cpt++;
						}
					}
					
					this.listeCIngredients.removeAll(joueur.getMainDuJoueur());
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
	
	public void demanderGrainesOuCarteAllie(Partie p, Joueur j)
	{
		System.out.println("Souhaitez-vous obtenir une carte alli� (0) ou gagner deux graines (1)?\n");
		Scanner reponse = new Scanner(System.in);
		int choix = reponse.nextInt();
		if (choix == 0) {
			Carte c = listeCAllies.get(0);
			j.getMainDuJoueur().add(c);
			listeCAllies.remove(0);
		}else{
			if (choix == 1) {
				j.setNbGraineDuJoueur(2);
			}else{
				System.out.println("Choix incorrect.\n");
			}
		}
	}

	public void attribuerJoueurDeDebut(Partie p){
		Joueur jQuiCommence = null;
		
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
			//Faire choisir entre les graines ou la carte alli�
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
			System.out.println("\n-----------------\nD�but de la manche!\n");
			
			for (int i=0; i<4; i++) {
				for (Iterator<Joueur> it = p.getListeJoueur().iterator(); it.hasNext(); ) {
					Joueur joueurActif = it.next();
					System.out.println("\nSAISON EN COURS : " + this.listeSaison[this.getSaisonEnCours()] + "\n");
					joueurActif.jouerCarte(this, p);
				}
				this.changerSaison();
				

			}

			System.out.println("\nLa manche est termin�e.\n");
			
			//Changer la saison
			//R�p�ter pour toutes les saisons
			// A la fin de toutes les saison:
			//Fin de la manche
		}
		
	}
	
	


	public void changerSaison(){
		int nouvSaison = this.saisonEnCours;
		System.out.println("La saison " + this.listeSaison[this.saisonEnCours] + " est termin�e.\n");
		nouvSaison++;
		if (nouvSaison == 4) {
			nouvSaison = 0;
		} else {
			System.out.println("La nouvelle saison est " +this.listeSaison[this.saisonEnCours]);
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
		int tabIng24[][] = {{2, 0, 1, 3},{0, 3, 0, 3},{1, 2, 2, 1}};     // v�rifier s'il faut l'ajouter 
		
		int tabTaupeGeante1[] = {1, 1, 1, 1};
		int tabTaupeGeante2[] = {0, 2, 2, 0};
		int tabTaupeGeante3[] = {0, 1, 2, 1};
		int tabChienDeGarde1[] = {2, 0, 2, 0};
		int tabChienDeGarde2[] = {1, 2, 0, 1};
		int tabChienDeGarde3[] = {0, 1, 3, 0};
		
		this.listeCIngredients.add(new Ingredient("ing1", tabIng1));
		this.listeCIngredients.add(new Ingredient("ing2", tabIng2));
		this.listeCIngredients.add(new Ingredient("ing3", tabIng3));
		this.listeCIngredients.add(new Ingredient("ing4", tabIng4));
		this.listeCIngredients.add(new Ingredient("ing5", tabIng5));
		this.listeCIngredients.add(new Ingredient("ing6", tabIng6));
		this.listeCIngredients.add(new Ingredient("ing7", tabIng7));
		this.listeCIngredients.add(new Ingredient("ing8", tabIng8));
		this.listeCIngredients.add(new Ingredient("ing9", tabIng9));
		this.listeCIngredients.add(new Ingredient("ing10", tabIng10));
		this.listeCIngredients.add(new Ingredient("ing11", tabIng11));
		this.listeCIngredients.add(new Ingredient("ing12", tabIng12));
		this.listeCIngredients.add(new Ingredient("ing13", tabIng13));
		this.listeCIngredients.add(new Ingredient("ing14", tabIng14));
		this.listeCIngredients.add(new Ingredient("ing15", tabIng15));
		this.listeCIngredients.add(new Ingredient("ing16", tabIng16));
		this.listeCIngredients.add(new Ingredient("ing17", tabIng17));
		this.listeCIngredients.add(new Ingredient("ing18", tabIng18));
		this.listeCIngredients.add(new Ingredient("ing19", tabIng19));
		this.listeCIngredients.add(new Ingredient("ing20", tabIng20));
		this.listeCIngredients.add(new Ingredient("ing21", tabIng21));
		this.listeCIngredients.add(new Ingredient("ing22", tabIng22));
		this.listeCIngredients.add(new Ingredient("ing23", tabIng23));
		this.listeCIngredients.add(new Ingredient("ing24", tabIng24));
		
		this.listeCAllies.add(new ChienDeGarde("CdG1", tabChienDeGarde1));
		this.listeCAllies.add(new ChienDeGarde("CdG2", tabChienDeGarde2));
		this.listeCAllies.add(new ChienDeGarde("CdG3", tabChienDeGarde3));
		this.listeCAllies.add(new TaupeGeante("TaupeG1", tabTaupeGeante1));
		this.listeCAllies.add(new TaupeGeante("TaupeG2", tabTaupeGeante2));
		this.listeCAllies.add(new TaupeGeante("TaupeG3", tabTaupeGeante3));
		
		/* CARTES RESTANTES :
		 * 
		 * verso Menhir (vraiment besoin du verso? pas d'importance pour la console de toute fa�on)
		 * champ (n�cessaire?)
		 * autre verso (verso alli�s ?) (pas encore besoin)
		 * comptage de points (n�cessaire?)
		 */
	}
	

}
