package helpclasses;

public class Owner {

	private int ownerID;
	private String password;
	private String name;
	private int primaryTLF;
	private String primaryMail;
	private int secondaryTLF;
	private String secondaryMail;
	
	public Owner(int ownerID, String password, String name, int primaryTLF,
			String primaryMail, int secondaryTLF, String secondaryMail) {
		
		super();
		this.ownerID = ownerID;
		this.password = password;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
