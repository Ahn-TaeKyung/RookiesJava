package lab.book.control;

import java.util.ArrayList;
import java.util.List;

import lab.book.entity.Magazine;
import lab.book.entity.Novel;
import lab.book.entity.Publication;
import lab.book.entity.ReferenceBook;

public class ShoppingCart {
	private List<Publication> items;
	
	public ShoppingCart() {
		items = new ArrayList<Publication>();
	}
	
	public void addItem(Publication Item) {
		items.add(Item);
	}
	public boolean removeItem(String title) {
		for (Publication item : items) {
			if(item.getTitle().equals(title)) {
				return items.remove(item);
			}
		}
		return false;
	}
	public void displayCart() {
		for (Publication item : items) {
			System.out.println(item.toString());
		}
		
	}
	public int calculateTotalPrice() {
		int totalPrice = 0;
		for (Publication item : items) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}
	public double calculateDiscountedPrice() {
		for (Publication item : items) {
			if (item instanceof Magazine) {
				return item.getPrice() * 0.9;
			}else if (item instanceof Novel) {
				return item.getPrice() * 0.85;
			}else if (item instanceof ReferenceBook) {
				return item.getPrice() * 0.8;
			}else {
				return item.getPrice();
			}
		}
		return 0;
	}
	public void printStatistics() {
		int countMagazine = 0;
		int countNovel = 0;
		int countReferenceBook = 0;
		int countEtc = 0;
		for (Publication item : items) {
			if (item instanceof Magazine) {
				countMagazine++;
			}else if (item instanceof Novel) {
				countNovel++;
			}else if (item instanceof ReferenceBook) {
				countReferenceBook++;
			}else {
				countEtc++;
			}
		}
		System.out.format("Magazine ����:%d��\nNovel ����:%d��\nReferenceBook ����:%d��\n��Ÿ Publication ����:%d��\n", countMagazine, countNovel, countReferenceBook, countEtc);
	}
	public static void main(String[] args) {
		Publication[] pubs = new Publication[7];
		pubs[0] = new Magazine("����ũ�μ���Ʈ","2007-10-01",328,9900,"�ſ�");
		pubs[1] = new Magazine("�濵����ǻ��","2007-10-03",316,9000,"�ſ�");
		pubs[2] = new Novel("���߿�","2007-07-01",396,9800,"����������������","����Ҽ�");
		pubs[3] = new Novel("���ѻ꼺","2007-04-14",383,11000,"����","���ϼҼ�");
		pubs[4] = new ReferenceBook("�ǿ��������α׷���","2007-01-14",496,25000,"����Ʈ�������");	
		pubs[5] = new Novel("�ҳ��̿´�","2014-05-01",216,15000,"�Ѱ�","����Ҽ�");	
		pubs[6] = new Novel("�ۺ������ʴ´�","2021-09-09",332,15120,"�Ѱ�","����Ҽ�");
		
		ShoppingCart shoppingCart = new ShoppingCart();
		
		shoppingCart.addItem(pubs[1]);
		shoppingCart.addItem(pubs[2]);
		shoppingCart.addItem(pubs[5]);
		
		System.out.println("=== ��ٱ��� ���� ===");
		shoppingCart.displayCart();
		
		System.out.println("\n=== ��ٱ��� ��� ===");
		shoppingCart.printStatistics();
		
		System.out.println("\n=== ���߿� ���� ===");
		if (shoppingCart.removeItem("���߿�")) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
		
		System.out.println("\n=== ��ٱ��� ���� ===");
		shoppingCart.displayCart();
		
		System.out.println("\n=== ��ٱ��� ��� ===");
		shoppingCart.printStatistics();
	}
}
