package com.blog.sample.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.sample.models.User;
import com.blog.sample.models.UserDTO;
import com.blog.sample.services.UserService;

@Validated
@RequestMapping("user")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(userService.getAll());
	}

	@GetMapping({ "/paginate", "/paginate/{page}" })
	public Page<User> paginate(@PathVariable(name = "page", required = false) String page) {
		return userService.paginate(page);
	}

	@GetMapping("{id}")
	public Optional<User> getById(@PathVariable Long id) {
		return userService.getById(id);
	}

	@PostMapping
	public User create(@RequestBody @Valid User user) {
		return userService.create(user);
	}

	@PatchMapping("{id}")
	public User updateById(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		return userService.updateById(id, userDTO);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		userService.deleteById(id);
	}

	@GetMapping("/test")
	public String testId(@PathParam("data") @NotNull String data) {
		return data;
	}
}
