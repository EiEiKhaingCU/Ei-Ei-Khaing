package com.trustcore.intern.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trustcore.intern.dta.BookInfo;
import com.trustcore.intern.dta.BookRentInfo;
import com.trustcore.intern.dta.StudentInfo;
import com.trustcore.intern.dto.BookRentDTO;
import com.trustcore.intern.model.BookRent;
import com.trustcore.intern.model.Category;

@Controller
public class BookRentController {
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     dateFormat.setLenient(false);
     webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
     }
	@Autowired
	BookRentInfo bri;
	@Autowired
	BookInfo bf;
	@Autowired
	StudentInfo si;
	@RequestMapping(value="/bookrent.htm")
	public String welcome(Model model){
		model.addAttribute("msg","Hello World");
		model.addAttribute("bookrent", new BookRentDTO());
		model.addAttribute("bookList",bf.getBooks());
		model.addAttribute("studentList",si.getStudent());
		return "bookrent";
	}
	@RequestMapping(value="/bookrent.htm",method=RequestMethod.POST)
	public String submitData(Model model,@ModelAttribute(value="bookrent") BookRentDTO br){
		BookRent book=new BookRent();
		book.setQty(br.getQty());
		book.setRentdate(br.getRentDate());
		book.getStudent().setId(br.getStudentId());
		book.getBook().setId(br.getBookId());
		bri.saveBookRent(book);
	//model.addAttribute("bookrentList", bri.getBookRent());
	return "redirect:/bookrentList.htm";
	}
	@RequestMapping(value="/bookrentList.htm")
	public String BookRentList(Model model){
		System.out.println("In Book Rent List");
		model.addAttribute("bookrentList",bri.getBookRent());
		return "bookrentList";
	}
	@RequestMapping(value="/deleteBookRent/{id}")
	public String deleteBook(Model model,@PathVariable(value="id")int id){
		System.out.println("I am a student");
		bri.deleteBookRent(id);
		return "redirect:/bookrentList.htm";
	}

}
