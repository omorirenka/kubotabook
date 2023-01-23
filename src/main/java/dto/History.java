package dto;

public class History {
	private int id;
	private int ac_id;
	private int book_id;
	
	public History(int id, int ac_id, int book_id) {
		super();
		this.id = id;
		this.ac_id = ac_id;
		this.book_id = book_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	
}
