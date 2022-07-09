package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.dto.FileDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file")
public class FileEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String originalFileName;

	private String fileName;

	private String filePath;

	public FileDTO toFileDTo(FileEntity fileEntity) {
		FileDTO fileDTO = FileDTO.builder().originalFileName(fileEntity.getOriginalFileName())
				.fileName(fileEntity.getFileName()).filePath(fileEntity.getFilePath()).build();
		return fileDTO;
	}
//	@LastModifiedDate
//	private LocalDateTime modifiDate;
}
