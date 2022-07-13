package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.dto.CommentDTO;
import com.spring.entity.Comment;
import com.spring.repository.BoardRepository;
import com.spring.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentRepository commRepo;
	private final BoardRepository boardRepo;

	@Transactional
	@Override
	public void insertComment(CommentDTO commentDTO) {
		Comment commentEntity = commentDTO.toEntity(commentDTO);
		commRepo.save(commentEntity);
	}

	@Transactional
	@Override
	public List<Comment> getAllComments() {
		return commRepo.findAll();
	}

	@Transactional
	@Override
	public CommentDTO getCommentByCommentNo(Long commentNo) {
		Comment comment = commRepo.findCommentByCommentNo(commentNo);
		CommentDTO commentDTO = comment.toDTO(comment);
		return commentDTO;
	}

	@Transactional
	@Override
	public void deleteCommentByCommentNo(Long commentNo) {
		commRepo.deleteById(commentNo);
	}

	@Transactional
	@Override
	public List<CommentDTO> getCommentsByBoardNo(Long boardNo) {
		List<Comment> commentList = commRepo.findCommentByBoardBoardNo(boardNo);
		System.out.println(commentList);
		List<CommentDTO> commentDTOList = new ArrayList<CommentDTO>();
		for (Comment comment : commentList) {
			commentDTOList.add(comment.toDTO(comment));
		}
		return commentDTOList;
	}

}
