package com.trustcore.intern.dta;

import java.util.List;

import com.trustcore.intern.model.BookRent;


public interface BookRentInfo {
	public void saveBookRent(BookRent br);
	public List<BookRent> getBookRent();
	public void deleteBookRent(int id);


}
