package com.magichour.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.magichour.dto.UserDto;

@Mapper
public interface LoginMapper {
	public UserDto getUserInfo(UserDto dto);

	public int createUser(UserDto dto);
}
