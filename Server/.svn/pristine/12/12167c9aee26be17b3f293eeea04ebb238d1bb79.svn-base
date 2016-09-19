package coloretto.player;

import java.util.ArrayList;
import java.util.List;

public class Row {
	private List<Card> row;
	private boolean taken;
	private boolean full;
	
	public Row(Integer size){
		this.row = new ArrayList<Card>(size);
		this.taken = false;
		this.full = false;
	}
	
	public List<Card> getRow(){
		return row;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}
	
	public String toString(){
		return row.toString() + " Tomada: " + isTaken();
	}
	
	
}
