package lab.book.control;

import lab.book.entity.Magazine;
import lab.book.entity.Novel;
import lab.book.entity.Publication;
import lab.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		Publication[] pubs = new Publication[7];
		pubs[0] = new Magazine("����ũ�μ���Ʈ","2007-10-01",328,9900,"�ſ�");
		pubs[1] = new Magazine("�濵����ǻ��","2007-10-03",316,9000,"�ſ�");
		pubs[2] = new Novel("���߿�","2007-07-01",396,9800,"����������������","����Ҽ�");
		pubs[3] = new Novel("���ѻ꼺","2007-04-14",383,11000,"����","���ϼҼ�");
		pubs[4] = new ReferenceBook("�ǿ��������α׷���","2007-01-14",496,25000,"����Ʈ�������");	
		pubs[5] = new Novel("�ҳ��̿´�","2014-05-01",216,15000,"�Ѱ�","����Ҽ�");	
		pubs[6] = new Novel("�ۺ������ʴ´�","2021-09-09",332,15120,"�Ѱ�","����Ҽ�");	
		System.out.println("==== ���� ���� ��� ====");
		int index = 1;
		for (Publication publication : pubs) {
			System.out.println(String.format("%d.", index)+publication.toString());
			index++;
		}
		
		Publication pub6 = pubs[6];
		System.out.println("\n=== ���� ���� ===");
		System.out.println(pub6.getTitle() + " ���� �� ����: " + pub6.getPrice() + "��");
		modifyPrice(pub6);
		System.out.println(pub6.getTitle() + " ���� �� ����: " + pub6.getPrice() + "��");
		
		System.out.println("\n====== ���ǹ� ��� �м� =====");
		StatisticsAnalyzer statisticsAnalyzer = new StatisticsAnalyzer();
		statisticsAnalyzer.printStatistics(pubs);
		System.out.println("============================");
	}
	public static void modifyPrice(Publication pub) {
		double rate = 0.0;
		if(pub instanceof Magazine) {
			rate = 0.9; //40%
		}
		if(pub instanceof Novel) {
			rate = 0.85; //20%
		}
		if(pub instanceof ReferenceBook) {
			rate = 0.8; //10%
		}
		
		pub.setPrice((int)(pub.getPrice() * rate));		
		
	}
}