package coloretto.player;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
	public String playerID;
	public  State<?> currentState;
	public List<Card> cards;
	public Game currentGame;
	public boolean start;
	private Lobby currentLobby;
	
	public Player (){
		cards = new ArrayList<Card>();
		currentState = new Anonymous();
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}
	
	public State<?> getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State<?> currentState) {
		this.currentState = currentState;
	}

	public List<Card> getCards(){
		return cards;
	}
	
	public String getPlayerID(){
		return playerID;
	}
	
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}
	
	public String showCards(){
		String showCards = "";
		List<List<Card>> hand = new ArrayList<List<Card>>();
		
		List<Card> blue = new ArrayList<Card>(), brown = new ArrayList<Card>(), 
				gray = new ArrayList<Card>(), green = new ArrayList<Card>(), 
				orange = new ArrayList<Card>(), pink = new ArrayList<Card>(), 
				yellow = new ArrayList<Card>(), plus2 = new ArrayList<Card>(), 
				joker = new ArrayList<Card>();
		
		for (Card c: cards) {
					if (E_Card.BLUE.equals(c.getType())) blue.add(c);
			else 	if (E_Card.BROWN.equals(c.getType())) brown.add(c);
			else	if (E_Card.GRAY.equals(c.getType())) gray.add(c);
			else	if (E_Card.GREEN.equals(c.getType())) green.add(c);
			else	if (E_Card.ORANGE.equals(c.getType())) orange.add(c);
			else	if (E_Card.PINK.equals(c.getType())) pink.add(c);
			else	if (E_Card.YELLOW.equals(c.getType())) yellow.add(c);
			else	if (E_Card.PLUS_TWO.equals(c.getType())) plus2.add(c);
			else	if (E_Card.JOKER.equals(c.getType())) joker.add(c);
		}
		
		hand.add(blue);
		hand.add(brown);
		hand.add(gray);
		hand.add(green);
		hand.add(orange);
		hand.add(pink);
		hand.add(yellow);
		
		Collections.sort(hand, new ComparatorByNumberOfElements());
		
		hand.add(plus2);
		hand.add(joker);
		
		for(int i= 0; i < hand.size(); i++){
			if(!hand.get(i).isEmpty()){
				showCards = showCards.concat( "[" + hand.get(i).get(0).getType().toString() + " (" + hand.get(i).size() + ")" + "] ");
			}
		}
		
		return showCards;	
		
	}

	
	public int getScore(){
		
		List<Integer> frequencys = new ArrayList<Integer>();
		
		Integer score = 0;
		
		int blue = 0, brown = 0, gray = 0, green = 0, orange = 0;
		int pink = 0, yellow = 0, plus2 = 0, joker = 0;
		
		for (Card c: cards) {
					if (E_Card.BLUE.equals(c.getType())) blue++;
			else 	if (E_Card.BROWN.equals(c.getType())) brown++;
			else	if (E_Card.GRAY.equals(c.getType())) gray++;
			else	if (E_Card.GREEN.equals(c.getType())) green++;
			else	if (E_Card.ORANGE.equals(c.getType())) orange++;
			else	if (E_Card.PINK.equals(c.getType())) pink++;
			else	if (E_Card.YELLOW.equals(c.getType())) yellow++;
			else	if (E_Card.PLUS_TWO.equals(c.getType())) plus2++;
			else	if (E_Card.JOKER.equals(c.getType())) joker++;
		}
		
		
		frequencys.add(blue);
		frequencys.add(brown);
		frequencys.add(gray);
		frequencys.add(green);
		frequencys.add(orange);
		frequencys.add(pink);
		frequencys.add(yellow);
		Collections.sort(frequencys, Collections.reverseOrder());
		
		if(getCurrentGame().getPlayers().size() == 2){
			for (int i=0; i<joker;i++){
				if (frequencys.get(0) <= 5)
					frequencys.set(0, (frequencys.get(0) + 1));
				else 
					frequencys.set(1, (frequencys.get(1) + 1));
			}
			for (int i=0; i<2;i++){
				if (Integer.valueOf(1).equals(frequencys.get(i)))
					score += 1;
				else if (Integer.valueOf(2).equals(frequencys.get(i)))
					score += 3;
				else if (Integer.valueOf(3).equals(frequencys.get(i)))
					score += 6;
				else if (Integer.valueOf(4).equals(frequencys.get(i)))
					score += 10;
				else if (Integer.valueOf(5).equals(frequencys.get(i)))
					score += 15;
				else if (frequencys.get(i) >= 6)
					score += 21;
			}
			for (int i=2; i<5;i++){
				if (Integer.valueOf(1).equals(frequencys.get(i)))
					score -= 1;
				else if (Integer.valueOf(2).equals(frequencys.get(i)))
					score -= 3;
				else if (Integer.valueOf(3).equals(frequencys.get(i)))
					score -= 6;
				else if (Integer.valueOf(4).equals(frequencys.get(i)))
					score -= 10;
				else if (Integer.valueOf(5).equals(frequencys.get(i)))
					score -= 15;
				else if (frequencys.get(i) >= 6)
					score -= 21;
			}
				
		}
		else{
			for (int i=0; i<joker;i++){
				if (frequencys.get(0) <= 5)
					frequencys.set(0, (frequencys.get(0) + 1));
				else if (frequencys.get(1) <= 5)
					frequencys.set(1, (frequencys.get(1) + 1));
				else frequencys.set(2, (frequencys.get(2) + 1));
			}
			for (int i=0; i<3;i++){
				if (Integer.valueOf(1).equals(frequencys.get(i)))
					score += 1;
				else if (Integer.valueOf(2).equals(frequencys.get(i)))
					score += 3;
				else if (Integer.valueOf(3).equals(frequencys.get(i)))
					score += 6;
				else if (Integer.valueOf(4).equals(frequencys.get(i)))
					score += 10;
				else if (Integer.valueOf(5).equals(frequencys.get(i)))
					score += 15;
				else if (frequencys.get(i) >= 6)
					score += 21;
			}
			for (int i=3; i<7;i++){
				if (Integer.valueOf(1).equals(frequencys.get(i)))
					score -= 1;
				else if (Integer.valueOf(2).equals(frequencys.get(i)))
					score -= 3;
				else if (Integer.valueOf(3).equals(frequencys.get(i)))
					score -= 6;
				else if (Integer.valueOf(4).equals(frequencys.get(i)))
					score -= 10;
				else if (Integer.valueOf(5).equals(frequencys.get(i)))
					score -= 15;
				else if (frequencys.get(i) >= 6)
					score -= 21;
			}
		}
		score += 2 * plus2;
		return score;
	}
	
	public String toString(){
		return playerID;
	}
	
	public Game getCurrentGame(){
		return currentGame;
	}
	
	public void setCurrentGame(Game game){
		this.currentGame = game;
	}

	public Lobby getCurrentLobby() {
		return currentLobby;
	}

	public void setCurrentLobby(Lobby currentLobby) {
		this.currentLobby = currentLobby;
	}

}