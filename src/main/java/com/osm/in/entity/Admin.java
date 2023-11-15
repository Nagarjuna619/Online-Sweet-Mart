package com.osm.in.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@NotNull
	private int adminId;
	
	@NotBlank
	private String password;
	
	
	@OneToOne
	@JoinColumn
	private Customer customer;
	
	@OneToOne
	@JoinColumn
	private User user;
	
	@OneToOne
	@JoinColumn
	private Product product;
	
	@OneToOne
	@JoinColumn
	private Category category;
	
	@OneToOne 
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	//@OneToOne
	//private SweetItem item;
	
	
}
