package lab.book.entity;


public class Novel extends Publication {
	private String author;
	private String genre;
	public Novel() {
	}

	public Novel(String title, String publishingDate, int page, int price, String author, String genre) {
		super(title, publishingDate, page, price);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return super.toString() + String.format(" [소설] 저자:%s, 장르:%s, %d쪽, %d원, 출판일:%s", author, genre, this.getPage(), this.getPrice(), this.getPublishingDate());
	}
}
