package commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import coloretto.commands.PutACardCommand;
import coloretto.player.Card;
import coloretto.player.E_Card;
import coloretto.player.Player;

public class TestPutACard {

	private ClientConnectionMock cc;
	private String command;
	private PutACardCommand put;
	private Player player1, player2, player3, player4;
	
	@Before
	public void setUp() {
		
		player1 = new PlayerMock("Lorenzo");
		player2 = new PlayerMock("Andrés");
		player3 = new PlayerMock("Miguel Ángel");
		player4 = new PlayerMock("Antonio"); 
		
	}

	@Test
	public void test() {
		cc = new ClientConnectionMock("Antonio");
		cc.getPlayer().setCurrentGame(new GameMock(player1, player2, player3, player4));
		cc.getPlayer().getCurrentGame().setCurrentTurn(3);
		cc.getPlayer().getCurrentGame().setCurrentCard(new Card(E_Card.BROWN));
		command = "PUT 3";
		put = new PutACardCommand(command, cc);
		assertEquals("Has colocado la carta BROWN en la fila 3", put.execute());
	}

}