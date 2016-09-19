package commands;

import static org.junit.Assert.*;

import org.junit.Test;

import coloretto.commands.LogoutCommand;

public class TestLogout {
	
	private LogoutCommand logout;
	private String command;
	private ClientConnectionMock cc;

	@Test
	public void test() {
		cc = new ClientConnectionMock("pimbar");
		command = "LOGOUT pimbar";
		logout = new LogoutCommand(command, cc);
		assertEquals("Usuario desconectado correctamente", logout.execute());
		
	}

}
