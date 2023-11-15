package com.osm.in.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.Category;
import com.onlinesweetmart.exception.EmptyCategoryListException;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.exception.InvalidCategoryDataException;
import com.onlinesweetmart.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	
	

	@Override
	public Category updateCategory(Category category) throws IdNotFoundException, InvalidCategoryDataException {
		Optional<Category> fetchCategory = categoryRepository.findById(category.getCategoryId());
		
		if(fetchCategory.isEmpty()) {
			throw new IdNotFoundException("Category with category ID: "+category.getCategoryId()+" not available");
		}
		if (Objects.nonNull(category.getCategoryId()) && !"".equalsIgnoreCase(category.getName())) {
			fetchCategory.get().setName(category.getName());
			categoryRepository.save(fetchCategory.get());
			return fetchCategory.get();
		}
		else {
			throw new InvalidCategoryDataException("Invalid data input");
		}
	}
	
	
	
	
	@Override
	public Category cancelCategory(Integer categoryId) throws IdNotFoundException {
		Optional<Category> fetchCategory = categoryRepository.findById(categoryId);
		
		if(fetchCategory.isPresent()) {
			Category tempCategory = fetchCategory.get();
			categoryRepository.deleteById(categoryId);
			return tempCategory;
		}else {
			throw new IdNotFoundException("Category with category ID: "+categoryId+" not available");
		}
	}

	
	
	
	@Override
	public List<Category> showAllCategories() throws EmptyCategoryListException {
		List<Category> fetchCategories = categoryRepository.findAll();
		
		if(fetchCategories.isEmpty()) {
			throw new EmptyCategoryListException("No categories found in the category list");
		}
		
		return fetchCategories;
	}

}
