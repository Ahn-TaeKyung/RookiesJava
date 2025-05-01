package lab.book.entity;

public class ReferenceBook extends Publication {
	private String field;

	public ReferenceBook(String title, String publishingDate, int page, int price, String field) {
		super(title, publishingDate, page, price);
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" [참고서] 분야:%s, %d쪽, %d원, 출판일:%s", field, this.getPage(), this.getPrice(), this.getPublishingDate());
	}
	
}