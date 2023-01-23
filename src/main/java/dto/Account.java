package dto;

public class Account {
	private int id;
	private String name;
	private String mel;
	private String pw;
	
	public Account(int id, String name, String mel, String pw) {
		super();
		this.id = id;
		this.name = name;
		this.mel = mel;
		this.pw = pw;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
