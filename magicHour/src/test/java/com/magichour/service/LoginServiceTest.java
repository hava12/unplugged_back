package com.magichour.service;

import org.junit.jupiter.api.Test;

import com.magichour.dto.UserDto;
import com.magichour.mapper.LoginMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class LoginServiceTest {

	private final LoginService loginService;
	
	@Test
	public void createUserTest () {
		
		System.out.println("11111111111111");
		UserDto dto = new UserDto();
		dto.setUserId("hava12");
		dto.setUserPassword("@asd159450");
		dto.setUserBirth("19921103");
		dto.setUserPhone("01055310682");
		dto.setUserName("조동엽");
		dto.setUserGender("M");

		System.out.println("2222222222222222");
		System.out.println(loginService.createUser(dto));
		
	}
}
