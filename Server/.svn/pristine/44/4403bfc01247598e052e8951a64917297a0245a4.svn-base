package coloretto.commands;

import java.util.ArrayList;
import java.util.List;

import coloretto.player.Logued;
import coloretto.player.Player;
import coloretto.server.ClientConnection;

public class LoginCommand extends Command{ 
	
	public LoginCommand(String command, ClientConnection cc){
		super(command,cc);
	}
	
	public String execute(){
		String[] parts = command.split(" ");
		
		String info = "Se esperaban dos parámetros";
		try {
		
		if(parts.length == 2){
			String playerID = parts[1];
			List<String> playersID = new ArrayList<String>();
			for (Player players : cc.getPlayers()) {
				playersID.add(players.getPlayerID());
			}
		
			if(playersID.contains(playerID)){
				info = "Usuario ya existente";
			}else{
				cc.loginPlayer(playerID);
				Player currentPlayer = cc.getPlayer();
				currentPlayer.setCurrentState(new Logued());
				info = "Usuario " + playerID + " registrado correctamente";
			}
		}
		}catch(Exception e){
			info = "Error de procesamiento";
		}
		return info;
	}

}
