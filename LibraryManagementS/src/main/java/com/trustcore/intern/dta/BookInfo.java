package com.trustcore.intern.dta;

import java.util.List;

import com.trustcore.intern.dto.BookDTO;
import com.trustcore.intern.model.Book;


public interface BookInfo {
	public List<Book> getBooks();
	public void saveBook(Book book);
	public void deleteBook(int id);
	public BookDTO getBook(int id);
	public void updateBook(Book bk);
}
