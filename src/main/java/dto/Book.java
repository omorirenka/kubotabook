package dto;

public class Book {
	private int id;
	private String bookname;
	private String name;
	private String syuppan;
	private String kasikari;
	
	public Book(int id, String bookname, String name, String syuppan,String kasikari) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.name = name;
		this.syuppan = syuppan;
		this.kasikari = kasikari;
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

	public String getKasikari() {
		return kasikari;
	}

	public void setKasikari(String kasikari) {
		this.kasikari = kasikari;
	}
	
	
}
