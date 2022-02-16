package com.blog.sample.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.blog.sample.models.Address;
import com.blog.sample.models.AddressDTO;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateAddressFromDto(AddressDTO dto, @MappingTarget Address entity);
}