package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepository;
import com.spring.service.DiaryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드(멤버변수)의 생성자를 자동 생성하는 어노테이션
public class DiaryController {
//	@Autowired // 필드주입
	private final DiaryServiceImpl diaryServiceImpl;

	@Autowired
	DiaryRepository diaryRepository;

	@PostMapping("/diary")
	public void insertDiary(@RequestBody DiaryDTO diaryDTO) {
		diaryServiceImpl.insertDiary(diaryDTO);
	}

	@PostMapping("/diary-batch")
	public void insertDiaryBatch() {

//		IntStream.rangeClosed(1, 200).forEach(i -> {
//			DiaryDTO diaryDTO = DiaryDTO.builder().no(Long.valueOf(i)).title("Title : " + i).content("Content : " + i)
//					.build();
//			diaryServiceImpl.insertDiary(diaryDTO);

		List<DiaryDTO> diaryDTOList = new ArrayList<DiaryDTO>();
		IntStream.rangeClosed(1, 200).forEach(i -> {
			diaryDTOList.add(
					DiaryDTO.builder().no(Long.valueOf(i)).title("Title : " + i).content("Content : " + i).build());
		});
		diaryServiceImpl.insertDiaryBatch(diaryDTOList);
	}

	// 페이지 처리
	// Pageable 인터페이스
	// Pageable pageable = new PageRequest(); x
	// 내부 static of 메소드를 사용 가
	// of(int page, int size) : 페이지 번호(0부터 시작), 개수
	// of(int page, int size, Sort sort) : 페이지 번호, 개수, 정렬

	@GetMapping("/pageable")
	public void pageDefault() {
		Pageable pageable1 = PageRequest.of(10, 10);
		Page<Diary> result = diaryRepository.findAll(pageable1);
		System.out.println("--------------- pageable result -----------------");
		System.out.println(result);

		System.out.println("-----------------전체 페이지----------------");
		System.out.println(result.getTotalPages());

		System.out.println("-----------------전체 개수----------------");
		System.out.println(result.getNumberOfElements());

		System.out.println("-----------------현재 페이지 번호 : 0부터 시작----------------");
		System.out.println(result.getNumber());

		System.out.println("-----------------페이지당 데이터 개수----------------");
		System.out.println(result.getSize());

		System.out.println("-----------------다음 페이지----------------");
		System.out.println(result.hasNext());

		System.out.println("-----------------이전 페이지----------------");
		System.out.println(result.hasPrevious());

		System.out.println("-----------------모든 데이터----------------");
		System.out.println(result.getContent());

		System.out.println("-----------------정렬----------------");
		Sort sort1 = Sort.by("no").descending();
		Pageable pageable2 = PageRequest.of(0, 10, sort1);
		Page<Diary> result2 = diaryRepository.findAll(pageable2);

		result2.forEach(diary -> {
			System.out.println(diary);
		});

		System.out.println("=====쿼리메소드 + Pageable=====");
		// 쿼리메소드 + Pageable
		Pageable pageable3 = PageRequest.of(0, 10, Sort.by("no").descending());
		Page<Diary> result3 = diaryRepository.findByNoBetween(10L, 50L, pageable3);

		result3.get().forEach(diary -> System.out.println(diary));

		// 고려 사항
		// Entity -> DTO
		// DTO -> Pageable
		// 페이지 번호

		System.out.println("=====PageRequestDTO=====");
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

		PageResultDTO<DiaryDTO, Diary> pageResultDTO = diaryServiceImpl.getList(pageRequestDTO);

		System.out.println(pageResultDTO.isPrev());
		System.out.println(pageResultDTO.isNext());
		System.out.println(pageResultDTO.getTotalPage());

		System.out.println("=====PageRequestDTO 객체값 출력(1번 페이지에 있는 내용만)=====");
		// ??
		pageResultDTO.getDtoList().forEach(diaryDTO -> System.out.println(diaryDTO));

	}

	@GetMapping("/diary")
	public void getDiary(PageRequestDTO pageRequestDTO) {
		PageResultDTO<DiaryDTO, Diary> pageResultDTO = diaryServiceImpl.getList(pageRequestDTO);

		System.out.println(pageRequestDTO);
		System.out.println("--------@@@@@@@@@@----------");
		System.out.println(diaryServiceImpl.getList(pageRequestDTO));
		System.out.println("@@@@@------------------@@@@@");
		diaryServiceImpl.getList(pageRequestDTO).getDtoList().forEach(diaryDTO -> System.out.println(diaryDTO));
		System.out.println("--------@@@@@@@@@@----------");
		System.out.println(pageResultDTO.getPageList());
	}

}
