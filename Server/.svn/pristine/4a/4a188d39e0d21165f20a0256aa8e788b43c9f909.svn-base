package commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import coloretto.commands.CreateGameCommand;
import coloretto.server.ClientConnection;

public class TestCreateGame {
	
	private ClientConnection cc;
	private CreateGameCommand create;
	private String command;
	private GameServerMock server;

	@Before
	public void setUp() throws Exception {
		server = new GameServerMock(); 
		cc = new ClientConnection("Andrés");
		command = "create";
		create = new CreateGameCommand(command, cc);
		cc.setServer(server);
	}

	@Test
	public void test() {
		assertEquals("Mesa creada con id: 0", create.execute());
	}

}
