package com.osm.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	
	
	@Size(min = 3, max=10,message="length should be 3")
	private String name;
	
	@NotBlank
	//@Length(min =3,max = 100)
	private String photoPath;
	
	@NotNull
	private Double price;
	
	@NotNull
	//@Length(min =3,max = 100)
	private String description;
	
	@NotNull
	
	private Boolean available = true;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	
	@JoinColumn(name = "cart_id")
	
	@JsonIgnore
	private Cart cart;
	
	

	//@Length(min =3,max = 100)
	@ManyToOne

	@JsonIgnore
	private Category category;
	
	
	
}







