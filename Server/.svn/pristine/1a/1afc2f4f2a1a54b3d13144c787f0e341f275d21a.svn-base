package coloretto.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackOfCards {
	
	private List<Card> packOfCards = new ArrayList<Card>();
	
	public PackOfCards(Player player1, Player player2){
		for(int i=0; i<3; i++)
			packOfCards.add(new Card(E_Card.JOKER));    // Añadir todas las cartas
		for (int i=0; i<10; i++)
			packOfCards.add(new Card(E_Card.PLUS_TWO));
		for (int i=0; i<8; i++) {
			packOfCards.add(new Card(E_Card.BLUE));
			packOfCards.add(new Card(E_Card.BROWN));
			packOfCards.add(new Card(E_Card.GRAY));
			packOfCards.add(new Card(E_Card.GREEN));
		}
		for (int i=0; i<9; i++){	
			packOfCards.add(new Card(E_Card.ORANGE));
		}	
		Collections.shuffle(packOfCards); 		//Baraja las cartas 
        packOfCards.add(14, new Card(E_Card.LAST_ROUND));	//Insertar carta de ultima ronda
	}
	
	public PackOfCards(Player player1, Player player2, Player player3){
		for(int i=0; i<3; i++)
			packOfCards.add(new Card(E_Card.JOKER));    
		for (int i=0; i<10; i++)
			packOfCards.add(new Card(E_Card.PLUS_TWO));
		for (int i=0; i<8; i++) {
			packOfCards.add(new Card(E_Card.BLUE));
			packOfCards.add(new Card(E_Card.BROWN));
			packOfCards.add(new Card(E_Card.GRAY));
		}
		for (int i=0; i<9; i++){
			packOfCards.add(new Card(E_Card.GREEN));
			packOfCards.add(new Card(E_Card.ORANGE));
			packOfCards.add(new Card(E_Card.PINK));
			packOfCards.add(new Card(E_Card.YELLOW));
		}
		Collections.shuffle(packOfCards); 		
        packOfCards.add(14, new Card(E_Card.LAST_ROUND));
	}
	
	public PackOfCards(Player player1, Player player2, Player player3, Player player4){
		for(int i=0; i<3; i++)
			packOfCards.add(new Card(E_Card.JOKER));    
		for (int i=0; i<10; i++)
			packOfCards.add(new Card(E_Card.PLUS_TWO));
		for (int i=0; i<8; i++) {
			packOfCards.add(new Card(E_Card.BLUE));
			packOfCards.add(new Card(E_Card.BROWN));
			packOfCards.add(new Card(E_Card.GRAY));
			packOfCards.add(new Card(E_Card.GREEN));
		}
		for (int i=0; i<9; i++){
			packOfCards.add(new Card(E_Card.ORANGE));
			packOfCards.add(new Card(E_Card.PINK));
			packOfCards.add(new Card(E_Card.YELLOW));
		}
		Collections.shuffle(packOfCards); 		
        packOfCards.add(14, new Card(E_Card.LAST_ROUND));
	}
	
	public PackOfCards(Player player1, Player player2, Player player3, Player player4, Player player5){
		for(int i=0; i<3; i++)
			packOfCards.add(new Card(E_Card.JOKER));    
		for (int i=0; i<10; i++)
			packOfCards.add(new Card(E_Card.PLUS_TWO));
		for (int i=0; i<8; i++) {
			packOfCards.add(new Card(E_Card.BLUE));
			packOfCards.add(new Card(E_Card.BROWN));
			packOfCards.add(new Card(E_Card.GRAY));
			packOfCards.add(new Card(E_Card.GREEN));
			packOfCards.add(new Card(E_Card.ORANGE));
		}
		for (int i=0; i<9; i++){
			packOfCards.add(new Card(E_Card.PINK));
			packOfCards.add(new Card(E_Card.YELLOW));
		}
		Collections.shuffle(packOfCards); 		
        packOfCards.add(14, new Card(E_Card.LAST_ROUND));
	}
	

	public Card draw(){
		Integer last = packOfCards.size() - 1;
		Card card = packOfCards.get(last);
		packOfCards.remove(card);
		return card;
	}
	
	public List<Card> getCards(){
		return packOfCards;
	}
}
