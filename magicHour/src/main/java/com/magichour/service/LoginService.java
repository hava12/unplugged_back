package com.magichour.service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;
import com.magichour.dto.UserDto;
import com.magichour.mapper.LoginMapper;
import com.magichour.util.CommonUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {
	
	private final LoginMapper loginMapper;
	
	/**
	 * user 정보를 얻어오는 메소드
	 * 
	 * @param dto
	 * @return
	 */
	public UserDto getUserInfo(UserDto dto) {
		UserDto resultDto;
		try {
			dto.setUserPassword(CommonUtil.getSha256(dto.getUserPassword()));
			resultDto = loginMapper.getUserInfo(dto);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("암호화 실패 : " + dto);
			e.printStackTrace();
			return null;
		}
		return resultDto;
	}
	
	/**
	 * @param dto
	 * @return
	 */
	public int createUser(UserDto dto) {
		System.out.println(dto);
		int resultCnt = 0;
		try {
			System.out.println(CommonUtil.getSha256(dto.getUserPassword()));
			dto.setUserPassword(CommonUtil.getSha256(dto.getUserPassword()));
			resultCnt = loginMapper.createUser(dto);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("암호화 실패 : " + dto);
			e.printStackTrace();
			return 0;
		}
		return resultCnt;
	}
}
