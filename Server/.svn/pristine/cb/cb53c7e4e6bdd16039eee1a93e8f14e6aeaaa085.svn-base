package commands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coloretto.commands.JoinGameCommand;
import coloretto.player.Lobby;
import coloretto.player.Player;
import coloretto.server.ClientConnection;
import coloretto.server.GameServer;

public class TestJoin {
	
	private JoinGameCommand join;
	private String command;
	private ClientConnection cc;
	private Player player1, player2, player3, player4;
	private Lobby currentLobby;
	private GameServer server;
	private List<Lobby> lobbys;


	@Before
	public void setUp() throws Exception {
		
		player1 = new PlayerMock("Lorenzo");
		player2 = new PlayerMock("Andrés");
		player3 = new PlayerMock("Miguel Ángel");
		player4 = new PlayerMock("Antonio"); 
		
		currentLobby = new Lobby();
		currentLobby.addPlayer(player1);
		currentLobby.addPlayer(player2);
		currentLobby.addPlayer(player3);
		currentLobby.addPlayer(player4);
		
		lobbys = new ArrayList<Lobby>();
		lobbys.add(currentLobby);
		
		server = new GameServer();
		cc = new ClientConnection("Lorenzo");
		cc.setServer(server);
		cc.getServer().setLobbys(lobbys);
	}

	@Test
	public void testJoin() {
		command = "JOIN " + currentLobby.getLobbyID();
		join = new JoinGameCommand(command, cc);
		assertEquals("Unido correctamente a mesa " + currentLobby.getLobbyID(), join.execute());
		
	}
	
	@Test
	public void test() {
		command = "JOIN 5";
		join = new JoinGameCommand(command, cc);
		assertEquals("Esta mesa no existe o está completa. Escriba SHOW para ver mesas creadas.", join.execute());
		
	}
	
	

}