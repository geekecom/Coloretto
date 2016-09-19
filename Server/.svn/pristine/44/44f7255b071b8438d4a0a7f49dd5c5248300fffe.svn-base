package commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import coloretto.commands.DrawACardCommand;
import coloretto.player.PackOfCards;
import coloretto.player.Player;
import coloretto.player.Row;
	
	public class TestDrawACard {
		private DrawACardCommand draw;
		private String command;
		private ClientConnectionMock cc;
		private Player player1, player2, player3, player4;
		private Row row1, row2, row3, row4;
		private PackOfCards cards;
	
	@Before
	public void setUp() throws Exception {
		
		player1 = new PlayerMock("Lorenzo");
		player2 = new PlayerMock("Andrés");
		player3 = new PlayerMock("Miguel Ángel");
		player4 = new PlayerMock("Antonio"); 
		
		cards = new PackOfCardsMock(player1, player2, player3, player4);
		
		row1 = new Row(3);
		row2 = new Row(3);
		row3 = new Row(3);
		row4 = new Row(3);
	}

	@Test
	public void testAllRowFull() {
		
		cc = new ClientConnectionMock("Miguel Ángel");
		cc.getPlayer().setCurrentGame(new GameMock(player1, player2, player3, player4));
		cc.getPlayer().getCurrentGame().rows.get(0).setFull(true);
		cc.getPlayer().getCurrentGame().rows.get(1).setFull(true);
		cc.getPlayer().getCurrentGame().rows.get(2).setFull(true);
		cc.getPlayer().getCurrentGame().rows.get(3).setFull(true);
		command = "Draw";
		draw = new DrawACardCommand(command, cc);
		assertEquals("Están todas la filas completas, no puedes realizar el comando DRAW", draw.execute());
	}
	
	@Test
	public void testNotAllRowFull() {
		cc = new ClientConnectionMock("Miguel Ángel");
		cc.getPlayer().setCurrentGame(new GameMock(player1, player2, player3, player4));
		cc.getPlayer().getCurrentGame().setCards(cards);
		cc.getPlayer().getCurrentGame().rows.set(0, row1);
		cc.getPlayer().getCurrentGame().rows.set(1, row2);
		cc.getPlayer().getCurrentGame().rows.set(2, row3);
		cc.getPlayer().getCurrentGame().rows.set(3, row4);
		command = "Draw";
		draw = new DrawACardCommand(command, cc);
		assertEquals("Has robado la carta BLUE", draw.execute());
	}


}