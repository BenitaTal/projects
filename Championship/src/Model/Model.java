package Model;


public class Model {
	private Championship championship;

	public Model(Championship championship) {
		this.championship = championship;

	}

	public Model() {
		championship = new Championship();
		
	}


	public Participant addParticipantToChampionship(String name) {
		return this.championship.addParticipantToChampionship(name);
		
	}
	
	public Participant startQuarterFinalByIndex(int index) throws Exception{
		return this.championship.startQuarterFinalByIndex(index);
		
	}
	
	public Participant startSemiFinalByIndex(int index) throws Exception{
		return this.championship.startSemiFinalByIndex(index);
		
	}
	
	public Participant startFinal() throws Exception{
		return this.championship.startFinal();
		
	}
	
	public void setQuarterFinalByParticipant(Class<?> game,Participant p) {
		this.championship.setQuarterFinalByParticipant(game, p);
	}
	
	
	public Championship getChampionship() {
		return this.championship;

	}



	

	
}



