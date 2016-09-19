package coloretto.commands;

import coloretto.player.Card;
import coloretto.player.Game;
import coloretto.player.Player;
import coloretto.player.Row;
import coloretto.player.WaitTurn;
import coloretto.server.ClientConnection;

public class PutACardCommand extends Command {
	
	Integer row;
	
	Player currentPlayer = cc.getPlayer();
	Game currentGame = currentPlayer.getCurrentGame() ;
	Card card = currentGame.currentCard;

	public PutACardCommand(String command, ClientConnection cc) {
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
					if(row.isFull() || row.isTaken()){
						res="La fila está completa o ya ha sido tomada en esta ronda";
					}else{
						
						
						
						if(currentGame.getPlayers().size() == 2){
							if(Integer.valueOf(0).equals(idRow)){
								if(currentGame.rows.get(0).getRow().size() < 1){
									put(idRow);
									currentGame.rows.get(0).setFull(true);
								}
							}else if (Integer.valueOf(1).equals(idRow)){
								if(currentGame.rows.get(1).getRow().size() < 2){
									put(idRow);
									if(currentGame.rows.get(1).getRow().size() == 2){
										currentGame.rows.get(1).setFull(true);
									}
								}
							}else
								if(currentGame.rows.get(2).getRow().size() < 3){
									put(idRow);
									if(currentGame.rows.get(2).getRow().size() == 3){
										currentGame.rows.get(2).setFull(true);
									}
								}
						}
						else{
							if(currentGame.rows.get(idRow).getRow().size() < 3){
								put(idRow);
								if(currentGame.rows.get(idRow).getRow().size() == 3){
									currentGame.rows.get(idRow).setFull(true);
								}
							}
					}
						res = "Has colocado la carta " + card + " en la fila " + idRow;
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

	public void put(int r){
		currentGame.rows.get(r).getRow().add(card);
		currentPlayer.setCurrentState( new WaitTurn());
		currentGame.nextTurn();
	}
}
