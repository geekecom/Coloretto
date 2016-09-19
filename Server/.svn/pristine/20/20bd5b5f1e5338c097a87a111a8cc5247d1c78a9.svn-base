package coloretto.commands;

import java.util.List;

import coloretto.player.Game;
import coloretto.player.Lobby;
import coloretto.player.Player;
import coloretto.player.WaitTurn;
import coloretto.server.ClientConnection;

public class StartGameCommand extends Command{
	
	public StartGameCommand(String command, ClientConnection cc){
		super(command, cc);
	}
	
	public String execute(){
		
		String[] parts = command.split(" ");
		String info = "Se esperaba un parámetro";
		
		if(parts.length == 1){
		
			boolean start = true;
			info = null;
			Player currentPlayer = cc.getPlayer();
			Lobby currentLobby = currentPlayer.getCurrentLobby();
			
			if(currentLobby.getPlayers().size() > 1 && currentLobby.getPlayers().size() < 6){
				currentPlayer.setStart(true);
				currentPlayer.setCurrentState(new WaitTurn());
				
				for(Player player : currentLobby.getPlayers()){
					if(!player.isStart()){
						start = false;
						break;
					}
				}
				if(start){
					
					Game currentGame = null;
					List<Player> players = currentLobby.getPlayers();
					if(players.size() == 2){
						currentGame = new Game(players.get(0),players.get(1));
					}
					if(players.size() == 3){
						currentGame = new Game(players.get(0),players.get(1),players.get(2));
					}
					if(players.size() == 4){
						currentGame = new Game(players.get(0),players.get(1),players.get(2),players.get(3));
					}
					if(players.size() == 5){
						currentGame = new Game(players.get(0),players.get(1),players.get(2),players.get(3),players.get(4));
					}
					cc.getServer().getGames().add(currentGame);
					
					//currentGame = new Game(currentLobby.getPlayers().size());
					for(Player player:currentLobby.getPlayers()){
						player.setCurrentGame(currentGame);
						player.setStart(false);
						//currentGame.addPlayer(player);
					}
					
					cc.getServer().sendMessageToGamePlayers(currentGame, "\nPartida iniciada");
					currentGame.startGame();
					cc.getServer().getLobbys().remove(currentLobby);
					
					info = "Partida iniciada";
				} else{
					info = "Esperando confirmación de todos los jugadores";
					cc.getServer().sendMessageToLobbyPlayers(currentLobby, "Usuario " + currentPlayer.getPlayerID() + " solicita iniciar la partida");
				}
			}else{
				info = "Debe esperar que haya jugadores suficientes";
			}
		}
		return info;
	}
}


