package com.osm.in.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_bill")
public class OrderBill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderBillId;
	private LocalDate createdDate;
	private float totalCost;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "orderBill")
	private List<SweetOrder> listSweetOrder;
	

}
