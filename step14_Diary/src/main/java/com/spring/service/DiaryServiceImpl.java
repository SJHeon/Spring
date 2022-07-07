package com.spring.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드(멤버변수)의 생성자를 자동 생성하는 어노테이션
public class DiaryServiceImpl implements DiaryService { // Impl = 구현체, jpa 명세

//	@Autowired
	private final DiaryRepository diaryRepo;

	@Transactional
	@Override
	public void insertDiary(DiaryDTO diaryDTO) {
		Diary diaryEntity = diaryDTO.toEntity(diaryDTO);

		diaryRepo.save(diaryEntity);
	}

	@Transactional
	@Override
	public void insertDiaryBatch(List<DiaryDTO> diaryDTOList) {

//		List<Diary> diaryEntityList = new ArrayList<Diary>();
		// ver1
//		for (DiaryDTO diaryDTO : diaryDTOList) {
//			diaryEntityList.add(diaryDTO.toEntity(diaryDTO));
//		}

		// ver2
//		diaryDTOList.forEach(diaryDTO -> diaryEntityList.add(diaryDTO.toEntity(diaryDTO)));

		List<Diary> diaryEntityList = diaryDTOList.stream().map(diaryDTO -> diaryDTO.toEntity(diaryDTO))
				.collect(Collectors.toList());
		diaryRepo.saveAll(diaryEntityList);
	}

	public PageResultDTO<DiaryDTO, Diary> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("no").descending());

		Page<Diary> result = diaryRepo.findAll(pageable);

		// entity -> dto
		Function<Diary, DiaryDTO> function = (diaryEntity -> diaryEntity.toDTO(diaryEntity));

		return new PageResultDTO<DiaryDTO, Diary>(result, function);
	}

}
