package commands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import coloretto.commands.ShowGamesCommand;
import coloretto.player.Lobby;
import coloretto.player.Player;
import coloretto.server.ClientConnection;
import coloretto.server.GameServer;

public class TestShowGames {
	
	private ShowGamesCommand show;
	private String command;
	private ClientConnection cc;
	private Player player1, player2, player3, player4;
	private Lobby currentLobby;
	private GameServer server;
	private List<Lobby> lobbys;

	
	@Test
	public void testShowLobbys() {
		player1 = new PlayerMock("Lorenzo");
		player2 = new PlayerMock("Andr�s");
		player3 = new PlayerMock("Miguel �ngel");
		player4 = new PlayerMock("Antonio");
		
		currentLobby = new Lobby();
		currentLobby.addPlayer(player1);
		currentLobby.addPlayer(player2);
		currentLobby.addPlayer(player3);
		currentLobby.addPlayer(player4);
		
		lobbys = new ArrayList<Lobby>();
		lobbys.add(currentLobby);
		
		server = new GameServer();
		cc = new ClientConnection("pimbar");
		cc.getPlayer().setCurrentLobby(currentLobby);
		cc.setServer(server);
		cc.getServer().setLobbys(lobbys);
		command = "SHOW";
		show = new ShowGamesCommand(command, cc);
		assertEquals("Mesas: \nMesa 0:  Jugadores: [Lorenzo, Andr�s, Miguel �ngel, Antonio]", show.execute());
	}
	
	@Test
	public void testShow() {
		lobbys = new ArrayList<Lobby>();
		server = new GameServer();
		cc = new ClientConnection("pimbar");
		cc.setServer(server);
		cc.getServer().setLobbys(lobbys);
		
		command = "SHOW";
		show = new ShowGamesCommand(command, cc);
		assertEquals("No hay mesas actualmente", show.execute());
	}

}
