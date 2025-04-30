package lab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publisthYear;
	private boolean isAvailable;
	
	public Book() {
		this.isAvailable = true;
	}
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publisthYear = publishYear;
		this.isAvailable = true;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean checkOut() {
		if (this.isAvailable == true) {
			this.isAvailable = false;
			return true;
		}
		return false;
	}
	public void returnBook() {
		this.isAvailable = true;
	}
	public String toString() {
		return "제목:" + this.title + "\t저자:" + this.author + "\tISBN:"
				+ this.isbn + "\t출판년도:" + this.publisthYear + "\t대출 가능 여부:" + this.isAvailable;
	}
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPublisthYear() {
		return publisthYear;
	}
	public void setPublisthYear(int publisthYear) {
		this.publisthYear = publisthYear;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
