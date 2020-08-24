package com.magichour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.magichour.dto.CalendarDto;

@Mapper
public interface MainMapper {

	public List<CalendarDto> mainCalendarList() throws Exception;
}
