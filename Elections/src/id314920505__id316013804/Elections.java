package id314920505__id316013804;
import java.util.Arrays;
import java.util.Scanner;

public class Elections {
	protected int month;
	protected int year;
	protected Ballot[] ballots;
	protected Party[] parties;
	protected int ballotIdCounter = 1;
	protected int partiesCounter = 0;
	protected int[] results;
	protected boolean hasStarted = false;


	public Elections(int month, int year) {
		this.year = year;
		this.month = month;
		this.ballots = new Ballot[2];
		this.parties = new Party[2];
	}
	public Ballot findBallotById(int id) {
//		for(int i = 0; i < this.ballotIdCounter; i++) {
//			if(id == this.ballots[i].getId()) {
//				return this.ballots[i];
//			}
//		}
//		return null;
		
		//for now we don't have remove ballot so this is more efficient
		if(id <= this.ballotIdCounter || id > 0)
			return this.ballots[id-1];
		return null;
	}


	public void addBallot(Ballot ballot) {
		if(this.ballots[this.ballots.length-1] != null) {
			this.ballots = Arrays.copyOf(this.ballots, this.ballots.length*2);
		}

		ballot.setId(this.ballotIdCounter);
		this.ballots[this.ballotIdCounter-1] = ballot;
		this.ballotIdCounter++;
	}

	public boolean addCitizen(Citizen citizen) {
		if(isCitizenExists(citizen))
			return false;
		
		Ballot tempBallot = citizen.getBallot();
		if(tempBallot != null) {
			return citizen.getBallot().addVoter(citizen, this.year);
		}
		return false;


	}

	public void addParty(Party party) {
		if(this.parties[this.parties.length-1] != null) {
			this.parties = Arrays.copyOf(this.parties, this.parties.length*2);
		}

		this.parties[this.partiesCounter] = party;
		this.partiesCounter++;
	}

	public boolean addCandidateToParty(Party party, Politician candidate) {
		if(isCandidateExists(candidate))
			return false;
		
		boolean b = false;
		int i = 0;
		while(!b && i <= this.partiesCounter) {
			if(this.parties[i] == party)
				b = true;
			i++;
		}
		if(b) {
			addCitizen(candidate);
			party.addCandidate(candidate);
		}
		return b;
	}

	public String showAllBallots() {
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < this.ballotIdCounter-1; i++) {
			str.append(this.ballots[i].toString()+ "\n");
		}
		return str.toString();
	}

	public String showAllVoters() {

		StringBuffer str = new StringBuffer();
		for(int i = 0; i < this.ballotIdCounter-1; i++) {
			str.append("In ballot #"+ (i+1) +": \n");
			str.append(this.ballots[i].showAllVoters());
			
		}

		return str.toString();
	}

	public void startElections() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Let the elactions Begin!");
		
		for(int i = 0; i < this.partiesCounter; i++) {
			this.parties[i].PrimeriesVote(scn);
			this.parties[i].sortByPrimeriesVotes();
		}
		
		for(int i = 0; i < this.ballotIdCounter-1; i++) {
			this.ballots[i].setBallotesResults(this.partiesCounter+1);
			this.ballots[i].letsVote(scn, showAllParties());
		}

		this.hasStarted = true;
	}

	public String showAllParties() {
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < this.partiesCounter; i++) {
			str.append((i+1) +" - "+ this.parties[i].getName() +", faction of "+this.parties[i].faction+ ", was astablish at "+this.parties[i].establishDate+"\n");
			str.append(parties[i].showAllCandidateInParty());
		}

		return str.toString();
	}

	private void countVotes() {
		this.results = new int[this.partiesCounter+1];
		for(int i = 0; i < this.ballotIdCounter-1; i++) {
			for(int j = 0; j < this.partiesCounter+1; j++) {
				this.results[j] += this.ballots[i].ballotResults[j];
			}
		}
	}

	public String showElectionsResults() {

		StringBuffer str = new StringBuffer("\nHere are the "+ this.month +"/"+ this.year +" elections results: \n");

		for(int i = 0; i < this.ballotIdCounter-1; i++) {
			str.append(this.ballots[i].showBallotResult(this.parties) +"\n");
		}

		str.append("Results summary: \n");
		countVotes();
		str.append("Abstained from voting: "+ this.results[0] +" citizens\n");

		for(int i = 1; i <= this.partiesCounter; i++) {
			str.append(this.parties[i-1].getName() +"- "+ this.results[i] +" votes. \n");
		}
		
		str.append("The leading party for votes in the elections are: "+ findLeadingPartyName() +"\n");

		str.append("And now forming a coalition.... wait... Something went wrong /: .... See you again in 3 months! \n");

		return str.toString();
	}
	private String findLeadingPartyName() {
		String str = "";
		int max = 1;
	    for (int i = 2; i < this.results.length; i++) {
	        if (this.results[i] > this.results[max]) {
	            max = i;
	            str = this.parties[i-1].getName(); 
	        }
	        else if(this.results[i] == this.results[max]) {
	        	str += ", "+ this.parties[i-1];
	        }
	    }
	    return str;
	}

	//to avoid creating the same candidate
	private boolean isCandidateExists(Politician candidate) {
		for(int i = 0; i < this.partiesCounter; i++) {
			if(this.parties[i].isExists(candidate))
				return true;
		}
		return false;
	}
	//to avoid creating the same citizen
	private boolean isCitizenExists(Citizen voter) {
		for(int i = 0; i < this.ballotIdCounter-1; i++) {
			if(this.ballots[i].isExists(voter))
				return true;
		}
		return false;
	}

	public Party[] getParties() {
		return this.parties;
	}
}
