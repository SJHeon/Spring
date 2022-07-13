package com.spring.dto;

import java.time.LocalDateTime;

import com.spring.entity.Board;
import com.spring.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDTO {

	private Long boardNo;
//	@Column(updatable = false)
	private User user;

	private String boardTitle;

	private String boardContent;

	private LocalDateTime registeredDate;

	private LocalDateTime modifiedDate;

	public Board toEntity(BoardDTO boardDTO) {
		Board board = Board.builder().boardNo(boardDTO.getBoardNo()).user(boardDTO.getUser())
				.boardTitle(boardDTO.getBoardTitle()).boardContent(boardDTO.getBoardContent())
				.registeredDate(boardDTO.getRegisteredDate()).modifiedDate(boardDTO.getModifiedDate()).build();

		return board;
	}
}
