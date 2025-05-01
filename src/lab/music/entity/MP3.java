package lab.music.entity;

public class MP3 extends DigitalMedia implements Playable{
	private int fileSize;
	private int volume;
	public MP3(String title, String artist, int fileSize) {
		super(title, artist, "MP3");
		this.fileSize = fileSize;
		this.volume = 5;
	}
//	public MP3(String title) {
//	}
	@Override
	public void setVolume(int level) {
		this.volume = level;
		System.out.format("������ %d�� �����Ǿ����ϴ�.\n", volume);
	}
	@Override
	public void stop() {
		System.out.format("%s ����� �����Ǿ����ϴ�.\n", getFormat());
	}
	@Override
	public void play() {
		super.play();
		System.out.println("���� ����:" + volume);
	}
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("���� ũ��: " + fileSize + "MB");
	}
}
