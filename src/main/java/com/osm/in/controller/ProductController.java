package com.osm.in.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetmart.entity.Product;
import com.onlinesweetmart.exception.EmptyProductListException;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.exception.ProductNotFoundException;
import com.onlinesweetmart.service.ProductService;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin
@Validated
public class ProductController {
	
	@Autowired
	private ProductService productService;
	 
	@PostMapping(value = "/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product){
		Product fetchResultProduct = productService.addProduct(product);
		
		return new ResponseEntity<Product>(fetchResultProduct, HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateproduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws IdNotFoundException{
		Product fetchUpdatedResultProduct = productService.updateProduct(product);
		
		return new ResponseEntity<Product>(fetchUpdatedResultProduct, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/cancelproduct/{id}")
	public ResponseEntity<Product> cancelProduct(@PathVariable(name = "id") 
												Integer productId) throws IdNotFoundException{
		Product fetchCanceledResultProduct = productService.cancelProduct(productId);
		
		return new ResponseEntity<Product>(fetchCanceledResultProduct, HttpStatus.OK);
	}
	
	@GetMapping(value = "/showproduct/{id}")
	public ResponseEntity<Product> showAllProducts(@PathVariable(name = "id") 
														Integer productId) throws ProductNotFoundException{
		Product fetchAllResultProducts = productService.showAllProducts(productId);
		
		return new ResponseEntity<Product>(fetchAllResultProducts, HttpStatus.OK);
	}
	
	@GetMapping(value = "/showallproducts")
		public ResponseEntity<List<Product>> showAllProducts() throws EmptyProductListException{
			List<Product> fetchAllResultProducts = productService.showAllProducts();
			
			return new ResponseEntity<List<Product>>(fetchAllResultProducts, HttpStatus.OK);
		}	
}
