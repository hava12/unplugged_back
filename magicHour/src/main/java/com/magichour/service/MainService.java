package com.magichour.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.magichour.mapper.MainMapper;
import com.magichour.util.CommonUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MainService {
	
	private MainMapper mainMapper;
	
	public String mainList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(mainMapper.mainCalendarList());
		map.put("calendarList", mainMapper.mainCalendarList());
		return CommonUtil.mapToSortedJson(map);
	}

}
