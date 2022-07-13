package com.spring.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.dto.UserDTO;
import com.spring.entity.User;
import com.spring.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
	private final UserServiceImpl userService;

//	CREATE ----------------------------
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertUser(@RequestBody UserDTO user) {
		user.setUserEmail(user.getUserEmail());
		user.setUserName(user.getUserName());
		user.setUserPassword(user.getUserPassword());
		userService.insertUser(user);
	}

//	READ   ----------------------------
	@GetMapping(value = "/users1")
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}

//	PAGING ---------------------------- 의미 없다고 보여진다(유저 정보를 모두 볼 필요는 없으니)
	@GetMapping(value = "/users")
	public PageResultDTO<UserDTO, User> getAllUsers(PageRequestDTO pageRequestDTO) {
		PageResultDTO<UserDTO, User> pageResultDTO = userService.getList(pageRequestDTO);
		userService.getList(pageRequestDTO).getDtoList().forEach(userDTO -> System.out.println(userDTO));
		return pageResultDTO;
	}

////	UPDATE ----------------------------
//	@PutMapping(value = "/user/{userName}")
//	public void updateUserByUserEmail(@PathVariable("userName") String userName) {
//		System.out.println(userName);
//	}
//
////	DELETE ----------------------------
//	@DeleteMapping(value = "/user/{userEmail}")
//	public void deleteUserByUserEmail(@PathVariable("userEamil") String userEmail) {
//		System.out.println(userEmail);
//	}

}
