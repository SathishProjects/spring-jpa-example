package com.blog.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.sample.models.User;

public interface UserJpaRepository extends JpaRepository<User, Long>, UserCustomRepository {
}
