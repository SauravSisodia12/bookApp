package com.bookapp.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImple;

public class UserMain {

	public static void main(String[] args) {
		
		BookServiceImple bookService = new BookServiceImple();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) 
		{
		System.out.print("Enter Book Title = ");
		String title = sc.next();
		System.out.print("Enter Book Author = ");
		String author = sc.next();
		System.out.print("Enter Book Id = ");
		int bookId = sc.nextInt();
		System.out.print("Enter Book Category = ");
		String category = sc.next();
		Book book = new Book(title,author,bookId,category);
		bookService.addBook(book);
		System.out.println();
		}
		System.out.println("No of Book Records Added = "+bookService.getAllBooks().size());
		Iterator<Book> i = bookService.getAllBooks().iterator();
		while(i.hasNext()) {
			Book c = i.next();
			System.out.println(c);
		}
		
		System.out.println();
		
		System.out.print("Enter author name to see his books = ");
		String userAuthor = sc.next();
		try {
			ArrayList<Book> booksListByAuthor = (ArrayList<Book>) bookService.getBookByAuthor(userAuthor);
			System.out.println("Books By ("+userAuthor+") :");
			
			Iterator<Book> j = booksListByAuthor.iterator();
			while(j.hasNext()) {
				Book b = j.next();
				System.out.println(b);
			}
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
