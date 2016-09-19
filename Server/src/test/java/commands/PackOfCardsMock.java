package commands;

import coloretto.player.Card;
import coloretto.player.E_Card;
import coloretto.player.PackOfCards;
import coloretto.player.Player;

public class PackOfCardsMock extends PackOfCards {

	public PackOfCardsMock(Player player1, Player player2, Player player3, Player player4) {
		super(player1, player2, player3, player4);
		this.getCards().add(new Card(E_Card.BLUE));
	}

}
