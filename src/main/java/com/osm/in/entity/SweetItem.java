package com.osm.in.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SweetItem {
	
	@Id
	@NotNull
	private Integer orderItemId;
	
	private Product product;
	
	@ManyToOne
	private SweetOrder  sweetOrder;
	
	@ManyToOne
	private Customer customers;

}
