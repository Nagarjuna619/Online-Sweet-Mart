package com.osm.in.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor

@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private long userId;
	
	
	@NotBlank
	@Length(min = 3, max = 100)
	private String userName;
	
	@NotBlank
	@Length(min = 3, max = 100)
	private String password;
	
	@NotBlank
	@Length(min = 3, max = 100)
	private String passwordConfirm;
	
	@NotBlank
	@Length(min = 3, max = 100)
	private String type;	
}
