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
		System.out.format("Magazine 개수:%d개\nNovel 개수:%d개\nReferenceBook 개수:%d개\n기타 Publication 개수:%d개\n", countMagazine, countNovel, countReferenceBook, countEtc);
	}
	public static void main(String[] args) {
		Publication[] pubs = new Publication[7];
		pubs[0] = new Magazine("마이크로소프트","2007-10-01",328,9900,"매월");
		pubs[1] = new Magazine("경영과컴퓨터","2007-10-03",316,9000,"매월");
		pubs[2] = new Novel("빠삐용","2007-07-01",396,9800,"베르나르베르베르","현대소설");
		pubs[3] = new Novel("남한산성","2007-04-14",383,11000,"김훈","대하소설");
		pubs[4] = new ReferenceBook("실용주의프로그래머","2007-01-14",496,25000,"소프트웨어공학");	
		pubs[5] = new Novel("소년이온다","2014-05-01",216,15000,"한강","장편소설");	
		pubs[6] = new Novel("작별하지않는다","2021-09-09",332,15120,"한강","장편소설");
		
		ShoppingCart shoppingCart = new ShoppingCart();
		
		shoppingCart.addItem(pubs[1]);
		shoppingCart.addItem(pubs[2]);
		shoppingCart.addItem(pubs[5]);
		
		System.out.println("=== 장바구니 내용 ===");
		shoppingCart.displayCart();
		
		System.out.println("\n=== 장바구니 통계 ===");
		shoppingCart.printStatistics();
		
		System.out.println("\n=== 빠삐용 제거 ===");
		if (shoppingCart.removeItem("빠삐용")) {
			System.out.println("제거 성공");
		} else {
			System.out.println("제거 실패");
		}
		
		System.out.println("\n=== 장바구니 내용 ===");
		shoppingCart.displayCart();
		
		System.out.println("\n=== 장바구니 통계 ===");
		shoppingCart.printStatistics();
	}
}
