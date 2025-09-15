package data;

public class Customer extends User{
	protected String gender;

	public Customer(String username, String password, String type, String gender) {
		super(username, password, type);
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
