import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import commands.GameMock;
import commands.PlayerMock;

import coloretto.player.Card;
import coloretto.player.E_Card;
import coloretto.player.Player;


public class TestPlayerScore{
	
	private Player player1, player2, player3, player4;
	
	@Before
	public void SetUp(){
		
		player1 = new PlayerMock("Lorenzo");
		player2 = new PlayerMock("Andrés");
		player3 = new PlayerMock("Miguel Ángel");
		player4 = new PlayerMock("Antonio"); 
		
		player4.setCurrentGame(new GameMock(player1, player2, player3, player4));
		
		player4.cards.add(new Card(E_Card.BLUE));
		player4.cards.add(new Card(E_Card.GREEN));
		player4.cards.add(new Card(E_Card.GREEN));
		player4.cards.add(new Card(E_Card.BLUE));
		player4.cards.add(new Card(E_Card.YELLOW));
		player4.cards.add(new Card(E_Card.GREEN));
		player4.cards.add(new Card (E_Card.PLUS_TWO));
		player4.cards.add(new Card(E_Card.YELLOW));
		player4.cards.add(new Card (E_Card.JOKER));
		player4.cards.add(new Card(E_Card.GREEN));
		player4.cards.add(new Card(E_Card.YELLOW));
		player4.cards.add(new Card (E_Card.ORANGE));
		player4.cards.add(new Card(E_Card.GREEN));
		player4.cards.add(new Card(E_Card.GREEN));
		player4.cards.add(new Card (E_Card.ORANGE));
		player4.cards.add(new Card(E_Card.YELLOW));
		player4.cards.add(new Card (E_Card.ORANGE));	
		
	}
	
	@Test
	public void testPlayerScore(){
		assertEquals(41, player4.getScore());
	}
	
}
