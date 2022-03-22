package id314920505__id316013804;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Party {
	public static enum eFaction {Left, Center, Right};

	protected String name;
	protected eFaction faction;
	protected LocalDate establishDate;
	protected Politician[] candidates;
	protected int numOfCandidates = 0;
	protected int[] primeriesResults;

	public Party(String name, eFaction faction, LocalDate establishDate) {
		this.name = name;
		this.faction = faction;
		this.establishDate = establishDate;
		this.candidates = new Politician[2];
	}

	public Party() {
		this("Council of Scholars", eFaction.Center, LocalDate.of(0, 1, 1));
	}

	public void addCandidate(Politician candidate) {
		if(this.candidates[this.candidates.length-1] != null) {
			this.candidates = Arrays.copyOf(this.candidates, this.candidates.length*2);
		}

		this.candidates[this.numOfCandidates] = candidate;
		numOfCandidates++;
	}
	
	public boolean equals(Party party) {
		if ((this.name.equals(party.name))&&(this.establishDate.equals(party.establishDate))&&(this.faction.equals(party.faction))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();

		str.append("Party name: "+ this.name +", of faction: "+ this.faction.toString() +", was established at: "+ this.establishDate +"\n");
		str.append("Our candidates: ");

		for(int i = 0; i < this.numOfCandidates; i++) {
			str.append(""+ this.candidates[i].toString() +"\n");
		}

		return str.toString();
	}

	public String getName() {
		return this.name;
	}

	public String showAllCandidateInParty() {
		
		StringBuffer str = new StringBuffer("Our Candidates: \n");
		for (int i = 0; i <numOfCandidates ; i++) {
			str.append("\t"+ (i+1) +"- "+ this.candidates[i].getName() +"\n");
		}
		return str.toString();
	}
	//to check if the candidate exists
	public boolean isExists(Politician candidate) {
		for(int i = 0; i < this.numOfCandidates; i++) {
			if(this.candidates[i].equals(candidate))
				return true;
		}
		return false;
	}

	public void PrimeriesVote(Scanner scn) {
		for(int i = 0; i < this.numOfCandidates; i++) {
			this.candidates[this.candidates[i].voteForPrimeries(scn, showAllCandidateInParty(), this.numOfCandidates)-1].voted();;
		}
	}

	public void sortByPrimeriesVotes() {
		Politician temp;
		for (int i = 0; i < this.numOfCandidates-1; i++) 
			for (int j = 0; j < this.numOfCandidates-i-1; j++) 
				if (this.candidates[j].getPrimeriesVotes() > this.candidates[j+1].getPrimeriesVotes()) 
				{
					temp = this.candidates[j]; 
					this.candidates[j] = this.candidates[j+1]; 
					this.candidates[j+1] = temp; 
				} 
	}
}
