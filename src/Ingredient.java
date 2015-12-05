import java.util.Arrays;
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
		System.out.println("Choisir l'action à effectuer : \n");
		System.out.println("1- Géant");
		System.out.println("2- Engrais");
		System.out.println("3- Farfadet");
		

		int saison = m.getSaisonEnCours();
		
		Scanner scanAction = new Scanner(System.in);
		int choixAction = scanAction.nextInt();
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
				// gérer les OutOfIndice
			}
		}
		j.getMainDuJoueur().remove(this);
	}
	
	public void choisirGeant(Joueur j, Manche m, Partie p) {
		j.setNbGraineDuJoueur(j.getNbGraineDuJoueur(), this.getForce(0,m.getSaisonEnCours())); 
		System.out.println("Vous avez pris " + this.getForce(0, m.getSaisonEnCours()) + " graines dans le pot commun !");
		System.out.println("Vous avez maintenant " + j.nbGraineDuJoueur + " graines et " + j.getNbMenhirDuJoueur() + " ménhirs\n");
	}
	
	public void choisirEngrais(Joueur j, Manche m, Partie p) {
		if(j.getNbGraineDuJoueur() >= this.getForce(choixAction -1, saison)){
			j.setNbMenhirDuJoueur(j.getNbMenhirDuJoueur(), this.getForce(choixAction -1, saison)); 
			int nbAjouteSurChamp =  this.getForce(choixAction -1, saison);
			j.setNbGraineDuJoueur(j.getNbGraineDuJoueur(), - nbAjouteSurChamp); 
			
			System.out.println("Résultat : " + this.getForce(choixAction -1, saison) + " de vos graines sont devenues des ménhirs !");
			System.out.println("Vous avez maintenant " + j.getNbGraineDuJoueur() + " graines et " + j.getNbMenhirDuJoueur() + " ménhirs\n");
		}else{
			if(j.getNbGraineDuJoueur() < this.getForce(choixAction -1, saison)){
				j.setNbMenhirDuJoueur(j.getNbGraineDuJoueur(), j.getNbGraineDuJoueur()); 
				int nbAjouteSurChamp =  j.getNbGraineDuJoueur();
				j.setNbGraineDuJoueur(j.getNbGraineDuJoueur(), - nbAjouteSurChamp); 
				
				System.out.println("Résultat : " + this.getForce(choixAction -1, saison) + " de vos graines sont devenues des ménhirs !");
				System.out.println("Vous avez maintenant " + j.getNbGraineDuJoueur() + " graines et " + j.getNbMenhirDuJoueur() + " ménhirs\n");
			}else{
				System.out.println("Sorry.. vous n'avez plus de graines..\n");
			}
		}
	}
	
	public void choisirFarfadet(Joueur j, Manche m, Partie p) {
		System.out.println("Veuillez choisir un joueur : ");
		Joueur joueurChoisi = j.choisirJoueur(p.getListeJoueur());
		
		//if(joueurChoisi.getNom() != this.getNom()){
		System.out.println("Nb Graines du joueur choisi : " + joueurChoisi.getNbGraineDuJoueur() + " + Nb Menhirs : " + joueurChoisi.getNbMenhirDuJoueur());
		j.setNbGraineDuJoueur(j.getNbGraineDuJoueur(), this.getForce(choixAction -1, saison));
		int nbAVoler = this.getForce(choixAction -1, saison);
		joueurChoisi.setNbGraineDuJoueur(joueurChoisi.getNbGraineDuJoueur(), - nbAVoler);
		System.out.println("Vous volez " + nbAVoler + " graines au joueur " + joueurChoisi.getNom());
		System.out.println("Nb Graines du joueur choisi : " + joueurChoisi.getNbGraineDuJoueur() + " + Nb Menhirs : " + joueurChoisi.getNbMenhirDuJoueur());
		// ATTENTION AUX INDICE.. si on tape 2 alors que le choix est 0 ou 1, ça marche quand même.. 
		System.out.println("Vous avez volé " + this.getForce(choixAction -1, saison) + " graines au joueur " + joueurChoisi.getNom() + " !");
		/*}else{
			//Joueur joueurChoisi = this.choisirJoueur(p.getListeJoueur());
			System.out.println("ERROR");
		}*/
		// NOP ! 
		// ne pas faire de cette façon.. 
		//System.out.println("Veuillez choisir un joueur différent du votre");
		
	}
 
	//private Arrays valeurCarteIngredient;
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("                   " + this.getNom() + "\n");
		sb.append("         Print.  Ete  Automne  Hiver\n");
		sb.append("Géant       " + this.getForce(0, 0) + "      " + this.getForce(0, 1) + "      " + this.getForce(0, 2) + "       " + this.getForce(0, 3) + "\n");
		sb.append("Engrais     " + this.getForce(1, 0) + "      " + this.getForce(1, 1) + "      " + this.getForce(1, 2) + "       " + this.getForce(1, 3) + "\n");
		sb.append("Farfadet    " + this.getForce(2, 0) + "      " + this.getForce(2, 1) + "      " + this.getForce(2, 2) + "       " + this.getForce(2, 3) + "\n");
		return sb.toString();
	}
	
}
