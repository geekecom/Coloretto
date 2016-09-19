package coloretto.player;

import coloretto.states.LoguedCommandFactory;

public class Logued extends State<LoguedCommandFactory>{
	
	private LoguedCommandFactory factory ;
	
	public Logued(){
		factory = new LoguedCommandFactory();
	}

	public String help() {
		
		String res = "\nComandos disponibles:";
		res = res.concat("\n\n> show			... Mostrar mesas existentes\n");
		res = res.concat("> create		... Crear una nueva mesa\n");
		res = res.concat("> join [idMesa]		... Unirse a una mesa ya existente\n");
		res = res.concat("> exit			... Desconectarse del servidor\n");
		
		return res;		
	}

	public LoguedCommandFactory getFactory() {
		// TODO Auto-generated method stub
		return factory;
	}

}
