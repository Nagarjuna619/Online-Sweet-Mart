package com.osm.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetmart.entity.SweetItem;
import com.onlinesweetmart.service.SweetItemService;

//import com.onlinesweetmart.entity.SweetItem;
//import com.onlinesweetmart.service.SweetItemService;
//import com.onlinesweetmart.entity.SweetItem;
//import com.onlinesweetmart.service.SweetItemService;
//import com.onlinesweetmart.service.SweetItemService;

@RestController
@RequestMapping(value="/sweetitem")
public class SweetItemController {
	@Autowired
	private SweetItemService Item;
	
	@PostMapping("/addsweetitem")
	public ResponseEntity<SweetItem>  addSweetItem(@RequestBody SweetItem sweetItem) {
		// TODO Auto-generated method stub
		return new ResponseEntity<SweetItem>(Item.addSweetItem(sweetItem), HttpStatus.CREATED) ;
	}

	@PutMapping("/updatesweetitem")
	public  ResponseEntity<SweetItem> updateSweetItem(@RequestBody SweetItem sweetItem) {
		
		return new ResponseEntity<SweetItem>(Item.updateSweetItem(sweetItem), HttpStatus.CREATED);
	}

	@DeleteMapping("/cancelsweetitem/{sweetItemId}")
	public  ResponseEntity<SweetItem> cancelSweetItem(@PathVariable int sweetItemId) {
		
		return new ResponseEntity<SweetItem>(Item.cancelSweetItem(sweetItemId), HttpStatus.ACCEPTED) ;
	}

	@GetMapping("/showallsweetitem")
	public  ResponseEntity<List<SweetItem>> showAllSweetItems() {
		
		return new ResponseEntity<List<SweetItem>>(Item.showAllSweetItems(), HttpStatus.CREATED);
	}

//	@GetMapping("/sweetitem/{sweetItemId}")
	//public ResponseEntity<Double>  calculateTotalCost(@PathVariable int sweetItemId) {
		
		//return null;
	
}
