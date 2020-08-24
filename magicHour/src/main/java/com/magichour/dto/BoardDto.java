package com.magichour.dto;

import lombok.Data;

@Data
public class BoardDto {

	private String boardSeq;
	private String boardSubject;
	private String boardContent;
	private String boardDate;
	private String boardWriter;
}
