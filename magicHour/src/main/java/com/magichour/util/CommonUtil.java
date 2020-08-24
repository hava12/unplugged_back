package com.magichour.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.magichour.dto.CalendarDto;

public class CommonUtil {
	/**

	 * left padding

	 * 원본 문자열이 null 일 경우 null 반환

	 * 원본 문자열 길이가 총 길이보다 길 경우 원본 문자열 반환

	 * 

	 * @param srcString 원본 문자열
	 * @param length padding 된 총 길이
	 * @param padChar padding 문자
	 * @return
	 */
	public static String lpad(Object srcObject, int length, char padChar){
		try{
			String srcString = srcObject.toString();
			StringBuffer sb = new StringBuffer();
			if(length - srcString.length() > 0) {
				sb.append("%-");
				sb.append(length - srcString.length());
				sb.append("s");				
			}
			return String.format( sb.toString(), "" ).replaceAll("\\s", String.valueOf(padChar)).concat(srcString);
		} catch (Exception e){
			return "";
		}
	}
	
	/**
	* right padding
	* 원본 문자열이 null 일 경우 null 반환
	* 원본 문자열 길이가 총 길이보다 길 경우 원본 문자열 반환
	* @param srcString 원본 문자열
	* @param length padding 된 총 길이
	* @param padChar padding 문자
	* @return
	*/
	public static String rpad(Object srcObject, int length, char padChar){
		try{
			String srcString = srcObject.toString();
			StringBuffer sb = new StringBuffer();
			if(length - srcString.length() > 0) {
				sb.append("%-");
				sb.append(length - srcString.length());
				sb.append("s");
			}
			return srcString.concat(String.format( sb.toString(), "" ).replaceAll("\\s", String.valueOf(padChar)));
		} catch (Exception e){
			return "";
		}

	}

	public static String mapToSortedJson(Map<String, Object> map) {
		try {
			ObjectMapper om = new ObjectMapper();
			om.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
			String jsonString = om.writeValueAsString(map);
			return jsonString;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public static String getSha256(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes());
		return byteToHex(md.digest());
	}
	
	public static String byteToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for(byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
}
