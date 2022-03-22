package id314920505__id316013804;
// basic Address class for the location of the ballots
public class Address {
	private String city;
	private String street;
	private int houseNo;

	public Address(String city, String street, int houseNo) {
		this.city = city;
		this.street = street;
		this.houseNo = houseNo;
	}

	public Address() {
		this.city = "City";
		this.street = "Street";
		this.houseNo = 0;
	}

	public boolean equals(Address address) {
		if ((this.city.equals(address.city))&&(this.street.equals(address.street))&&(this.houseNo==address.houseNo)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.street +", "+ this.houseNo +", "+ this.city;
	}
}
