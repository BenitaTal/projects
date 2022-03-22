package id314920505__id316013804;

import java.util.Arrays;
import java.util.Scanner;

public class Ballot {
	protected int id;
	protected Address address;
	protected double votePercentage;
	protected Citizen[] voters;
	protected int numOfVoters = 0;
	protected int[] ballotResults;
	
	public Ballot(Address address) {
		this.address = address;
		this.voters = new Citizen[2];
	}
	
	public Ballot() {
		this(new Address());
	}
	
	public boolean addVoter(Citizen voter, int electionYear) {
		if(voter.isQuarintined)
			return false;
		if(isSoldier(voter, electionYear))
			return false;
		addVoterHelper(voter);
		return true;
	}
	
	public void addVoterHelper(Citizen voter) {
		if(this.voters[this.voters.length-1] != null) {
			this.voters = Arrays.copyOf(this.voters, this.voters.length*2);
		}
		
		this.voters[this.numOfVoters] = voter;
		this.numOfVoters++;
	}
	
	public boolean isSoldier(Citizen voter, int electionsYear) {
		int age = voter.getAge(electionsYear);
		return (age >= 18 && age <= 21);
	}

	public int getId() {
		return this.id;
	}
	
	public boolean setBallotesResults(int numOfParties) {
		this.ballotResults = new int[numOfParties];
		return true;
	}

	public boolean setId(int ballotIdCounter) {
		this.id = ballotIdCounter;
		return true;	
	}
	
	public boolean equals(Ballot ballot) {
		if ((this.id==ballot.id)&&(this.address.equals(ballot.address))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String str = "Ballot id: "+ this.id +" | "
				   + "ballot address: "+ this.address.toString();
		return str;
	}
	
	public String showAllVoters() {
		StringBuffer str = new StringBuffer();
		for(int i = 0; i < this.numOfVoters; i++) {
			str.append(this.voters[i].toString()+ "\n");
		}
		
		return str.toString();
	}

	public void letsVote(Scanner scn, String parties) {
		System.out.println("Welcome to Ballot #"+ this.id);
		for(int i = 0; i < this.numOfVoters; i++) {
			this.ballotResults[this.voters[i].vote(scn, parties, this.ballotResults.length-1)]++;
		}
	}
	
	public String showBallotResult(Party[] parties) {
		StringBuffer str = new StringBuffer("Results of ballot #"+ this.id +":\n");
		
		if(this.ballotResults[0] != 0)// Prevents division by zero
			str.append("Percentage of voters: "+ (double)(100-(100*((double)this.ballotResults[0]/(this.numOfVoters)))) +"%\n");
		else
			str.append("Percentage of votes: "+ 100 +"%\n");
		
		str.append("Abstained from voting: "+ this.ballotResults[0] +" citizens\n");
		
		for(int i = 1; i < this.ballotResults.length; i++) {
			if(parties[i-1] == null)
				break;
			else {
				str.append(parties[i-1].getName() +" - "+ this.ballotResults[i] +" votes.\n");
			}
		}
		
		return str.toString();
	}
	
	public boolean isExists(Citizen candidate) {
		for(int i = 0; i < this.numOfVoters; i++) {
			if(this.voters[i].equals(candidate))
				return true;
		}
		return false;
	}
}
