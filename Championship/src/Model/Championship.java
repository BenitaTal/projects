package Model;

public class Championship {

	private static final int numOfGamesInQuarterFinals = 4;
	private static final int numOfGamesInSemiFinals = 2;
	private int indexQuarterFinal = 0;
	private int indexSemiFinal = 0;

	private SportGame[] quarterFinal;
	private SportGame[] semiFinal;
	private SportGame theFinal;
	private Participant theChampion;




	public Championship() {	                      
		this.quarterFinal = new SportGame[numOfGamesInQuarterFinals];
		this.semiFinal = new SportGame[numOfGamesInSemiFinals];
		this.theFinal = new SportGame() { 

			@Override
			public Participant winGame() {
				return null;
			}
		};

	}



	public Participant addParticipantToChampionship(String name) {
		Participant p = new Participant();
		p.setName(name);

		return p;
	}




	public Participant startQuarterFinalByIndex(int index) throws Exception{
		Participant winner1;
		winner1 = quarterFinal[index].winGame();

		return winner1;
	}

	public Participant startSemiFinalByIndex(int index) throws Exception{
		Participant winner2;
		winner2 = semiFinal[index].winGame();

		return winner2;

	}

	public Participant startFinal() throws Exception{
		return theFinal.winGame();
	}








	public void setQuarterFinalByParticipant(Class<?> game,Participant p) {
		if (indexQuarterFinal%2==0) {
			if (game.getSimpleName().equals("Basketball")) {
				quarterFinal[indexQuarterFinal/2] = new Basketball();
			}
			if (game.getSimpleName().equals("Soccer")) {
				quarterFinal[indexQuarterFinal/2] = new Soccer();
			}
			if (game.getSimpleName().equals("Tennis")) {
				quarterFinal[indexQuarterFinal/2] = new Tennis();
			}

		}

		if (indexQuarterFinal%2==0) {
			this.quarterFinal[indexQuarterFinal/2].setTheFirstParticipant(p);
		}
		else {
			this.quarterFinal[indexQuarterFinal/2].setTheSecondParticipant(p);
		}

		indexQuarterFinal++;

	}



	public SportGame[] getQuarterFinal() {
		return quarterFinal;

	}

	public void setQuarterFinalByGame(int index, SportGame game) {
		this.quarterFinal[index] = game;

	}



	public SportGame[] getSemiFinal() {
		return semiFinal;

	}



	public void setSemiFinal(int index, SportGame game) {
		this.semiFinal[index] = game;

	}

	public void setSemiFinalByGame(Class<?> game) {
		if (game.getSimpleName().equals("Basketball")) {
			semiFinal[indexSemiFinal/2] = new Basketball();
		}
		if (game.getSimpleName().equals("Soccer")) {
			semiFinal[indexSemiFinal/2] = new Soccer();
		}
		if (game.getSimpleName().equals("Tennis")) {
			semiFinal[indexSemiFinal/2] = new Tennis();
		}

		indexSemiFinal++;

	}

	public SportGame getTheFinal() {
		return theFinal;
	}

	public void setTheFinal(Class<?> game) {
		if (game.getSimpleName().equals("Basketball")) {
			this.theFinal = new Basketball();
		}
		if (game.getSimpleName().equals("Soccer")) {
			this.theFinal = new Soccer();
		}
		if (game.getSimpleName().equals("Tennis")) {
			this.theFinal = new Tennis();
		}
	}

	public void setTheCampion(Participant p) {
		this.theChampion=p;
	}

	public Participant getTheChampion() {
		return theChampion;
	}



}
