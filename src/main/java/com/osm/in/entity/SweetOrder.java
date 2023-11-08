package com.osm.in.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity 
@Data
public class SweetOrder {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sweetOrderId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer customers;
	
	
	private LocalDate createdDate;
	
	@ManyToOne
	private OrderBill orderBill;

	//private Map<Product, Long> groupedProducts;
	

}
