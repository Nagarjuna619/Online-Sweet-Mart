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



@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryService categoryService;

	private Category category;

	@BeforeEach
	void categoryControllerTestSetup() {
		category = Category.builder().categoryId(1).name("Regular Sweets").build();
	}

	
	@Test
	@DisplayName("Test Category Controller module for addCategory controller")
	public void addCategoryControllerTestCase() throws Exception {
		Category inputCategory = Category.builder().name("Regular Sweets").build();

		Mockito.when(categoryService.addCategory(inputCategory)).thenReturn(category);

		mockMvc.perform(MockMvcRequestBuilders.post("/category/addcategory").contentType(MediaType.APPLICATION_JSON)
				.content("{\n" + "\t\"categoryName\":\"Regular Sweets\"\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	@Test
	@DisplayName("Test Category Controller module for showAllCategories controller")
	public void showAllCategoriesControllerTestCase() throws Exception {
		Mockito.when(categoryService.showAllCategories()).thenReturn(Collections.singletonList(category));

		mockMvc.perform(MockMvcRequestBuilders.get("/category/showallcategory").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	@Test
	@DisplayName("Test Category Controller module for cancelCategory controller")
	public void cancelCategoryControllerTestCase() throws Exception {
		Mockito.when(categoryService.cancelCategory(1)).thenReturn(category);

		mockMvc.perform(MockMvcRequestBuilders.delete("/category/cancelcategory/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	@Test
	@DisplayName("Test Category Controller module for updateCategory controller")
	public void updateCategoryControllerTestCase() throws Exception {
		Category inputCategory = Category.builder().categoryId(1).name("Bangali Sweets").build();

		Category outputCategory = Category.builder().categoryId(1).name("Bangali Sweets").build();

		Mockito.when(categoryService.updateCategory(inputCategory)).thenReturn(outputCategory);

		mockMvc.perform(MockMvcRequestBuilders.put("/category/updatecategory/").contentType(MediaType.APPLICATION_JSON)
				.content("{\n" + "\t\"categoryId\":\"1\",\n" + "\t\"name\":\"Bangali Sweets\"\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
