package helpclasses;

public class Owner {

	private int username;
	private String password;
	private String firstName;
	private String lastName;
	private int primaryTLF;
	private String primaryMail;
	private int secondaryTLF;
	private String secondaryMail;
	
	public Owner(int username, String password, String firstName, String lastName, int primaryTLF,
			String primaryMail, int secondaryTLF, String secondaryMail) {
		
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.primaryTLF = primaryTLF;
		this.primaryMail = primaryMail;
		this.secondaryTLF = secondaryTLF;
		this.secondaryMail = secondaryMail;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public String getPassword() {
		return password;
	} 

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName() {
		this.lastName = lastName;
	}
	
	public int getPrimaryTLF() {
		return primaryTLF;
	}

	public void setPrimaryTLF(int primaryTLF) {
		this.primaryTLF = primaryTLF;
	}

	public String getPrimaryMail() {
		return primaryMail;
	}

	public void setPrimaryMail(String primaryMail) {
		this.primaryMail = primaryMail;
	}

	public int getSecondaryTLF() {
		return secondaryTLF;
	}

	public void setSecondaryTLF(int secondaryTLF) {
		this.secondaryTLF = secondaryTLF;
	}

	public String getSecondaryMail() {
		return secondaryMail;
	}

	public void setSecondaryMail(String secondaryMail) {
		this.secondaryMail = secondaryMail;
	}
	
	public String toString() {
		return "Owner ID: " + ownerID + "\t | Password: " + password +
				"\t | First name: " + firstName +
				"\t | Last name: " + lastName +
				"\t | Telephone: " + primaryTLF +
				"\t | Mail: " + primaryMail +
				"\t | Telephone (friend): " + secondaryTLF +
				"\t | Mail (friend): " + secondaryMail;
	}
	
}
