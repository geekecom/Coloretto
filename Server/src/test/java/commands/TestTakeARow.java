package commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import coloretto.commands.TakeARowCommand;
import coloretto.player.Card;
import coloretto.player.E_Card;
import coloretto.player.Player;
import coloretto.player.Row;
import coloretto.server.ClientConnection;

public class TestTakeARow {
	private TakeARowCommand take;
	private String command;
	private ClientConnection cc;
	private Player player1, player2, player3, player4;
	private Row row;

	@Before
	public void setUp() throws Exception {
		
		player1 = new PlayerMock("Lorenzo");
		player2 = new PlayerMock("Andr�s");
		player3 = new PlayerMock("Miguel �ngel");
		player4 = new PlayerMock("Antonio"); 
		
		row = new Row(3);
		row.setFull(true);
		row.getRow().add(new Card(E_Card.BLUE));
		row.getRow().add(new Card(E_Card.GREEN));
		row.getRow().add(new Card(E_Card.PINK));
	}
	
	@Test
	public void test() {
		cc = new ClientConnection("Antonio");
		cc.getPlayer().setCurrentGame(new GameMock(player1, player2, player3, player4));
		cc.getPlayer().getCurrentGame().rows.set(3, row);
		cc.getPlayer().getCurrentGame().setCurrentTurn(3);
		command = "TAKE 2";
		take = new TakeARowCommand(command, cc);
		assertEquals("No se puede coger esta fila", take.execute());
	}
		
	@Test
	public void testRowSeleted() {
		cc = new ClientConnection("Antonio");
		cc.getPlayer().setCurrentGame(new GameMock(player1, player2, player3, player4));		
		cc.getPlayer().getCurrentGame().rows.set(3, row);
		cc.getPlayer().getCurrentGame().setCurrentTurn(3);
		command = "TAKE 3";
		take = new TakeARowCommand(command, cc);
		assertEquals("Has seleccionado la fila 3", take.execute());
	}

}
