package coloretto.player;

import java.util.ArrayList;
import java.util.List;

public class Lobby {
	
	private static Integer lobbysID = 0;
	private Integer lobbyID;
	private List<Player> players;
	
	public Lobby(){
		this.lobbyID = lobbysID;
		Lobby.lobbysID++;
		this.players = new ArrayList<Player>();
	}

	public void addPlayer(Player player) {
		
		players.add(player);
	}

	public Integer getLobbyID() {
		return lobbyID;
	}

	public String toString() {
		return "Mesa " + getLobbyID().toString()+ ": " + " Jugadores: "
				+ players.toString();
	}

	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return players;
	}
	
}
