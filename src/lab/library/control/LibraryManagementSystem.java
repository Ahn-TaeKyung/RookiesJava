package lab.library.control;

import lab.library.entity.Book;
import lab.library.entity.Library;

public class LibraryManagementSystem {
	private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	}
	private static void testFindBook(Library library) {
		System.out.println("�������� �˻� ���:");
		System.out.println(library.findBookByTitle("�ڹ��� ����").toString());
		
		System.out.println("\n���ڷ� �˻� ���:");
		System.out.println(library.findBookByAuthor("Robert C. Martin").toString());
	}
	private static void testCheckOut(Library library) {
		if(library.checkOutBook("978-89-01-14077-4")) {
			System.out.println("���� ���� ����!");
			System.out.println("����� ���� ����:");
			System.out.println(library.findBookByISBN("978-89-01-14077-4").toString());
		}else {
			System.out.println("���� ���� ����...");
		}
		System.out.println("\n������ ���� ����:");
		System.out.println("��ü ���� ��: "+library.getTotalBooks());
		System.out.println("���� ���� ���� ��: "+library.getAvailableBooksCount());
		System.out.println("���� ���� ���� ��: "+library.getBorrowedBooksCount());
	}
	private static void testReturn(Library library) {
		if(library.returnBook("978-89-01-14077-4")) {
			System.out.println("���� �ݳ� ����!");
			System.out.println("�ݳ��� ���� ����:");
			System.out.println(library.findBookByISBN("978-89-01-14077-4").toString());
		}else {
			System.out.println("���� �ݳ� ����...");
		}
		System.out.println("\n������ ���� ����:");
		System.out.println("��ü ���� ��: "+library.getTotalBooks());
		System.out.println("���� ���� ���� ��: "+library.getAvailableBooksCount());
		System.out.println("���� ���� ���� ��: "+library.getBorrowedBooksCount());
	}
	private static void displayAvailableBooks(Library library) {
		for(Book book :library.getAllBooks()) {
			System.out.println(book.toString());
			System.out.println("----------------------------------");
		}
	}
	public static void main(String[] args) {
		Library library = new Library("�߾�");
		addSampleBooks(library);
		System.out.println("-----"+library.getName()+"������-----");
		System.out.println("��ü ���� ��: "+library.getTotalBooks());
		System.out.println("���� ���� ���� ��: "+library.getAvailableBooksCount());
		System.out.println("���� ���� ���� ��: "+library.getBorrowedBooksCount());
		
		System.out.println("\n-----���� �˻� �׽�Ʈ-----");
		testFindBook(library);
		System.out.println("\n-----���� ���� �׽�Ʈ-----");
		testCheckOut(library);
		System.out.println("\n-----���� �ݳ� �׽�Ʈ-----");
		testReturn(library);
		System.out.println("\n-----���� ������ ���� ���-----");
		displayAvailableBooks(library);
	}
}
