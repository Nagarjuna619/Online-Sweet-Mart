package com.osm.in.service;

import java.util.List;

import com.osm.in.entity.Product;




public interface ProductService {
	public Product addProduct(Product product);

	public Product updateProduct(Product product);

	public Product cancelProduct(Integer productId);

	public Product showAllProducts(Integer productId);

	public List<Product> showAllProducts();
}


