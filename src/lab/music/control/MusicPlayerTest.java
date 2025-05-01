package lab.music.control;

import lab.music.entity.MP3;
import lab.music.entity.Vinyl;

public class MusicPlayerTest {
	public static void main(String[] args) {
		MP3 song1 = new MP3("Dynamite", "BTS", 5);
		Vinyl song2 = new Vinyl("Yesterday", "The Beatles", 33);
		System.out.println("===== 음악 재생 시스템 테스트 =====");
		System.out.println("\n--- MP3 테스트 ---");
		song1.displayInfo();
		song1.play();
		song1.setVolume(8);
		song1.play();
		song1.stop();
		
		System.out.println("\n--- Vinyl 테스트 ---");
		song2.displayInfo();
		song2.play();
		song2.clean();
		
		System.out.println("\n--- 다형성 테스트 ---");
		MP3 song3 = new MP3("Butter", "BTS", 4);
		song3.displayInfo();
		song3.play();
		
		System.out.println("\n --- 캐스팅 테스트 ---");
		song3.setVolume(3);
		song3.play();
		song3.setVolume(7);
		song3.stop();
	}

}
