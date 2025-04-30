package lab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
	private String name;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
	}
	public void addBook(Book book) {
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
		books.add(book);
	}
	public Book findBookByTitle(String title) {
		for(Book book : books) {
			if (book.getTitle() == title) 
				return book;
		}
		return null;
	}
	public Book findBookByAuthor(String author) {
		for(Book book : books) {
			if (book.getAuthor() == author) 
				return book;
		}
		return null;
	}
	public Book findBookByISBN(String isbn) {
		for(Book book : books) {
			if (book.getIsbn() == isbn) 
				return book;
		}
		return null;
	}
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		return book.checkOut();
	}
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		book.returnBook();
		return true;
	}
	public List<Book> getAvailableBooks(){
		List<Book> abailableBooks = new ArrayList<Book>();
		for (Book book : books) {
			if(book.isAvailable()) {
				abailableBooks.add(book);
			}
		}
		return abailableBooks;
	}
	public List<Book> getAllBooks(){
		return books;
	}
	public int getTotalBooks() {
		return books.size();
	}
	public int getAvailableBooksCount() {
		return getAvailableBooks().size();
	}
	public int getBorrowedBooksCount() {
		List<Book> borrowedBooks = new ArrayList<Book>();
		for (Book book : books) {
			if(!book.isAvailable()) {
				borrowedBooks.add(book);
			}
		}
		return borrowedBooks.size();
	}
	public String getName() {
		return name;
	}
}
