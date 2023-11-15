package com.osm.in.entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ManyToAny;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int cartId;
	
	@NotNull
	private double grandTotal;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	//@JoinColumn
	private List<Product> listProduct;
	
	@NotNull
	private int productCount;
	
	@NotNull
	private double total;	
	
	@ManyToOne
	private Customer customers;
		
}
