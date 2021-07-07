package com.packt.pyetesor.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.packt.pyetesor.domain.Seminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.pyetesor.database.Database;
import com.packt.pyetesor.domain.Category;
import com.packt.pyetesor.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private Database databaz;
	
	public ArrayList<Category> showCategory(){
		Connection c = null;
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM categories " ;
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				categories.add(new Category(result1.getInt("categoryId"),result1.getString("categoryName")));
			}
			databaz.closeConnection(c);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return categories;
	}

	public Category findCategory(int categoryID){
		Connection c = null;
		Category t =null;
		try {
			c = databaz.estamblishConnection();
			String sql1="SELECT * FROM categories WHERE categoryId='"+categoryID+"'" ;// id e cdo pyetjeje esht unike kshuqe dihet qe do kthej vtm nje rezult , prandja po e mar te mireqen dhe spo bej cikel
			PreparedStatement pstmt1 = c.prepareStatement(sql1);
			ResultSet result1 = pstmt1.executeQuery();
			while (result1.next()){
				t= new Category(result1.getInt("categoryId"),result1.getString("categoryName"));
			}

		}
		catch(Exception e){
			return null;
		}
		return t;
	}
}
