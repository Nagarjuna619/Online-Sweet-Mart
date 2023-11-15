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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Entity
public class Customer {
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	
	@NotEmpty
	@Column(name = "UserName")
	private String userName;

	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private Set<SweetOrder> sweetOrders;

	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
	private List<SweetItem> itemList;

}
