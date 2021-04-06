package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

		List<Book> bookListByAuthor = bookList.stream()
				.filter(t -> t.getAuthor().equals(author))
				.collect(Collectors.toList());	

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

	@Override
	public List<Book> getBookById(int bookId) throws BookNotFoundException {
		
		List<Book> bookListById = bookList.stream()
		.filter(t -> t.getBookId()==bookId)
		.collect(Collectors.toList());	

		System.out.println();
		
//		for(Book book:bookList) {
//			if(book.getBookId()==bookId)
//			bookListById.add(book);
//		}
//		
		if(!bookListById.isEmpty())
		return bookListById;
		else
		throw new BookNotFoundException("Book Not Found");
	}

}
