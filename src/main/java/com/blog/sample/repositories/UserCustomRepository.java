package com.blog.sample.repositories;

import com.blog.sample.models.User;

public interface UserCustomRepository {
	public User findByEmail(String email);
}
