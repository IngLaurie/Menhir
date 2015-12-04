
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy){
		this.strategy = strategy;
	}
	
	public void executeStrategy(Manche m, Partie p){
		// on execute la strategy
		// exemple de return :
		//return strategy.jouerCarte(m,p);
	}
	
	
}
