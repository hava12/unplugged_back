package com.magichour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.magichour.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	public List<BoardDto> getBoardList(BoardDto dto) throws Exception;
}
