package com.blog.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.sample.models.Address;

public interface AddressJpaRepository extends JpaRepository<Address, Long> {
}
