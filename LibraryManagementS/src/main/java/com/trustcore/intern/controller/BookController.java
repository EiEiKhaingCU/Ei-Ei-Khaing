package com.trustcore.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trustcore.intern.dta.BookInfo;
import com.trustcore.intern.dta.CategoryInfo;
import com.trustcore.intern.dta.StudentInfo;
import com.trustcore.intern.dto.BookDTO;
import com.trustcore.intern.model.Book;
import com.trustcore.intern.model.Student;

@Controller
public class BookController {
	@Autowired
	BookInfo bi;
	@Autowired
	CategoryInfo ca;
	@RequestMapping(value="/book.htm")
	public String welcome(Model model){
		model.addAttribute("msg","Hello World");
		model.addAttribute("book", new BookDTO());
		model.addAttribute("categoryList", ca.getCategory());
		return "book";
	}
	@RequestMapping(value="/bookInfo.htm",method=RequestMethod.POST)
	public String submitData(Model model,@ModelAttribute(value="book") BookDTO b){
		Book bk=new Book();
		if(b.getId()==0)
		{
			bk.setId(b.getId());
			bk.setName(b.getName());
			bk.setAuthor(b.getAuthor());
			bk.setIsbn(b.getIsbn());
			bk.getCategory().setId(b.getCategoryId());
		bi.saveBook(bk);
		}
		{
			bi.updateBook(bk);
		}
		//model.addAttribute("bookList", bi.getBooks());
		return "redirect:/bookList.htm";
}
	@RequestMapping(value="/bookList.htm")
	public String bookList(Model model){
		model.addAttribute("bookList", bi.getBooks());
		return "bookList";
	}
	@RequestMapping(value="/deleteBook/{id}")
		public String deleteBook(Model model,@PathVariable(value="id")int id)
		{
		bi.deleteBook(id);
		return "redirect:/bookList.htm";
		}

	@RequestMapping(value="/updateBook/{id}")
	public String updateCategory(Model model,@PathVariable(value="id")int id){
		model.addAttribute("book",bi.getBook(id) );
		model.addAttribute("bookList", this.bi.getBooks());
		return "book";
	}
}