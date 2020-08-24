package com.magichour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.magichour.dto.CalendarDto;

@Mapper
public interface CalendarMapper {
	
	public List<CalendarDto> calendarList(String calDate) throws Exception;

	public int insertCalendar(CalendarDto dto) throws Exception;

	public int deleteCalendar(String calSeq) throws Exception;
}
