package com.blog.sample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.blog.sample.mappers.UserMapper;
import com.blog.sample.models.User;
import com.blog.sample.models.UserDTO;
import com.blog.sample.repositories.AddressJpaRepository;
import com.blog.sample.repositories.UserJpaRepository;

@Service
public class UserService {

	@Autowired
	UserJpaRepository userJpaRepository;

	@Autowired
	AddressJpaRepository addressJpaRepository;

	@Autowired
	UserMapper userMapper;

	public List<User> getAll() {
		return userJpaRepository.findAll();
	}

	public Page<User> paginate(String page) {
		int limit = ((page != null) && (Integer.parseInt(page) > 0)) ? Integer.parseInt(page) : 1;
		return userJpaRepository.findAll(PageRequest.of(limit - 1, 2));
	}

	public Optional<User> getById(Long id) {
		return userJpaRepository.findById(id);
	}

	public User create(User user) {
		User existingUser = userJpaRepository.findByEmail(user.getEmail());
		if (existingUser == null) {
			return userJpaRepository.save(user);
		}
		return existingUser;
	}

	public User updateById(Long id, UserDTO userDTO) {
		User existingUser = userJpaRepository.findById(id).orElse(null);
		if (existingUser != null) {
			userMapper.updateCustomerFromDto(userDTO, existingUser);
			return userJpaRepository.save(existingUser);
		}
		return existingUser;
	}

	public void deleteById(Long id) {
		userJpaRepository.deleteById(id);
	}
}
