package commands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coloretto.commands.LoginCommand;
import coloretto.player.Player;
import coloretto.server.ClientConnection;

public class TestLogin {
	private LoginCommand login;
	private String command;
	private ClientConnection cc;
	private Player player;
	private List<Player> players;
	
	@Before
	
	public void setUp(){
		player = new PlayerMock("Andrés");
		players = new ArrayList<Player>();
		players.add(player);
	}


	@Test
	public void testUnregistered() {
		cc = new ClientConnection("pimbar");
		cc.setPlayers(players);
		command = "LOGIN pimbar";
		login = new LoginCommand(command, cc);
		assertEquals("Usuario pimbar registrado correctamente", login.execute());
	}
	
	@Test
	public void testRegistered(){	
		cc = new ClientConnectionMock("Andrés");
		cc.setPlayers(players);
		command = "LOGIN Andrés";
		login = new LoginCommand(command, cc);
		assertEquals("Usuario ya existente", login.execute());
	}

}