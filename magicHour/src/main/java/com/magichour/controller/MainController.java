package com.magichour.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.magichour.service.MainService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MainController {
	
	public MainService mainService;
	
	@GetMapping("/api/main/mainList/{year}/{month}")
	public String mainCalendarList(@PathVariable("year") String year, @PathVariable("month") String month) throws Exception {
		System.out.println(year);
		System.out.println(month);
		
		return mainService.mainList();
	}
	
}
