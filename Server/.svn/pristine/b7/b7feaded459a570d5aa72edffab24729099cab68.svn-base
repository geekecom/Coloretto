package coloretto.commands;

import coloretto.player.Player;
import coloretto.server.ClientConnection;

public class HelpCommand extends Command {

	public HelpCommand(String command, ClientConnection cc) {
		super(command, cc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() {
		
		String[] parts = command.split(" ");
		String info = "Se esperaba un parámetro";
		
		if(parts.length == 1){
			
			Player player = cc.getPlayer();
			info = player.currentState.help();
		}
		return info;
	}

}
