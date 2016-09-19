package coloretto.player;

import coloretto.states.TurnPutCommandFactory;

public class TurnPut extends State<TurnPutCommandFactory> {
	
	private TurnPutCommandFactory factory;
		
	public TurnPut(){
		factory = new TurnPutCommandFactory();
	}
	@Override
	public TurnPutCommandFactory getFactory() {
		return factory;
	}

	@Override
	public String help() {
		
		String res = "\nComandos disponibles:";
		res = res.concat("\n\n> put [idFila]		... Colocar carta en una fila\n");
		
		return res;	
	}

}
