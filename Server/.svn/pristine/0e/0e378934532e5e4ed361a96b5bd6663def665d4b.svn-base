package coloretto.commands;

import coloretto.player.Game;
import coloretto.player.Lobby;
import coloretto.player.Logued;
import coloretto.player.Player;
import coloretto.player.WaitingGame;
import coloretto.server.ClientConnection;
import coloretto.server.ServerMain;

public class LeaveGameCommand extends Command {

	Integer gameID;
	Game currentGame = null;

	public LeaveGameCommand(String command, ClientConnection cc) {
		super(command, cc);
	}

	@Override
	public String execute() {
		
		String[] parts = command.split(" ");
		String info = "Se esperaba un parámetro";
		
		if(parts.length == 1){
		
			Player currentPlayer = cc.getPlayer();
			Game currentGame = currentPlayer.getCurrentGame();
			Lobby currentLobby = currentPlayer.getCurrentLobby();
			
			
			if(currentPlayer.getCurrentState() instanceof WaitingGame || currentPlayer.isStart()){
				
				currentPlayer.setCurrentState(new Logued());
				info = "Has abandona la mesa correctamente";
				
				if(currentLobby.getPlayers().size() == 1 ){
					cc.getServer().getLobbys().remove(currentLobby);
				}else{
					currentLobby.getPlayers().remove(currentPlayer);
					ServerMain.server.sendMessageToLobbyPlayers(currentLobby, 
							 currentPlayer.getPlayerID() + 
							" ha abandonado la mesa");
				}
				currentPlayer.setStart(false);
				
			}
			else{
					
				ServerMain.server.sendMessageToGamePlayers(currentGame, 
							"Partida Finalizada, " + currentPlayer.getPlayerID() + 
							" ha abandonado la partida");
				currentGame.resetPlayers();
				cc.getServer().getGames().remove(currentGame);
				info = "Has abandonado la partida correctamente";
				
			}
		}
			
		return info;
		
	/*	for (Game game : cc.getServer().getGames()) {
			if (game.getPlayers().contains(cc.getPlayer())) {
				game.getPlayers().remove(cc.getPlayer());
				cc.getPlayer().setCurrentState(new Logued());
				break;
			}
		}
		info = cc.getPlayer().getPlayerID() + " ha abandonado la partida "
				+ gameID;
	*/
		/*
		 * if(!currentGame.started){ for(Player currentPlayer:
		 * currentGame.getPlayers()){
		 * if(currentPlayer.getPlayerID().equals(cc.getPlayer().getPlayerID())){
		 * if(currentGame.getPlayers().size() == 1 ){
		 * cc.getServer().getGames().remove(currentGame); }else{
		 * currentGame.removePlayer(currentPlayer); } } } }else{
		 * cc.getServer().getGames().remove(currentGame); for(Player
		 * currentPlayer: currentGame.getPlayers()){
		 * currentPlayer.setCurrenGame(null); currentPlayer.setCurrentState(new
		 * Logued()); } } cc.getPlayer().setCurrentState(new Logued());
		 */
		//return info;
	}

}
