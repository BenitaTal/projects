package id314920505__id316013804;

import java.util.Scanner;

public class CoronaBallot extends Ballot {

	public CoronaBallot(Address address) {
		super(address);
	}

	public CoronaBallot() {
		super();
	}

	@Override
	public void letsVote(Scanner scn, String parties) {
		System.out.println("Welcome to Ballot #"+ this.id);
		for(int i = 0; i < super.numOfVoters; i++) {
			this.ballotResults[super.voters[i].vote(scn, parties, super.ballotResults.length-1)]++;
		}
	}

	public boolean addVoter(Citizen voter, int electionYear) {
		if(!voter.isQuarintined)
			return false;
		super.addVoterHelper(voter);
		return true;
	}
	
	public boolean equals(CoronaBallot cb) {
		return super.equals(cb);
	}

	@Override
	public String toString() {
		return "Corona "+ super.toString();
	}
}
