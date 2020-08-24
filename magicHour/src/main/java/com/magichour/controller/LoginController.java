package com.magichour.controller;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magichour.dto.UserDto;
import com.magichour.service.JwtService;
import com.magichour.service.LoginService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoginController {
	
	private final JwtService jwtService;
	private final LoginService loginService;
	
	@PostMapping("/api/actionLogin")
	public UserDto login(UserDto dto, HttpServletResponse response) throws Exception {
		System.out.println(dto);
		
//		UserDto testDto = new UserDto();
//		testDto.setUserId("hava12");
//		testDto.setUserPassword("@asd159450");
//		testDto.setUserBirth("19921103");
//		testDto.setUserPhone("01055310682");
//		testDto.setUserName("조동엽");
//		testDto.setUserGender("M");
//		loginService.createUser(testDto);
		
		UserDto userDto;
		userDto = loginService.getUserInfo(dto);
		if(userDto != null) {
			response.setHeader("jwt-auth-token", jwtService.create(userDto));
			return userDto;			
		} else {
			return null;
		}
	}

	@PostMapping("/api/validationUserToken")
	public boolean validationUserToken(@RequestParam("token") String token) {
		System.out.println(token);
		return jwtService.checkValid(token);
	}

}
