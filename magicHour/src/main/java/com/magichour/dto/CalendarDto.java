package com.magichour.dto;


import lombok.Data;

@Data
public class CalendarDto {
	private Long calSeq;

	private String calDate;
	private String calTime;
	private String calMinute;
	private String calSubject;
	private String calContent;
	private String calWriter;	
	private String calCreateDate;
}
