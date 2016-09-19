package commands;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import coloretto.player.Player;
import coloretto.server.ClientConnection;


public class ClientConnectionMock extends ClientConnection{
	
	List<Player> players = new ArrayList<Player>();
	Player player;
	Socket clientSocket;
	

	public ClientConnectionMock(String playerID) {
		super(playerID);
		clientSocket = new Socket();
	}
	
	public Player getPlayer() {
		return super.getPlayer();
	}

	
	public void loginPlayer(String playerID) {
		this.player.setPlayerID(playerID);
		players.add(this.player);

	}
	
	
	public GameServerMock getServer(){
		GameServerMock serverMock = new GameServerMock();
		return serverMock;
		
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public boolean close() {
		boolean res = true;
		try {
			clientSocket.close();
		} catch (IOException e) {
			res = false;
		}
		return res;
		
	}

	public List<Player> getPlayers() {
		players.add(new PlayerMock("Lorenzo"));
		players.add(new PlayerMock("Andr�s"));
		players.add(new PlayerMock("Miguel �ngel"));
		players.add(new PlayerMock("Antonio"));
		return players;
	}
	
	

	
}
