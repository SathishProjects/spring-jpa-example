package com.blog.sample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.blog.sample.mappers.AddressMapper;
import com.blog.sample.models.Address;
import com.blog.sample.models.AddressDTO;
import com.blog.sample.repositories.AddressJpaRepository;

@Service
public class AddressService {

	@Autowired
	AddressJpaRepository addressJpaRepository;

	@Autowired
	AddressMapper addressMapper;

	public List<Address> getAll() {
		return addressJpaRepository.findAll();
	}

	public Page<Address> paginate(String page) {
		int limit = ((page != null) && (Integer.parseInt(page) > 0)) ? Integer.parseInt(page) : 1;
		return addressJpaRepository.findAll(PageRequest.of(limit - 1, 2));
	}

	public Optional<Address> getById(Long id) {
		return addressJpaRepository.findById(id);
	}

	public Address updateById(Long id, AddressDTO addressDTO) {
		Address existingAddress = addressJpaRepository.findById(id).orElse(null);
		if (existingAddress != null) {
			addressMapper.updateAddressFromDto(addressDTO, existingAddress);
			return addressJpaRepository.save(existingAddress);
		}
		return existingAddress;
	}

	public void deleteById(Long id) {
		addressJpaRepository.deleteById(id);
	}
}
