package Model;

public class Soccer extends SportGame{

	public Soccer(Participant p1 , Participant p2) {
		super(p1, p2);
	}

	public  Soccer() {
		super();
	}

	@Override
	public Participant winGame() throws Exception{
		setIsDraw(false);
		if ((p1.getScore()[0] + p1.getScore()[1]) > (p2.getScore()[0] + p2.getScore()[1])) {
			return p1;
		}
		else if ((p1.getScore()[0]+p1.getScore()[1]) == (p2.getScore()[0]+p2.getScore()[1])) {
			if(p1.getScore()[2] > p2.getScore()[2]) {
				return p1;
			}
			else if(p1.getScore()[2] == p2.getScore()[2]) {
				if (p1.getScore()[3] == p2.getScore()[3]) {
					setIsDraw(true);
				}
				else if (p1.getScore()[3] > p2.getScore()[3]) {	
					return p1;
				}
			}
			else {
				return p2;
			}
		}
		return p2;
	}



}
