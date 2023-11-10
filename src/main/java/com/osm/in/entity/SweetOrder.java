package com.osm.in.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

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
	@NotNull
	private int sweetOrderId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer customers;
	
	@NotNull
	@JsonFormat(pattern = "yyyy-mm-dd")
	private LocalDate createdDate;
	
	@ManyToOne
	private OrderBill orderBill;

}
