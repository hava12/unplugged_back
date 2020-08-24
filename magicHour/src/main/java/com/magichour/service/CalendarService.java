package com.magichour.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magichour.dto.CalendarDto;
import com.magichour.mapper.CalendarMapper;
import com.magichour.util.CommonUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CalendarService {
	@Autowired
	CalendarMapper calendarMapper;
	
	/**
	 * @param year
	 * @param month
	 * @return
	 */
	@Transactional
	public String calendarList(int year, int month) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Object> calendarList = new ArrayList<Object>();
			String calDate = "";
			LocalDate localDate = LocalDate.of(year, month+1, 1);
			String monthStr = CommonUtil.lpad(month+1, 2, '0');
			map.put("lastDayOfMonth", localDate.lengthOfMonth());
			for(int i = 1 ; i <= localDate.lengthOfMonth(); i ++) {
				if(i == 1) {
					map.put("firstDayOfWeek", localDate.getDayOfWeek().getValue());
				}
				calDate = year + monthStr + CommonUtil.lpad(i, 2, '0');
				calendarList.add(calendarMapper.calendarList(calDate));
			}
			map.put("calendarList", calendarList);
			return CommonUtil.mapToSortedJson(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * calendar Insert
	 * 
	 * @param dto
	 * @throws Exception
	 */
	public void insertCalendar(CalendarDto dto) throws Exception {
		int result = calendarMapper.insertCalendar(dto);
		System.out.println(result);
	}

	public void deleteCalendar(String calSeq) throws Exception{
		int result = calendarMapper.deleteCalendar(calSeq);
		System.out.println(result);
	}
}
