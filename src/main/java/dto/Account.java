package dto;

public class Account {
	private int id;
	private String name;
	private String mel;
	private String salt;
	private String password;
	private String hashedPassword;
	
	public Account(int id, String name, String mel, String salt, String password, String hashedPassword) {
		super();
		this.id = id;
		this.name = name;
		this.mel = mel;
		this.salt = salt;
		this.password = password;
		this.hashedPassword = hashedPassword;
	}

	public Account(int id, String name, String mel, String salt, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mel = mel;
		this.salt = salt;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMel() {
		return mel;
	}

	public void setMel(String mel) {
		this.mel = mel;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
}
