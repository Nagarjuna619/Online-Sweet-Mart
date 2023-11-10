package com.osm.in.service;

import java.util.List;

import com.osm.in.entity.SweetOrder;



public interface SweetOrderService {

	public SweetOrder addSweetOrder(SweetOrder sweetOrder);
	
	public SweetOrder updateSweetOrder(SweetOrder sweetOrder);
	
	public SweetOrder cancelSweetOrder(int sweetOrderId);
	
	public List<SweetOrder> showAllSweetOrders();
	
	public double calculateTotalCost(int sweetOrderId);
}
