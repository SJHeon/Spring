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

import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Board;
import com.spring.service.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {
	private final BoardServiceImpl boardService;

//	CREATE ----------------------------
	@PostMapping(value = "/board", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertBoard(@RequestBody BoardDTO boardDTO) {
		boardDTO.setUser(boardDTO.getUser());
		boardDTO.setBoardTitle(boardDTO.getBoardTitle());
		boardDTO.setBoardContent(boardDTO.getBoardContent());

		boardService.insertBoard(boardDTO);
	}

//	READ   ---------------------------- 의미 없다고 보여진다
	@GetMapping(value = "/boards1")
	public List<Board> getAllBoards() {
		return boardService.getAllBoards();
	}

	@GetMapping(value = "/board/{boardNo}")
	public BoardDTO getBoardByBoardNo(@PathVariable("boardNo") Long boardNo) {
		return boardService.getBoardByBoardNo(boardNo);
	}

//	PAGING ----------------------------
	@GetMapping(value = "/boards")
	public PageResultDTO<BoardDTO, Board> getAllBoards(PageRequestDTO pageRequestDTO) {
		PageResultDTO<BoardDTO, Board> pageResultDTO = boardService.getList(pageRequestDTO);
//		List<BoardDTO> resultBoardDTOs = new ArrayList<BoardDTO>();
//		pageResultDTO.getDtoList().forEach(boardDTO -> resultBoardDTOs.add(boardDTO)); -> 의미가 없다
		return pageResultDTO;
	}

//	UPDATE ----------------------------
	@PutMapping(value = "/board/{boardNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateBoardByBoardNo(@PathVariable("boardNo") Long boardNo, @RequestBody BoardDTO boardDTO) {
		if (boardService.getBoardByBoardNo(boardNo) != null) {
			boardDTO.setBoardNo(boardNo);
			boardService.updateBoard(boardDTO);
		} else {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ NOT EXIST @@@@@@@@@@@@@@@@@@@@@@@@");
		}

	}

//	DELETE ----------------------------
	@DeleteMapping(value = "/board/{boardNo}")
	public void deleteBoardByBoardNo(@PathVariable("boardNo") Long boardNo) {
		boardService.deleteBoardByBoardNo(boardNo);
	}

}
