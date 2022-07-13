package com.spring.service;

import java.util.List;

import com.spring.dto.CommentDTO;
import com.spring.entity.Comment;

public interface CommentService {
	public List<Comment> getAllComments();

	public CommentDTO getCommentByCommentNo(Long commentNo);

	public List<CommentDTO> getCommentsByBoardNo(Long boardNo);

	public void insertComment(CommentDTO commentDTO);

	public void deleteCommentByCommentNo(Long commentNo);

}
