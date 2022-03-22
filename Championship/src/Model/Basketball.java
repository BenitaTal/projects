package Model;


public class Basketball extends SportGame{

	public Basketball(Participant p1 , Participant p2) {
		super(p1, p2);
	}

	public Basketball() {
		super();
	}

	
	@Override
	public Participant winGame() throws Exception{
		this.setIsDraw(false);
		int p1TotalPoints = 0;
		int p2TotalPoints = 0;


		p1TotalPoints = p1.getScore()[0]+p1.getScore()[1]+p1.getScore()[2]+p1.getScore()[3];
		p2TotalPoints = p2.getScore()[0]+p2.getScore()[1]+p2.getScore()[2]+p2.getScore()[3];

		if (p1TotalPoints == p2TotalPoints) {
			this.setIsDraw(true);
		}
		else {
			if (p1TotalPoints > p2TotalPoints) {
				return p1;
			}
			else {
				return p2;

			}
		}
		return null;




	}




}
