package com.blog.sample.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
//@DynamicUpdate
@Table(name = "users")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "address"})
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	@Column
	public String name;

	@Email
	@Column(unique = true)
	public String email;

	@OneToOne(mappedBy = "user")
	private Address address;

	@JsonIgnore
	private transient String testTransient;
}