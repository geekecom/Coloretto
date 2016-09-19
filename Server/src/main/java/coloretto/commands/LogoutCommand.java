package coloretto.commands;

import coloretto.server.ClientConnection;

public class LogoutCommand extends Command{

	public LogoutCommand(String command, ClientConnection cc) {
		super(command, cc);
		// TODO Auto-generated constructor stub
	}
	
	public String execute(){
		String[] parts = command.split(" ");
		String info = "Se esperaba un parámetro";
		
		if(parts.length == 1){
			cc.close();
			info = "Usuario desconectado correctamente";
		}
		return  info;
		
	}
}
