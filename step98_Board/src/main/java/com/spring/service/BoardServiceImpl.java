package com.spring.service;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Board;
import com.spring.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepo;

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		Board boardEntity = boardDTO.toEntity(boardDTO);
		boardRepo.save(boardEntity);
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) {
		// search
		Board board = boardRepo.findBoardByBoardNo(boardDTO.getBoardNo());

		// entity.update(boardDTO.getTitle(), boardDTO.getContent())
		board.updateBoard(boardDTO.getBoardTitle(), boardDTO.getBoardContent());

		// save
		boardRepo.save(board);
	}

	@Override
	public List<Board> getAllBoards() {
		return boardRepo.findAll();
	}

	@Override
	public BoardDTO getBoardByBoardNo(Long boardNo) {
		Board board = boardRepo.findBoardByBoardNo(boardNo);
		BoardDTO boardDTO = board.toDTO(board);
		return boardDTO;
	}

	@Override
	public void deleteBoardByBoardNo(Long boardNo) {
		boardRepo.deleteById(boardNo);
	}

	@Override
	public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("boardNo").descending());

		Page<Board> result = boardRepo.findAll(pageable);

		Function<Board, BoardDTO> function = (boardEntity -> boardEntity.toDTO(boardEntity));

		return new PageResultDTO<BoardDTO, Board>(result, function);
	}

}
