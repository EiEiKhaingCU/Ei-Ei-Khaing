package com.trustcore.intern.dta;

import java.util.List;

import com.trustcore.intern.model.BookRent;
import com.trustcore.intern.model.Category;

public interface CategoryInfo {
	public void saveCategory(Category b);
	public List<Category> getCategory();
	public void deleteCategory(int id);
	public void updateCategory(Category c);
	public Category getCategory(int id);
}
