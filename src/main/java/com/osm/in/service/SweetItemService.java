package com.osm.in.service;

import java.util.List;

import com.osm.in.entity.SweetItem;

public interface SweetItemService {

public SweetItem addSweetItem(SweetItem sweetItem);
	
	public SweetItem updateSweetItem(SweetItem sweetItem);
	
	public SweetItem cancelSweetItem(int sweetItemId);
	
	public List<SweetItem> showAllSweetItems();
	
	//public double calculateTotalCost(int sweetItemId);
	
}
