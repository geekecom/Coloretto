package coloretto.player;

public abstract class State<T> {

	public abstract T getFactory();

	public abstract String help();
		
}
