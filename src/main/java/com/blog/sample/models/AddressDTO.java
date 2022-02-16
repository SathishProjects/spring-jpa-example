package com.blog.sample.models;

import lombok.Data;

@Data
public class AddressDTO {
	private Long id;
	private User user;
	private String users_id;
	private String street;
	private String city;
	private String state;
}
