package com.magichour.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magichour.dto.CalendarDto;
import com.magichour.service.CalendarService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CalendarController {

	private CalendarService calendarService;
	
	/**
	 * 달력 리스트를 불러오는 메소드
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	@GetMapping("/api/calendarList/{year}/{month}")
	public String calendarList(@PathVariable("year") int year, @PathVariable("month") int month){
		
		String jsonString  = calendarService.calendarList(year, month);
		return jsonString;
	}
	
	/**
	 * 달력 리스트를 추가하는 메소드
	 * 
	 * @param dto
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/api/insertCalendar")
	public String insertCalendar(CalendarDto dto ,HttpServletRequest request) throws Exception {
		System.out.println(dto);
		calendarService.insertCalendar(dto);
		return "success";
	}

	@DeleteMapping("/api/deleteCalendar/{calSeq}")
	public String deleeteCalendar(@PathVariable("calSeq") String calSeq) throws Exception {
		System.out.println(calSeq);
		calendarService.deleteCalendar(calSeq);
		return "success";
	}
}

