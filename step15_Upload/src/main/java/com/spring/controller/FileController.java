package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;
import com.spring.service.FileServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FileController {

	private final FileServiceImpl fileService;
	private final FileRepository filerepo;

	@CrossOrigin(value = "http://localhost:3000")
	@GetMapping("/file-list")
	public List<FileEntity> showFileList() {
		return filerepo.findAll();
	}

//	@GetMapping("/file-download/{id}")
//	public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws FileNotFoundException {
//		FileEntity file = filerepo.findById(id).get();
//		response.setHeader("Content-Disposition", "attachment;filename=\"" + file.getFileName() + "\";");
//		FileInputStream fis = new FileInputStream(file.getFilePath());
//		try {
//			OutputStream os = response.getOutputStream();
//			int readCount = 0;
//			byte[] buffer = new byte[1024];
//			while ((readCount = fis.read(buffer)) != -1) {
//				os.write(buffer, 0, readCount);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	@GetMapping("/file-download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {
		FileEntity fileEntity = filerepo.findById(id).get();

		Path path = Paths.get(fileEntity.getFilePath());
		Resource resource = new InputStreamResource(Files.newInputStream((path)));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment")
				.filename(fileEntity.getOriginalFileName(), StandardCharsets.UTF_8).build());
		headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}

	@PostMapping("/file-save-test")
	public void testFileSave(@RequestParam("file") MultipartFile multiFile) {
		try {
			String originalFileName = multiFile.getOriginalFilename();
			String filename = UUID.randomUUID().toString() + "_" + originalFileName;

			// 파일 저장시 경로 설정
			String filePath = System.getProperty("user.dir") + "\\files";

			// 저장폴더가 존재하지 않을 경우 -> 반드시 생성을 해줘야 함
			if (!new File(filePath).exists()) {
				new File(filePath).mkdir();
			}

			// 저장폴더가 존재하는 경우 -> 파일을 저장해줘야 함
			String finalFilePath = filePath + "\\" + filename;
			multiFile.transferTo(new File(finalFilePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/file-save")
	public ResponseEntity saveFile(@RequestParam("file") MultipartFile multiFile) {
		Long fileID = null;
		try {
			String originalFileName = multiFile.getOriginalFilename();
			String filename = UUID.randomUUID().toString() + "_" + originalFileName;

			// 파일 저장시 경로 설정
			String filePath = System.getProperty("user.dir") + "/files";

			// 저장폴더가 존재하지 않을 경우 -> 반드시 생성을 해줘야 함
			if (!new File(filePath).exists()) {
				new File(filePath).mkdir();
			}

			// 저장폴더가 존재하는 경우 -> 파일을 저장해줘야 함
			String finalFilePath = filePath + "/" + filename;
			multiFile.transferTo(new File(finalFilePath));

			FileDTO fileDTO = FileDTO.builder().originalFileName(originalFileName).fileName(filename)
					.filePath(finalFilePath).build();

			fileID = fileService.saveFile(fileDTO);

			List<FileEntity> result = filerepo.findAll();

			/*
			 * boardDTO, setFileDTO(fileDTO); boardDTO setFileId(fileId);
			 * boardServiceImpl.saveBoard(boardDTO);
			 */

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:3000")).body(fileID);
	}

}