package com.spring.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.CommentDTO;
import com.spring.entity.Comment;
import com.spring.service.CommentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
	private final CommentServiceImpl commentService;

//	CREATE ----------------------------
	@PostMapping(value = "/comment", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertComment(@RequestBody CommentDTO commentDTO) {
		commentDTO.setCommentNo(commentDTO.getCommentNo());
		commentDTO.setBoard(commentDTO.getBoard());
		commentDTO.setCommenter(commentDTO.getCommenter());
		commentDTO.setCommentContent(commentDTO.getCommentContent());

		commentService.insertComment(commentDTO);
	}

//	READ   ---------------------------- 기능 쓸거면 DTO로 변경하기
	@GetMapping(value = "/comments1")
	public List<Comment> getAllComments() {
		return commentService.getAllComments();
	}

//	PAGING ---------------------------- 댓글 페이징은 욕심
//	@GetMapping(value = "/comments")
//	public PageResultDTO<CommentDTO, Comment> getAllComments(PageRequestDTO pageRequestDTO){
//		PageResultDTO<CommentDTO, Comment> pageResultDTO = commentService.getList(pageRequestDTO);
//	}

	@GetMapping(value = "/comment/{boardNo}") // boardNo기준으로 가져와야한다
	public List<CommentDTO> getCommentsByBoardNo(@PathVariable("boardNo") Long boardNo) throws Exception {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setBoardNo(boardNo);
//		throw new Exception("ERROR");
		return commentService.getCommentsByBoardNo(boardNo);
//		return commentService.getCommentByBoard(boardDTO);
	}

//	UPDATE ----------------------------
	@PutMapping(value = "/comment/{commentNo}")
	public void updateCommentByCommentNo(@PathVariable("commentNo") Long commentNo,
			@RequestBody CommentDTO commentDTO) {
		System.out.println("-----------------------------------------------------------");
		System.out.println(commentDTO);
		System.out.println("-----------------------------------------------------------");
		if (commentService.getCommentByCommentNo(commentNo) != null) {
			commentDTO.setCommentNo(commentNo);
			commentService.insertComment(commentDTO);
		} else {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("없는 댓글 번호");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		}
	}

//	DELETE ----------------------------
	@DeleteMapping(value = "/comment/{commentNo}")
	public void deleteCommentByCommentNo(@PathVariable("commentNo") Long commentNo) {
		commentService.deleteCommentByCommentNo(commentNo);
	}

}
