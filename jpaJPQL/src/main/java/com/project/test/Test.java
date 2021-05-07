package com.project.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

import com.project.model.Brand;
import com.project.model.Category;
import com.project.model.Product;
import com.project.model.ProductDetails;
import com.project.repository.ProductRepository;
import com.project.repository.impl.ProductRepositoryImpl;

public class Test {

	private static ProductRepository productRepository = new ProductRepositoryImpl();

	public static void main(String[] args) {

		insertData();
		
		/*
		 * QUERY 1 
		 
		 * findPrdoucts = SELECRT p FROM Product p*;
		 * 
		 * CODE:
		 
		 * List<Product> products = productRepository.findProducts();
		 
		 * for (Product product : products) {
		 
		 * System.out.println(product);
		 
		 * }
		 
		 */

		/*
		 * QUERY 2 
		 * findProductById = "SELECT 	P FROM Product p WHERE p.productId = :productId";
		 * 
		 * CODE:
		 * Product product = productRepository.findProductById(5);
		 * System.out.println(product);
		 * 
		 * 
		 */

		/*
		 * QUERY 3 
		 * findProductDetails = "SELECT new com.project.model.ProductDetails(p.name, p.unitPrice, p.available, b.name, c.name)"
		 * 		+ "FROM Product p LEFT JOIN p.brand b LEFT JOIN p.category c";
		 * 
		 * CODE:
		 * List<ProductDetails> productDetails = productRepository.findProductDetails();
		 * productDetails.forEach(System.out::println); 
		 * 
		 */

		/*
		 * QUERY 4
		 * 
		 * findProductDetailById ="SELECT NEW com.project.model.ProductDetails(p.name, p.unitPrice, p.avaible, b.name, c.name"
		 * 		+"FROM Product p LEFT JOIN p.brand b LEFT JOIN p.category c WHERE p.productId = :productId";
		 * 
		 * CODE:
		 * ProductDetails productDetails = productRepository.findProductDetailsById(3);
		 * System.out.println(productDetails);
		 * 
		 * 
		 */

		/*
		 * QUERY 5
		 * 
		 * findProductNames = "SELECT p.name FROM Product p"
		 * 
		 * CODE:
		 * List<String> productNames = productRepository.findProductNames();
		 * productNames.forEach(System.out::println);
		 */

		/*
		 * 
		 * QUERY 6
		 * 
		 * findProductNamePrice = "SELECT p.name, p.unitPrice FROM Product p";
		 * 
		 * CODE:
		 * List<Object[]> list = productRepository.findProductNamePrice();
		 * 
		 * for(Object[] objects : list) { 
		 * System.out.println(objects[0]+" = " + objects[1]);
		 *  }
		 */

		/*
		 * 
		 * QUERY 7
		 * 
		 * "SELECT p FROM Product p WHERE p.unitPrice > :unitPrice";
		 * 
		 * CODE:
		 * List<Product> products = productRepository.findGreatPrice(2700);
		 * products.forEach(System.out::println);
		 */
		
		/*
		 * 
		 * QUERY 8
		 * 
		 * findGreadAndLessPrice =
		 * "SELECT p FROM Product p WHERE p.unitPrice > : minUnitPrice AND p.unitPrice < :maxUnitPrice";
		 * 
		 * 
		 * CODE:
		 * List<Product> products = productRepository.findGreadAndLessPrice(2500, 3200);
		 * products.forEach(System.out::println);
		 */
		
		
		/*
		 * 
		 * QUERY 9
		 * 
		 * findBetweenPrice = "SELECT p FROM Product p WHERE p.unitPrice BETWEEN :minUnitPrice AND :maxUnitPrice";
		 * 
		 * CODE
		 * List<Product>products = productRepository.findBetweenPrice(2500, 3200);
		 * products.forEach(System.out::println);
		 */
		
		/*
		 * 
		 * QUERY 10
		 * 
		 * String findLikeProductName = "SELECT p FROM Product p WHERE p.name LIKE :productName";
		 * 
		 * CODE:
		 * List<Product> products = productRepository.findLikeProductName("sus");
		 * products.forEach(System.out::println);
		 */
		
		/*
		 * 
		 * QUERY 11
		 * 
		 * findInCategoryName = "SELECT p FROM Product p LEFT JOIN p.category c WHERE c.name IN(:categoryName1, :categoryName2)";
		 * 
		 * CODE:
		 * List<Product> products = productRepository.findInCategoryName("Phone",  "Computer");
		 * products.forEach(System.out::println);
		 */
		
		
		/*
		 * 
		 * QUERY 12
		 * 
		 * findAllProduct = "SELECT p FROM Product p WHERE p.unitPrice > ALL(SELECT p2.unitPrice FROM Product p2 WHERE p2.category.categoryId = :categoryId)";
		 * 
		 * CODE:
		 * List<Product>products = productRepository.findAllProduct(2);
		 * products.forEach(System.out::println);
		 */
		
		/*
		 * 
		 * QUERY 13
		 * 
		 * findFunctionPrice = "SELECT AVG(p.unitPrice),SUM(p.unitPrice), MAX(p.unitPrice), MIN(p.unitPrice), COUNT(p) FROM Product p";
		 * 
		 * CODE:
		 * List<Object[]> list = productRepository.findFunctionsPrice(); 
		 * Object[] objects = list.get(0); System.out.println("AVG: "+ objects[0] + " - SUM : " + objects[1] + " - MAX: "+ objects[2] +"- MIN : " + objects[3] + "- COUNT" + objects[4]);

		 */
		
		
		/*
		 * 
		 * QUERY 14
		 * 
		 * findGroupByCategory ="SELECT p.category.name, AVG(p.unitPrice) FROM Product p GROUP BY p.category.name";

		 * CODE:
		 * List<Object[]> list = productRepository.findGroupByCategory(); 
		 * for(Object[] objects : list) {
		 *  System.out.println("CategoryName : " + objects[0] + " - AVG : " + objects[1]); 
		 * }
		 * 
		 */
		
		/*
		 * 
		 * QUERY 15
		 * 
		 * findGroupByHavingCategory = "SELECT p.category.name, AVG(p.unitPrice) FROM Product p GROUP BY p.category.name HAVING AVG(p.unitPrice) > :unitPrice";
		 * 
		 * 
		 * CODE:
		 * List<Object[]> list =productRepository.findGroupByHavingCategory(2600.0);
		 * for(Object[] objects : list) { 
		 * 		System.out.println("CategoryName : " +objects[0] + " - AVG: " + objects[1]);
		 *  }
		 */
		/*
		 * 
		 * QUERY 16
		 * 
		 * findOrderByPrice = "SELECT p FROM Product p ORDER BY p.unitPrice DESC";
		 * 
		 * CODE:
		 * List<Product> products = productRepository.findOrderByPrice();
		 * products.forEach(System.out::println);
		 */
	}

	public static void insertData() {

		Brand brand1 = new Brand("APPLE");
		Brand brand2 = new Brand("LG");
		Brand brand3 = new Brand("SONY");
		Brand brand4 = new Brand("SAMSUNG");
		Brand brand5 = new Brand("ASUS");

		Category category1 = new Category("Computer");
		Category category2 = new Category("Tablet");
		Category category3 = new Category("Phone");

		Product product1 = new Product("Iphone 8", 3500, 2, brand1, category3, new Date());
		Product product2 = new Product("LG G3", 2500, 1, brand2, category3, new Date());
		Product product3 = new Product("Sony Experia", 2700, 1, brand3, category3, new Date());
		Product product4 = new Product("Samsung Z500", 1700, 1, brand4, category1, new Date());
		Product product5 = new Product("Mac i5", 4100, 1, brand1, category1, new Date());
		Product product6 = new Product("Asus i7", 3100, 2, brand5, category1, new Date());
		Product product7 = new Product("Galaxy Tablet", 2100, 1, brand4, category2, new Date());
		Product product8 = new Product("Ipad", 2400, 1, brand5, category2, new Date());
		Product product9 = new Product("Sony Tablet", 2400, 1, brand3, category2, new Date());

		productRepository.saveBrand(brand1);
		productRepository.saveBrand(brand2);
		productRepository.saveBrand(brand3);
		productRepository.saveBrand(brand4);
		productRepository.saveBrand(brand5);

		productRepository.saveCategory(category1);
		productRepository.saveCategory(category2);
		productRepository.saveCategory(category3);

		productRepository.saveProduct(product1);
		productRepository.saveProduct(product2);
		productRepository.saveProduct(product3);
		productRepository.saveProduct(product4);
		productRepository.saveProduct(product5);
		productRepository.saveProduct(product6);
		productRepository.saveProduct(product7);
		productRepository.saveProduct(product8);
		productRepository.saveProduct(product9);
	}
}
