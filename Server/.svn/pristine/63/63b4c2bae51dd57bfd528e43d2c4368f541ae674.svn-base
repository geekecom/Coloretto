

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import commands.PlayerMock;

import coloretto.player.PackOfCards;
import coloretto.player.Player;

public class TestPackOfCards {
	
	private PackOfCards packOfCards;
	private Player player1, player2, player3;
	

	@Before
	public void setUp() throws Exception {
		
		player1 = new PlayerMock("Antonio");
		player2 = new PlayerMock("Andrés");
		player3 = new PlayerMock("Miguel Ángel");
		packOfCards = new PackOfCards(player1, player2, player3);
	}

	@Test
	public void test() {
		assertEquals(packOfCards.getCards().get(packOfCards.getCards().size() - 1), packOfCards.draw());
	}

}
