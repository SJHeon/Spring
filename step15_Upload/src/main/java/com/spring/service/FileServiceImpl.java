package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
	private final FileRepository fileRepository;

	@Override
	public Long saveFile(FileDTO fileDTO) {
		FileEntity fileEntity = fileDTO.toEntity(fileDTO);
		return fileRepository.save(fileEntity).getId();
	}

}
