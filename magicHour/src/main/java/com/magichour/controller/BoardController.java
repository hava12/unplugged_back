package com.magichour.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.magichour.service.BoardService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;
	
	@GetMapping("/api/board/list/{page}")
	public String boardList(@PathVariable("page") String page) throws Exception {
		return boardService.getBoardList(page);
	}
}
