package com.packt.pyetesor.service;

import java.util.ArrayList;

import com.packt.pyetesor.domain.Category;

public interface CategoryService {

	public ArrayList<Category> showCategory();
	public Category findCategory(int categoryID);
}
