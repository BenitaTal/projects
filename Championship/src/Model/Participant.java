package Model;


public class Participant {

	private String name;
	private Integer[] score; 

	public Participant(String name) {
		this.name = name;
		this.score = new Integer[5];

		this.score[0] = new Integer(0);
		this.score[1] = new Integer(0);
		this.score[2] = new Integer(0);
		this.score[3] = new Integer(0);
		this.score[4] = new Integer(0);

	}


	public Participant() {
		this("player");

	}



	public boolean equals(Participant participant) {
		if (this.getName().equals(participant.getName())) {
			return true;
		}
		return false;
	}



	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer[] getScore() {
		return score;
	}

	public void setScore(Integer[] score) throws  Exception{
		this.score = score;
	}


}
