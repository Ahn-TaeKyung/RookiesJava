package lab.book.entity;

public class Magazine extends Publication{
	private String publishPeriod;
	
	public Magazine(){
		
	}

	public Magazine(String title, String publishingDate, int page, int price, String publishPeriod) {
		super(title, publishingDate, page, price);
		this.publishPeriod = publishPeriod;
	}
	
	public String getPublishingPeriod() {
		return publishPeriod;
	}
	
	public void setPublishingPeriod(String publishPeriod) {
		this.publishPeriod = publishPeriod;
	}
	public String toString() {
		return super.toString() + String.format(" [����] �����ֱ�:%s, %d��, %d��, ������:%s", publishPeriod, this.getPage(), this.getPrice(), this.getPublishingDate());
	}
}
