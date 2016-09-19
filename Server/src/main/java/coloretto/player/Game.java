package coloretto.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import coloretto.server.ServerMain;

public class Game {

	public static Integer gamesID = 0;
	public Integer gameID;
	public Integer round;
	public List<Player> players = new ArrayList<Player>();
	public List<Row> rows = new ArrayList<Row>();;
	public PackOfCards cards;
	public Card currentCard;
	public Integer currentTurn;
	private int lastPlayer;
	public Player currentPlayer;
	public boolean started;
	public Integer controlRound = 0;
	public boolean lastRound;
	public List<Player> playersInRound = new ArrayList<Player>();
	
	public Game(Player player1, Player player2){
		this.round = 1;
		gameID = gamesID;
		Game.gamesID++;
		players.add(player1);
		players.add(player2);
		rows.add(new Row(1));
		rows.add(new Row(2));
		rows.add(new Row(3));
		started = false;
		lastRound = false;
		player1.getCards().add(new Card(E_Card.BLUE));
		player1.getCards().add(new Card(E_Card.BROWN));
		player2.getCards().add(new Card(E_Card.GRAY));
		player2.getCards().add(new Card(E_Card.GREEN));
		cards = new PackOfCards(player1, player2);
	}
	

	public Game(Player player1, Player player2, Player player3){
		this.round = 1;
		gameID = gamesID;
		Game.gamesID++;
		players.add(player1);
		players.add(player2);
		players.add(player3);
		for (int i = 0; i < 3; i++) {
			rows.add(new Row(3));
		}
		started = false;
		lastRound = false;	
		player1.getCards().add(new Card(E_Card.BLUE));
		player2.getCards().add(new Card(E_Card.BROWN));
		player3.getCards().add(new Card(E_Card.GRAY));
		cards = new PackOfCards(player1, player2, player3);
	}
	
	public Game(Player player1, Player player2, Player player3, Player player4){
		this.round = 1;
		gameID = gamesID;
		Game.gamesID++;
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		for (int i = 0; i < 4; i++) {
			rows.add(new Row(3));
		}
		started = false;
		lastRound = false;
		player1.getCards().add(new Card(E_Card.BLUE));
		player2.getCards().add(new Card(E_Card.BROWN));
		player3.getCards().add(new Card(E_Card.GRAY));
		player4.getCards().add(new Card(E_Card.GREEN));
		cards = new PackOfCards(player1, player2, player3, player4);
	}
	
	public Game(Player player1, Player player2, Player player3, Player player4, Player player5){
		this.round = 1;
		gameID = gamesID;
		Game.gamesID++;
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		for (int i = 0; i < 5; i++) {
			rows.add(new Row(3));
		}
		started = false;
		lastRound = false;	
		player1.getCards().add(new Card(E_Card.BLUE));
		player2.getCards().add(new Card(E_Card.BROWN));
		player3.getCards().add(new Card(E_Card.GRAY));
		player4.getCards().add(new Card(E_Card.GREEN));
		player5.getCards().add(new Card(E_Card.ORANGE));
		cards = new PackOfCards(player1, player2, player3, player4, player5);
	}


	public void setStarted(boolean started) {
		this.started = started;
	}
	
	public Integer getCurrentTurn() {
		return currentTurn;
	}
	
	public List<Player> getPlayersInRound() {
		return playersInRound;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public boolean isLastRound() {
		return lastRound;
	}

	public void setLastRound(boolean lastRound) {
		this.lastRound = lastRound;
	}

	public Integer getGameID() {
		return gameID;
	}

	public String toString() {
		return "Juego: " + getGameID().toString() + ". Jugadores: "
				+ players.toString() + ". Iniciada: " + started;
	}

	public void startGame() {
		
		Collections.shuffle(players);
		this.currentTurn = 0;
		for(int i=0; i < players.size(); i++){
			playersInRound.add(players.get(i));
		}
		currentPlayer = playersInRound.get(currentTurn);
		currentPlayer.setCurrentState(new Turn());
		ServerMain.server.sendMessageToGamePlayers(this, "\n" + this.showBoard() + 
				"\n\nTurno de " + currentPlayer.getPlayerID() + "\n");
		this.started = true;
	}

	public void nextTurn() {
		
		if(playersInRound.size() == 0 && isLastRound()){
			
			String info = "\nPartida finalizada\n" + "\n" +this.showBoard() + "\n\n" + 
					this.getWinner().getPlayerID() + " ha ganado la partida\n";
		
			ServerMain.server.sendMessageToGamePlayers(this, info); //informa final de partida y ganador
		
			resetPlayers();
			
			ServerMain.server.getGames().remove(this); //Elimina el juego finalizado
		}else{
		
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
	
			currentTurn = (currentTurn + 1) % playersInRound.size();	
			currentPlayer = playersInRound.get(currentTurn);
			currentPlayer.setCurrentState(new Turn());
			
			
			ServerMain.server.sendMessageToGamePlayers(this, "\n" + this.showBoard() + 
					"\n\nTurno de " + currentPlayer.getPlayerID() + "\n");
		}

	}

	public List<Row> getRows() {
		return rows;
	}

	public Integer getControlRound() {
		return controlRound;
	}

	public void setControlRound(Integer count) {
		this.controlRound = count;
	}

	public void setCurrentCard(Card currentCard) {
		this.currentCard = currentCard;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Player getWinner() {
		Integer score = 0;
		Player winner = null;
		for (Player player : getPlayers()) {
			if (player.getScore() > score) {
				score = player.getScore();
				winner = player;
			}
		}
		return winner;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}
	
	
	public void setCards(PackOfCards cards) {
		this.cards = cards;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public void setCurrentTurn(Integer currentTurn) {
		this.currentTurn = currentTurn;
	}
	
	public String showBoard() {
		
		String board = "";
		
		if(isLastRound()){
			board = "Ultima ronda";
		}else{
			board = "Ronda " + getRound();
		}
		
		board = board.concat("\n\nEstado del tablero:");
		Integer counter = 0;
		for (Row row : rows) {
			board = board.concat("\nFila " + counter + ": " + row.toString());
			counter++;
		}

		board = board.concat("\n\n�reas de juego: ");
		for (Player p:getPlayers())
			board = board.concat("\n" + p.getPlayerID() + ": " + p.showCards() + 
					"	Puntuaci�n: " + p.getScore()) ;
		return board;
	}
	
	public void resetPlayers(){
		
		for(Player p: getPlayers()){
			p.setCurrentState(new Logued());
			p.getCards().clear();
			p.setCurrentGame(null);
			p.setCurrentLobby(null);
			p.setStart(false);
			
		}
	}
}