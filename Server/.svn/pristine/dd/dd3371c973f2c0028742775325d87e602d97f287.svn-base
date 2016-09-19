																																							package coloretto.commands;

import coloretto.player.Lobby;
import coloretto.player.Player;
import coloretto.player.WaitingGame;
import coloretto.server.ClientConnection;

public class CreateGameCommand extends Command {

	public CreateGameCommand(String command, ClientConnection cc) {
		super(command, cc);
	}

	@Override
	public String execute() {
		
		String[] parts = command.split(" ");
		String info = "Se esperaba un parámetro";
		
		if(parts.length == 1){
		
			Player player = cc.getPlayer();
			//Lobby currentLobby = cc.getServer().createLobby();
			Lobby currentLobby = new Lobby();
			
			cc.getServer().getLobbys().add(currentLobby);
			currentLobby.addPlayer(player);
			player.setCurrentLobby(currentLobby);
			player.setCurrentState(new WaitingGame());
			
			info = "Mesa creada con id: " + currentLobby.getLobbyID();
		}
		
		return info ;
	}

}