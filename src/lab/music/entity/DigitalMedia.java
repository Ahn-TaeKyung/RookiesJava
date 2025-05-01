package lab.music.entity;

public class DigitalMedia extends MusicMedia{
	private String format;

	public DigitalMedia(String title, String artist, String format) {
		super(title, artist);
		this.format = format;
	}

	@Override
	public void play() {
		System.out.format("%s ������ '%s'��(��) �����з� ����˴ϴ�.\n", format, getTitle());
	}
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("����:" + format);
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
