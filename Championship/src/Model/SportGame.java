package Model;

public abstract class SportGame {

	protected Participant p1;
	protected Participant p2;
	protected boolean isDraw;

	public SportGame(Participant p1, Participant p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.isDraw = false;
		
		
	}

	public SportGame() {
		this(new Participant(),new Participant());     
	}
	
	

	public Participant getTheFirstParticipant() {
		return p1;
	}

	public Participant getTheSecondParticipant() {
		return p2;
	}

	public void setTheFirstParticipant(Participant p1) {
		this.p1 = p1;
	}

	public void setTheSecondParticipant(Participant p2) {
		this.p2 = p2;
	}
	
	public void setIsDraw(boolean b) {
		this.isDraw = b;
	}
	
	public boolean getIsDraw() {
		return this.isDraw;
	}


	public abstract Participant winGame() throws Exception;
	
	



}
