package coloretto.player;


import java.util.Comparator;
import java.util.List;

public class ComparatorByNumberOfElements implements Comparator<List<Card>>{

	public int compare(List<Card> arg0, List<Card> arg1) {
		
		return arg1.size() - arg0.size();
	}

}
