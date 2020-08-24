package com.magichour.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.magichour.dto.BoardDto;
import com.magichour.mapper.BoardMapper;
import com.magichour.util.CommonUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardService {

	private BoardMapper boardMapper;
	public String getBoardList(String page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		BoardDto dto = new BoardDto();
		map.put("boardList", boardMapper.getBoardList(dto));
		return CommonUtil.mapToSortedJson(map);
				
	}
}
