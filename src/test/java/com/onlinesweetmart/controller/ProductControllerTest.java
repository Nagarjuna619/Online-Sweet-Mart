package com.onlinesweetmart.controller;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.onlinesweetmart.exception.IdNotFoundException;
import com.osm.in.entity.Product;
import com.osm.in.service.ProductService;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	private Product product;

	@BeforeEach
	void productControllerTestSetup() {
		//Category category = Category.builder().categoryId(1).name("Regular Sweets").build();
		product = Product.builder().productId(12).name("Barfi").photoPath("www.google.com").price(150.44)
				.description("best dessert").available(true).build();
	}

	
	@Test
	@DisplayName("Test Product Controller module for addProduct controller")
	public void addProductControllerTestCase() throws Exception {
	//	Category inputCategory = Category.builder().categoryId(1).name("Regular Sweets").build();
		Product inputProduct = Product.builder().productId(12).name("Barfi").photoPath("www.google.com").price(150.44)
				.description("best dessert").available(true).build();

		Mockito.when(productService.addProduct(inputProduct)).thenReturn(product);

		mockMvc.perform(MockMvcRequestBuilders.post("/product/addproduct").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(inputProduct)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	@Test
	@DisplayName("Test Product Controller module for showAllProducts controller")
	public void showAllProductsControllerTestCase() throws Exception {
		Mockito.when(productService.showAllProducts()).thenReturn(Collections.singletonList(product));

		mockMvc.perform(MockMvcRequestBuilders.get("/product/showallproducts").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	@Test
	@DisplayName("Test Product Controller module for cancelProduct controller")
	public void cancelProductControllerTestCase() throws Exception {
		Mockito.when(productService.cancelProduct(12)).thenReturn(product);

		mockMvc.perform(MockMvcRequestBuilders.delete("/product/cancelproduct/12").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	@Test
	@DisplayName("Test Product Controller module for updateProduct controller")
	public void updateProductControllerTestCase() throws Exception {
		//Category inputCategory = Category.builder().categoryId(6).name("Gold Wrapper Sweets").build();
		Product inputProduct = Product.builder().productId(32).name("Muffins").photoPath("www.google.com").price(650.44)
				.description("Light weight dessert").available(true).build();

		Product outputProduct = inputProduct;
		Mockito.when(productService.updateProduct(product)).thenReturn(outputProduct);

		mockMvc.perform(MockMvcRequestBuilders.put("/product/updateproduct").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(inputProduct)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	@Test
	@DisplayName("Test Product Controller module for showAllProductsById controller")
	public void showProductByIdProductControllerTestCase() throws Exception, IdNotFoundException {
		Mockito.when(productService.showAllProducts(32)).thenReturn(product);

		mockMvc.perform(MockMvcRequestBuilders.get("/product/showproduct/32").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
