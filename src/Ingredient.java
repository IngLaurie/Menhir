import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ingredient extends Carte {

	public Ingredient(String nom, int[][] tabValCarte) {
		super(nom, tabValCarte);
	}
	
	public int getForce(int action, int saison) {
		return super.getForce(action, saison);
	}
	
	public String getNom() {
		return super.getNom();
	}
	
	
	public void choisirAction(Joueur j, Manche m, Partie p) {
		super.choisirAction(j, m, p);
		System.out.println("Vous avez choisi la carte:\n");
		System.out.println(this.toString());
		System.out.println("Choisir l'action � effectuer : \n");
		System.out.println("1- G�ant");
		System.out.println("2- Engrais");
		System.out.println("3- Farfadet");
		
		int choixAction = 0;
		do {
			try{
				Scanner scanAction = new Scanner(System.in);
				choixAction = scanAction.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Entrez 1, 2 ou 3.\n");
			}
		}while(choixAction != 1 && choixAction != 2 && choixAction != 3);

		//scanAction.close();
		
		System.out.println("Vous avez choisi l'action : " + choixAction);
		
		//System.out.println("Vous avez " + this.getNbGraineDuJoueur() + " graines et " + this.getNbMenhirDuJoueur() + " Menhirs\n");
		
		if(choixAction == 1){this.choisirGeant(j, m, p);}
		else{
			if(choixAction == 2){this.choisirEngrais(j, m, p);}
				else{
				if(choixAction == 3){this.choisirFarfadet(j, m, p);} // FARFADET
					else{
					System.out.println("Veuillez entrer une valeur juste\n\n");
					// /!\ faire reboucler sur le menu (choix de l'action)
				}
				// g�rer les OutOfIndice
			}
		}
		j.getMainDuJoueur().remove(this);
	}
	
	public void choisirGeant(Joueur j, Manche m, Partie p) {
		j.setNbGraineDuJoueur(j.getNbGraineDuJoueur(), this.getForce(0,m.getSaisonEnCours())); 
		System.out.println("Vous avez pris " + this.getForce(0, m.getSaisonEnCours()) + " graines dans le pot commun !");
		System.out.println("Vous avez maintenant " + j.getNbGraineDuJoueur() + " graines et " + j.getNbMenhirDuJoueur() + " m�nhirs\n");
	}
	
	public void choisirEngrais(Joueur j, Manche m, Partie p) {
		if(j.getNbGraineDuJoueur() == 0){
			System.out.println("Vous n'avez pas de graines � planter!\n");
			System.out.println("Vous avez toujours " +j.getNbGraineDuJoueur()+ " graines et " +j.getNbMenhirDuJoueur()+ " m�nhirs.");
		}else{
			if(j.getNbGraineDuJoueur() >= this.getForce(1, m.getSaisonEnCours())){
			j.setNbMenhirDuJoueur(j.getNbMenhirDuJoueur()+this.getForce(1, m.getSaisonEnCours()));
			j.setNbGraineDuJoueur(j.getNbGraineDuJoueur()-this.getForce(1, m.getSaisonEnCours())); 
			
			System.out.println("R�sultat : " + this.getForce(1, m.getSaisonEnCours()) + " de vos graines sont devenues des m�nhirs !");
			System.out.println("Vous avez maintenant " + j.getNbGraineDuJoueur() + " graines et " + j.getNbMenhirDuJoueur() + " m�nhirs\n");
		}else{
			if(j.getNbGraineDuJoueur() < this.getForce(1, m.getSaisonEnCours())){
				j.setNbMenhirDuJoueur(j.getNbMenhirDuJoueur()+j.getNbGraineDuJoueur()); 
				j.setNbGraineDuJoueur(0); 
				
				System.out.println("Vous aviez moins de graines que la force de votre carte... Elles sont toutes devenues des m�nhirs.");
				System.out.println("Vous avez maintenant " + j.getNbGraineDuJoueur() + " graines et " + j.getNbMenhirDuJoueur() + " m�nhirs\n");
			}
		}
	}
	}
	
	
	public void choisirFarfadet(Joueur j, Manche m, Partie p) {
		System.out.println("Veuillez choisir un joueur :\n");
		Joueur joueurChoisi = j.choisirJoueur(p.getListeJoueur());
		
		if(p.getPartieAvancee()) {
			System.out.println(joueurChoisi.getNom() + " poss�de " +joueurChoisi.getNbChiens() + " chiens de garde.\n");
			if(joueurChoisi.getNbGraineDuJoueur() == 0) {
				System.out.println("Il n'y avait aucune graine � voler...\n");
			}else{
				if(joueurChoisi.getNbGraineDuJoueur()<joueurChoisi.getNbChiens()) {
					System.out.println("Les graines de " +joueurChoisi.getNom() + " sont trop bien gard�es, vous n'avez pas pu en voler.");
				}else{
					if(joueurChoisi.getNbGraineDuJoueur() >= joueurChoisi.getNbChiens()) {
						int volPossible = joueurChoisi.getNbGraineDuJoueur()-joueurChoisi.getNbChiens();
						if(volPossible < this.getForce(2, m.getSaisonEnCours())) {
							j.setNbGraineDuJoueur(j.getNbGraineDuJoueur()+volPossible);
							System.out.println("Vous avez vol� " +volPossible+ " graines, vous en avez maintenant " +j.getNbGraineDuJoueur());
						}else{
							if(volPossible >= this.getForce(2, m.getSaisonEnCours())) {
								j.setNbGraineDuJoueur(j.getNbGraineDuJoueur()+this.getForce(2, m.getSaisonEnCours()));
								System.out.println("Vous avez vol� " +this.getForce(2, m.getSaisonEnCours())+ " graines, vous en avez maintenant " +j.getNbGraineDuJoueur());
							}
						}
					}
				}
			}
		}else{
			if(joueurChoisi.getNbGraineDuJoueur() == 0) {
				System.out.println("Il n'y aucune graine � voler...\n");
			}else{
				if(joueurChoisi.getNbGraineDuJoueur() < this.getForce(2, m.getSaisonEnCours())) {
					j.setNbGraineDuJoueur(j.getNbGraineDuJoueur()+joueurChoisi.getNbGraineDuJoueur());
					joueurChoisi.setNbGraineDuJoueur(0);
					System.out.println("Il y avait moins de graines � voler que la force de votre carte.\nVous poss�dez maintenant " +j.getNbGraineDuJoueur() + " graines!");
				}else{
					if(joueurChoisi.getNbGraineDuJoueur() >= this.getForce(2, m.getSaisonEnCours())) {
						j.setNbGraineDuJoueur(j.getNbGraineDuJoueur()+this.getForce(2, m.getSaisonEnCours()));
						joueurChoisi.setNbGraineDuJoueur(joueurChoisi.getNbGraineDuJoueur()-this.getForce(2, m.getSaisonEnCours()));
						System.out.println("Vous avez vol� " +this.getForce(2, m.getSaisonEnCours())+ " graine(s), vous en avez maintenant " +j.getNbGraineDuJoueur());
					}
				}
			}
		}
	}
 
	//private Arrays valeurCarteIngredient;
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("                   " + this.getNom() + "\n");
		sb.append("         Print.  Ete  Automne  Hiver\n");
		sb.append("G�ant       " + this.getForce(0, 0) + "      " + this.getForce(0, 1) + "      " + this.getForce(0, 2) + "       " + this.getForce(0, 3) + "\n");
		sb.append("Engrais     " + this.getForce(1, 0) + "      " + this.getForce(1, 1) + "      " + this.getForce(1, 2) + "       " + this.getForce(1, 3) + "\n");
		sb.append("Farfadet    " + this.getForce(2, 0) + "      " + this.getForce(2, 1) + "      " + this.getForce(2, 2) + "       " + this.getForce(2, 3) + "\n");
		return sb.toString();
	}
	
}
