 package com.trustcore.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trustcore.intern.dta.CategoryInfo;
import com.trustcore.intern.dta.StudentInfo;
import com.trustcore.intern.model.BookRent;
import com.trustcore.intern.model.Category;
import com.trustcore.intern.model.Student;
@Controller
public class CategoryController {
	@Autowired
	CategoryInfo cate;
	@RequestMapping(value="/category.htm")
	public String welcome(Model model){
		model.addAttribute("msg","Hello World");
		model.addAttribute("category", new Category());
		return "category";
	}
	@RequestMapping(value="/create_category.htm",method=RequestMethod.POST)
	public String submitData(Model model,@ModelAttribute(value="category") Category ca){
		if(ca.getId()==0)
		{
	cate.saveCategory(ca);
		}
		{
			cate.updateCategory(ca);
		}
		
	//model.addAttribute("categoryList", cate.getCategory());
	return "redirect:/categoryList.htm";
	}
	@RequestMapping(value="/categoryList.htm")
	public String Category(Model model){
		model.addAttribute("categoryList",cate.getCategory());
		return "categoryList";
	}
	@RequestMapping(value="/deleteCategory/{id}")
	public String delete(Model model,@PathVariable(value="id")int id){
		cate.deleteCategory(id);
		return "redirect:/categoryList.htm";
	}
	
	@RequestMapping(value="/updateCategory/{id}")
	public String updateCategory(Model model,@PathVariable(value="id")int id){
		model.addAttribute("category",cate.getCategory(id) );
		model.addAttribute("categoryList", this.cate.getCategory());
		return "category";
	}
}
