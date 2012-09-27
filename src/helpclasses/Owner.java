package helpclasses;

public class Owner {

	private int ownerID;
	private String password;
	private String firstName;
	private String lastName;
	private int primaryTLF;
	private String primaryMail;
	private int secondaryTLF;
	private String secondaryMail;
	
	public Owner(int ownerID, String password, String firstName, String lastName, int primaryTLF,
			String primaryMail, int secondaryTLF, String secondaryMail) {
		
		super();
		this.ownerID = ownerID;
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

	public void setLastName(String lastName) {
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
	
	
	
}
