package coloretto.player;

import coloretto.states.AnonymousCommandFactory;

public class Anonymous extends State<AnonymousCommandFactory> {

	private AnonymousCommandFactory factory ;
	
	public Anonymous(){
		factory = new AnonymousCommandFactory();
	}
	
	public AnonymousCommandFactory getFactory(){
		return factory;
	}
	public String help() {
		String res = "\nComandos disponibles:";
		res = res.concat("\n\n> login [nombre]	... Registrarse en el servidor con tu nombre\n");
		res = res.concat("> exit			... Desconectarse del servidor\n");
		return res;
	}
	

}
