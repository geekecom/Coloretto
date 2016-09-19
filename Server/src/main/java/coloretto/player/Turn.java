package coloretto.player;

import coloretto.states.TurnCommandFactory;

public class Turn extends State<TurnCommandFactory>{
	
	private TurnCommandFactory factory ;
	
	public Turn(){
		factory = new TurnCommandFactory();
	}

	@Override
	public TurnCommandFactory getFactory() {
		return factory;
	}

	@Override
	public String help() {
		
		String res = "\nComandos disponibles:";
		res = res.concat("\n\n> draw			... Robar carta\n");
		res = res.concat("> take [idFila]		... Tomar una fila\n");
		res = res.concat("> leave			... Salir de la mesa\n");
		return res;
	}

}
