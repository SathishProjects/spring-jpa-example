package com.blog.sample.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.blog.sample.models.User;
import com.blog.sample.models.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateCustomerFromDto(UserDTO dto, @MappingTarget User entity);
}