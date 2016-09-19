package coloretto.player;

import coloretto.states.WaitingGameCommandFactory;

public class WaitingGame extends State<WaitingGameCommandFactory>{
	
	private WaitingGameCommandFactory factory;
	
	public WaitingGame(){
		factory = new WaitingGameCommandFactory();
	}
	
	public WaitingGameCommandFactory getFactory(){
		return factory;
	}
	
	public String help() {
	
		String res = "\nComandos disponibles:";
		res = res.concat("\n\n> show			... Mostrar mesas existentes\n");
		res = res.concat("> start			... Solicitar inicio de partida\n");
		res = res.concat("> leave			... Salir de la mesa\n");
		return res;
	}
}
