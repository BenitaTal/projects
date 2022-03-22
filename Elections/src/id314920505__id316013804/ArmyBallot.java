package id314920505__id316013804;

public class ArmyBallot extends Ballot{
	
	public ArmyBallot(Address address) {
		super(address);		
	}
	
	public ArmyBallot() {
		super();
	}
	
	public boolean addVoter(Citizen voter, int electionYear) {
		if(voter.isQuarintined)
			return false;
		if(!super.isSoldier(voter, electionYear))
			return false;
		super.addVoterHelper(voter);
		return true;
	}
	
	public boolean equals(ArmyBallot ab) {
		return super.equals(ab);
	}
	
	@Override
	public String toString() {
		return "Army "+ super.toString();
	}
}
