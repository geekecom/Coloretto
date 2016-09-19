package coloretto.player;

import coloretto.states.WaitTurnCommandFactory;

public class WaitTurn extends State<WaitTurnCommandFactory>{
	
	private WaitTurnCommandFactory factory ;
	
	public WaitTurn(){
		factory = new WaitTurnCommandFactory();
	}


	@Override
	public WaitTurnCommandFactory getFactory() {
		return factory;
	}

	@Override
	public String help() {
		
		String res = "\nComandos disponibles:";
		res = res.concat("\n\n> leave			... Salir de la partida\n");
		
		return res;	
	}
}