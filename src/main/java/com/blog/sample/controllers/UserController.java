package com.blog.sample.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.sample.models.User;
import com.blog.sample.services.UserService;

@RequestMapping("user")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
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
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@PutMapping("{id}")
	public String updateById(@PathVariable String id) {
		return userService.updateById(id);
	}

	@PatchMapping("{id}")
	public String updateFieldById(@PathVariable String id) {
		return userService.updateFieldById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable Long id) {
		userService.deleteById(id);
	}

	@PostMapping("/request")
	public ResponseEntity<HttpStatus> postController(@RequestBody User user) {
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
