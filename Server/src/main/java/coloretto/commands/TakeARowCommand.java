package coloretto.commands;

import coloretto.player.Card;
import coloretto.player.Game;
import coloretto.player.Player;
import coloretto.player.Row;
import coloretto.player.WaitTurn;
import coloretto.server.ClientConnection;

public class TakeARowCommand extends Command {


	public TakeARowCommand(String command, ClientConnection cc) {
		super(command, cc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() {
		
		String res = "Se esperaban 2 parámetros";
		String[] parts = command.split(" ");


		try{
			if(parts.length == 2){
				Integer idRow = Integer.valueOf(parts[1]);
				
				
				
				try{
					Row row = cc.getPlayer().getCurrentGame().getRows().get(idRow);
					if(row.getRow().isEmpty() || row.isTaken()){
						res = "No se puede coger esta fila";
					}else{
						Player currentPlayer = cc.getPlayer();
						Game currentGame = currentPlayer.getCurrentGame();
						for (Card card : row.getRow()) {
							currentPlayer.getCards().add(card);
							
						}
						row.setTaken(true);		//Poner fila como tomada
						row.getRow().clear();	//Borrar cartas de la fila
						currentGame.getPlayersInRound().remove(currentPlayer);
						currentPlayer.setCurrentState(new WaitTurn());
						currentGame.setCurrentTurn(currentGame.getCurrentTurn()-1);
						currentGame.nextTurn();
						res = "Has seleccionado la fila " + idRow.toString();
					}
					
				}catch(IndexOutOfBoundsException exc){
					res = "La fila no existe";
				}
			}
		
		}catch(NumberFormatException exc){
			res = "idFila no numérico";
		}
		
		return res;

	}

}
