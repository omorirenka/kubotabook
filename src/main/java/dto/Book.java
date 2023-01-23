package dto;

public class Book {
	private int id;
	private String bookname;
	private String name;
	private String syuppan;
	
	public Book(int id, String bookname, String name, String syuppan) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.name = name;
		this.syuppan = syuppan;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSyuppan() {
		return syuppan;
	}
	public void setSyuppan(String syuppan) {
		this.syuppan = syuppan;
	}
	
	
}
