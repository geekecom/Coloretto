package coloretto.commands;

import java.util.List;

import coloretto.player.Lobby;
import coloretto.server.ClientConnection;

public class ShowGamesCommand extends Command{
	
	public ShowGamesCommand(String command, ClientConnection cc) {
		super(command, cc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() {
		
		String[] parts = command.split(" ");
		String info = "Se esperaba un parámetro";
		
		if(parts.length == 1){
			List<Lobby> lobbys = cc.getServer().getLobbys();
			info = "Mesas: ";
			if(lobbys.isEmpty()){
				info = "No hay mesas actualmente";
			}
			for(Lobby lobby:lobbys){
				info = info.concat("\n" + lobby.toString());
			}
		}
		// TODO Auto-generated method stub
		return info;
	}

}
