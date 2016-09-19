package commands;

import java.util.Collections;

import coloretto.player.Game;
import coloretto.player.Player;
import coloretto.player.Row;
import coloretto.player.Turn;

public class GameMock extends Game{
	
	private int lastPlayer;

	public GameMock(Player player1, Player player2, Player player3,
			Player player4) {
		super(player1, player2, player3, player4);
		// TODO Auto-generated constructor stub
	}
	
	public void nextTurn() {
		if(playersInRound.size() == 1){
			lastPlayer = players.indexOf(playersInRound.get(0));
		}
		if(playersInRound.size() == 0){
			for(int i=0; i < players.size(); i++){
				playersInRound.add(players.get(i));
			}
			setRound(getRound() + 1);
			currentTurn = lastPlayer -1;
			for(Row row: getRows()){
				row.setFull(false);
				row.setTaken(false);
				row.getRow().clear();
			}
			
		}

		currentTurn = (currentTurn + 1) % playersInRound.size();	//Problema con el +1
		currentPlayer = playersInRound.get(currentTurn);
		currentPlayer.setCurrentState(new Turn());
	}
	
	public void startGame() {
		Collections.shuffle(players);
		this.currentTurn = 0;
		currentPlayer = players.get(currentTurn);
		currentPlayer.setCurrentState(new Turn());
		this.started = true;
	}
}

