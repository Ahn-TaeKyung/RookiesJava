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
		System.out.format("볼륨이 %d로 설정되었습니다.\n", volume);
	}
	@Override
	public void stop() {
		System.out.format("%s 재생이 중지되었습니다.\n", getFormat());
	}
	@Override
	public void play() {
		super.play();
		System.out.println("현재 볼륨:" + volume);
	}
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("파일 크기: " + fileSize + "MB");
	}
}
