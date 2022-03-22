package Model;

public class Tennis extends SportGame{

	public Tennis(Participant p1 , Participant p2) {
		super(p1, p2);
	}

	public  Tennis() {
		super();
	}


	@Override
	public Participant winGame() throws Exception{
		setIsDraw(false);
		int p1wins = 0;
		int p2wins = 0;
		int p1Sum = 0;
		int p2Sum = 0;


		for (int i = 0; i < 5; i++) {
			p1Sum += p1.getScore()[i];
			p2Sum += p2.getScore()[i];

			if (p1Sum == p2Sum) {
				setIsDraw(true);
			}

			if (p1.getScore()[i] > 7 || p2.getScore()[i] > 7) {
				setIsDraw(true);
			}

			if ((p1.getScore()[i] < p2.getScore()[i]) && ((p2.getScore()[i] >= 6) || (p1.getScore()[i] >= 6)) ) {
				p2wins++;
			}
			else {
				p1wins++;
			}
		}


		if (p1wins > p2wins) {
			return p1;
		}
		else {

			return p2;
		}
	}



}
