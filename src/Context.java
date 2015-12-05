
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy){
		this.strategy = strategy;
	}
	
	public void executeStrategy(Manche m, Partie p){
		// on execute la strategy
		// exemple de return :
		System.out.println("Execution de executeStrategy dans context");
		strategy.jouerCarte(m,p);
	}
	
	
}
