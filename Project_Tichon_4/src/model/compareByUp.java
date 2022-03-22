package model;
import java.util.Comparator;
import java.util.Map.Entry;

public class compareByUp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
}
