package com.osm.in.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "UserName")
	private String userName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private Set<SweetOrder> sweetOrders;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private List<Cart> cartList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private List<SweetItem> itemList;

}
