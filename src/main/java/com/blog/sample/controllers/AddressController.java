package com.blog.sample.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.sample.models.Address;
import com.blog.sample.models.AddressDTO;
import com.blog.sample.services.AddressService;

@Validated
@RequestMapping("address")
@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	@GetMapping
	public ResponseEntity<List<Address>> getAll() {
		return ResponseEntity.ok(addressService.getAll());
	}

	@GetMapping({ "/paginate", "/paginate/{page}" })
	public Page<Address> paginate(@PathVariable(name = "page", required = false) String page) {
		return addressService.paginate(page);
	}

	@GetMapping("{id}")
	public Optional<Address> getById(@PathVariable Long id) {
		return addressService.getById(id);
	}

//	@PostMapping
//	public Address create(@RequestBody @Valid Address address) {
//		return addressService.create(address);
//	}

	@PatchMapping("{id}")
	public Address updateById(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
		return addressService.updateById(id, addressDTO);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		addressService.deleteById(id);
	}

	@GetMapping("/test")
	public String testId(@PathParam("data") @NotNull String data) {
		return data;
	}
}
