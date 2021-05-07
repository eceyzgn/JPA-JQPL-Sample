package com.project.repository;

import java.util.List;

import com.project.model.Brand;
import com.project.model.Category;
import com.project.model.Product;
import com.project.model.ProductDetails;

public interface ProductRepository {

	Product saveProduct (Product product);
	
	Brand saveBrand (Brand brand);
	
	Category saveCategory (Category category);
	
	List<Product> findProducts();
	
	List<Product> findProductEntities(int firstResult, int maxResult);
	
	Product findProductById(int productId);
	
	List<ProductDetails> findProductDetails();
	
	ProductDetails findProductDetailsById(int productId);
	
	List<String> findProductNames();
	
	List<Object[]> findProductNameAndPrice();
	
	List<Product> findGreatPrice(double unitPrice);
	
	List<Product> findGreatAndLessPrice(double minUnitPrice, double maxUnitPrice);
	
	List<Product> findBetweenPrice(double minUnitPrice, double maxUnitPrice);
	
	List<Product> findLikeProductName(String productName);
	
	List<Product> findInCategoryName(String categoryName1, String categoryName2);
	
	//VERÝLEN KATEGORÝLERÝNÝ PRÝCE DEÐERÝNDEN YÜKSEK OLANI GETÝR
	List<Product> findAllProduct(int categoryId);
	
	List<Object[]> findFunctionsPrice();
	
	List<Object[]> findGroupByCategory();
	
	List<Object[]> findGroupByHavingCategory(Double unitPrice);
	
	List<Product> findOrderByPrice();
}
