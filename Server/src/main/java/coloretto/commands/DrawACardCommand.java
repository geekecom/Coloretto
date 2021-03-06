package coloretto.commands;

import coloretto.player.Card;
import coloretto.player.E_Card;
import coloretto.player.Game;
import coloretto.player.Player;
import coloretto.player.Row;
import coloretto.player.State;
import coloretto.player.TurnPut;
import coloretto.server.ClientConnection;
import coloretto.server.ServerMain;

public class DrawACardCommand extends Command {
	
	
	public DrawACardCommand(String command, ClientConnection cc) {
		super(command, cc);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String execute() {
		
		String[] parts = command.split(" ");
		String info = "Se esperaba un par�metro";
		
		if(parts.length == 1){
		
			Player currentPlayer = cc.getPlayer();
			Game currentGame = currentPlayer.getCurrentGame();
			info = "Est�n todas la filas completas, no puedes realizar el comando DRAW";
			
			boolean anyRowAvailable = true;		//Modificar
			for(Row row : currentGame.getRows()){
				if(!row.isFull() && !row.isTaken()){
					anyRowAvailable = false;
					break;
				}
			}
			if(!anyRowAvailable){
			
				Card card = currentGame.cards.draw();
				if (card.getType().equals(E_Card.LAST_ROUND)){
					ServerMain.server.sendMessageToGamePlayers(currentGame, "�ltima ronda" ); //Informa de ultima ronda
					card = currentGame.cards.draw();
					currentGame.setLastRound(true);
				}
				currentGame.setCurrentCard(card);
				State<?> nextState = new TurnPut();
				currentPlayer.setCurrentState(nextState);
					
				info = "Has robado la carta " + card.toString();
			}
		}
		return info;
				
	}
	
}

