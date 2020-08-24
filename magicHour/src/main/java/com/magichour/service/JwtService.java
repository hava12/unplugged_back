package com.magichour.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.magichour.dto.UserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {

//	@Value("${jwt.salt}")
	private String salt = "salt";
//	@Value("${jwt.expMin}")
	private int expireMin = 5;
	
	/**
	 * 로그인 성공 시 사용자 정보를 기반으로 JWTToken을 생성해서 반환한다.
	 * 
	 * @param dto
	 * @return
	 */
	public String create(final UserDto dto) {
		final JwtBuilder builder = Jwts.builder();
		
		//Jwt Token = header + payload + signature 
		//Header 설정 
		builder.setHeaderParam("typ", "JWT"); // 토큰의 타입으로 고정값
		
		//PayLoad 설정 - claim 정보 포함
		builder.setSubject("loginToken")
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin))//유효기간
				.claim("User", dto); // 담고 싶은 정보 설정
		
		// signature - secret key 를 이용한 암호화
		builder.signWith(SignatureAlgorithm.HS256, salt.getBytes());
		
		//마지막 직렬화 처리
		final String jwt = builder.compact();
		return jwt;
	}

	/**
	 * 전달받은 토큰이 제대로 생성되었는지 확인하고 문제가 있다면 Runtime 에러 발생
	 * @param jwt
	 */
	public boolean checkValid(final String jwt) {
		try {
			Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Map<String, Object> get(final String jwt) {
		Jws<Claims> claims = null;
		
		claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
		
		return claims.getBody();
	}
}
