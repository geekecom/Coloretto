package commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import coloretto.commands.LeaveGameCommand;
import coloretto.player.Lobby;
import coloretto.player.Player;
import coloretto.server.ClientConnection;
import coloretto.server.GameServer;
import coloretto.server.ServerMain;

public class TestLeave {
	
	private LeaveGameCommand leave;
	private String command;
	private ClientConnection cc;
	private Player player1, player2, player3, player4;
	private Lobby currentLobby;
	private GameServer server;
	
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
	}

	@Test
	public void test() {
		server = new GameServerMock();
		cc = new ClientConnection("Andrés");
		cc.getPlayer().setCurrentGame(new GameMock(player1, player2, player3, player4));
		cc.getPlayer().setCurrentLobby(currentLobby);
		cc.setServer(server);
		ServerMain.server = cc.getServer();
		command = "LEAVE 0";
		leave = new LeaveGameCommand(command, cc);
		assertEquals("Has abandonado la partida correctamente", leave.execute());
		
	}

}
