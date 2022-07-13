package com.spring.dto;

import java.time.LocalDateTime;

import com.spring.entity.Board;
import com.spring.entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDTO {

	private Long commentNo;

	private Board board;

	private String commenter;

	private String commentContent;

	private LocalDateTime registeredDate;

	private LocalDateTime modifiedDate;

	public Comment toEntity(CommentDTO commentDTO) {
		Comment comment = Comment.builder().commentNo(commentDTO.getCommentNo()).board(commentDTO.getBoard())
				.commenter(commentDTO.getCommenter()).commentContent(commentDTO.getCommentContent())
				.registeredDate(commentDTO.getRegisteredDate()).modifiedDate(commentDTO.getModifiedDate()).build();
		return comment;
	}
}
