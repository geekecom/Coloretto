package commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import coloretto.player.Game;
import coloretto.player.Player;
import coloretto.server.ClientConnection;
import coloretto.server.GameServer;

public class GameServerMock extends GameServer{
	
	private Set<ClientConnection> connections;
	
	List<Player> players;
	List<Game> games;
	private Player player1, player2, player3, player4;
	
	public GameServerMock(){
		
		connections = new HashSet<ClientConnection>();
		
		player1 = new PlayerMock("Lorenzo");
		player2 = new PlayerMock("Andrés");
		player3 = new PlayerMock("Miguel Ángel");
		player4 = new PlayerMock("Antonio"); 
		
		Game game = new GameMock(player1, player2, player3, player4);
		
		games = new ArrayList<Game>();
		games.add(game);
	}
	
	public List<Game> getGames() {
		return games;
	}
	
	public List<Player> players(){
		return this.getPlayers();
		
	}
	
	public void sendMessageToGamePlayers(Game game,String message){
		for(ClientConnection cc: connections){
			if(cc.getPlayer().getCurrentGame().getGameID().equals(game.getGameID())){
				cc.sendMessage(message);
				
			}
		}
	}
}
