package commands;

import static org.junit.Assert.*;

import org.junit.Test;

import coloretto.commands.StartGameCommand;
import coloretto.player.Lobby;
import coloretto.player.Player;
import coloretto.server.ClientConnection;
import coloretto.server.GameServer;
import coloretto.server.ServerMain;

public class TestStartGame {
	private StartGameCommand start;
	private String command;
	private ClientConnection cc;
	private Player player1, player2, player3, player4;
	private Lobby currentLobby;
	private GameServer server;

	@Test
	public void test() {
		
		player1 = new PlayerMock("Lorenzo");
		player2 = new PlayerMock("Andrés");
		player3 = new PlayerMock("Miguel Ángel");
		player4 = new PlayerMock("Antonio"); 
		
		currentLobby = new Lobby();
		currentLobby.addPlayer(player1);
		currentLobby.addPlayer(player2);
		currentLobby.addPlayer(player3);
		currentLobby.addPlayer(player4);
		
		server = new GameServer();
		cc = new ClientConnection("Lorenzo");
		cc.setServer(server);
		cc.getPlayer().setCurrentLobby(currentLobby);
		
		command = "START";
		start = new StartGameCommand(command, cc);
		assertEquals("Esperando confirmación de todos los jugadores", start.execute());
	}
	
	@Test
	public void testStart() {
		
		player1 = new PlayerMock("Lorenzo");
		player2 = new PlayerMock("Andrés");
		player3 = new PlayerMock("Miguel Ángel");
		player4 = new PlayerMock("Antonio"); 
		
		currentLobby = new Lobby();
		currentLobby.addPlayer(player1);
		currentLobby.addPlayer(player2);
		currentLobby.addPlayer(player3);
		currentLobby.addPlayer(player4);
		
		server = new GameServerMock();
		cc = new ClientConnection("Lorenzo");
		cc.setServer(server);
		cc.getPlayer().setCurrentLobby(currentLobby);
		
		
		for(Player player : currentLobby.getPlayers()){
			player.setStart(true);	
		}
		
		ServerMain.server = cc.getServer();
		
		command = "START";
		start = new StartGameCommand(command, cc);
		assertEquals("Partida iniciada", start.execute());
	}
	
	@Test
	public void testNoPlayers() {
		
		player1 = new PlayerMock("Lorenzo");
		currentLobby = new Lobby();
		currentLobby.addPlayer(player1);
		server = new GameServer();
		cc = new ClientConnection("Lorenzo");
		cc.setServer(server);
		cc.getPlayer().setCurrentLobby(currentLobby);
		
		command = "START";
		start = new StartGameCommand(command, cc);
		assertEquals("Debe esperar que haya jugadores suficientes", start.execute());
	}
	

}
