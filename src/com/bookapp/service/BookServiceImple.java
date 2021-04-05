package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImple implements BookService {

	ArrayList<Book> bookList = new ArrayList<>();
	
	
	@Override
	public void addBook(Book book) {
		bookList.add(book);
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws BookNotFoundException {
		 ArrayList<Book> bookListByAuthor = new ArrayList<>();
		for(Book book:bookList) {
			if(book.getAuthor().equalsIgnoreCase(author))
			bookListByAuthor.add(book);
		}
		
		if(!bookListByAuthor.isEmpty())
		return bookListByAuthor;
		else
		throw new BookNotFoundException("Book Not Found");
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookList;
	}

}
