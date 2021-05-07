package com.project.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.project.jpaFactory.JPAFactory;
import com.project.jpaFactory.impl.JPAFactoryImpl;
import com.project.model.Brand;
import com.project.model.Category;
import com.project.model.Product;
import com.project.model.ProductDetails;
import com.project.queries.ProductQueries;
import com.project.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

	private JPAFactory jpaFactory = new JPAFactoryImpl();

	private EntityManager entityManager = jpaFactory.getEntityManager();

	private EntityTransaction entityTransaction = jpaFactory.getTransaction();

	@Override
	public Product saveProduct(Product product) {

		this.entityTransaction.begin();

		this.entityManager.persist(product);

		this.entityTransaction.commit();

		return product;
	}

	@Override
	public Brand saveBrand(Brand brand) {

		this.entityTransaction.begin();

		this.entityManager.persist(brand);

		this.entityTransaction.commit();

		return brand;
	}

	@Override
	public Category saveCategory(Category category) {

		this.entityTransaction.begin();

		this.entityManager.persist(category);

		this.entityTransaction.commit();

		return category;
	}

	@Override
	public List<Product> findProducts() {

//		Query query = this.entityManager.createQuery(ProductQueries.findProducts);
//		List<Product> products = query.getResultList();

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findProducts, Product.class);

		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public List<Product> findProductEntities(int firstResult, int maxResult) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findProducts, Product.class);
		typedQuery.setFirstResult(firstResult);
		typedQuery.setMaxResults(maxResult);

		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public Product findProductById(int productId) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findProductById, Product.class);
		typedQuery.setParameter("productId", productId);

		Product product = typedQuery.getSingleResult();

		return product;
	}

	@Override
	public List<ProductDetails> findProductDetails() {

		TypedQuery<ProductDetails> typedQuery = this.entityManager.createQuery(ProductQueries.findProductDetails,
				ProductDetails.class);

		List<ProductDetails> productDetails = typedQuery.getResultList();

		return productDetails;
	}

	@Override
	public ProductDetails findProductDetailsById(int productId) {

		TypedQuery<ProductDetails> typedQuery = this.entityManager.createQuery(ProductQueries.findProductDetailById,
				ProductDetails.class);

		typedQuery.setParameter("productId", productId);

		ProductDetails productDetails = typedQuery.getSingleResult();

		return productDetails;
	}

	@Override
	public List<String> findProductNames() {

		TypedQuery<String> typedQuery = this.entityManager.createQuery(ProductQueries.findProductNames, String.class);

		List<String> productsNames = typedQuery.getResultList();

		return productsNames;
	}

	@Override
	public List<Object[]> findProductNameAndPrice() {

		Query query = this.entityManager.createQuery(ProductQueries.findProductNamePrice);

		@SuppressWarnings("unchecked")
		List<Object[]> productNameAndPrice = query.getResultList();

		return productNameAndPrice;
	}

	@Override
	public List<Product> findGreatPrice(double unitPrice) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findGreatPrice, Product.class);

		typedQuery.setParameter("unitPrice", unitPrice);

		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public List<Product> findGreatAndLessPrice(double minUnitPrice, double maxUnitPrice) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findGreadAndLessPrice,
				Product.class);

		typedQuery.setParameter("minUnitPrice", minUnitPrice);
		typedQuery.setParameter("maxUnitPrice", maxUnitPrice);

		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public List<Product> findBetweenPrice(double minUnitPrice, double maxUnitPrice) {
		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findBetweenPrice, Product.class);

		typedQuery.setParameter("minUnitPrice", minUnitPrice);
		typedQuery.setParameter("maxUnitPrice", maxUnitPrice);

		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public List<Product> findLikeProductName(String productName) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findLikeProductName,
				Product.class);

		typedQuery.setParameter("productName", "%" + productName + "%");

		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public List<Product> findInCategoryName(String categoryName1, String categoryName2) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findInCategoryName,
				Product.class);

		typedQuery.setParameter("categoryName1", categoryName1);
		typedQuery.setParameter("categoryName2", categoryName2);

		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public List<Product> findAllProduct(int categoryId) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findAllProduct, Product.class);

		typedQuery.setParameter("categoryId", categoryId);

		List<Product> products = typedQuery.getResultList();

		return products;
	}

	@Override
	public List<Object[]> findFunctionsPrice() {

		Query query = this.entityManager.createQuery(ProductQueries.findFunctionPrice);

		@SuppressWarnings("unchecked")
		List<Object[]> functionPrice = query.getResultList();

		return functionPrice;
	}

	@Override
	public List<Object[]> findGroupByCategory() {

		Query query = this.entityManager.createQuery(ProductQueries.findGroupByCategory);

		@SuppressWarnings("unchecked")
		List<Object[]> groupByCategory = query.getResultList();

		return groupByCategory;
	}

	@Override
	public List<Object[]> findGroupByHavingCategory(Double unitPrice) {

		Query query = this.entityManager.createQuery(ProductQueries.findGroupByHavingCategory);

		query.setParameter("unitPrice", unitPrice);
		
		@SuppressWarnings("unchecked")
		List<Object[]> groupByHavingCategory = query.getResultList();

		return groupByHavingCategory;
	}

	@Override
	public List<Product> findOrderByPrice() {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findOrderByPrice, Product.class);

		List<Product> products = typedQuery.getResultList();

		return products;
	}
}
