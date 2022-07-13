package com.spring.dto;

import java.time.LocalDateTime;

import com.spring.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserDTO {

	private String userEmail;

	private String userName;

	private String userPassword;

	private LocalDateTime registeredDate;

	private LocalDateTime modifiedDate;

	public User toEntity(UserDTO userDTO) {
		User userEntity = User.builder().userEmail(userDTO.getUserEmail()).userName(userDTO.getUserName())
				.userPassword(userDTO.getUserPassword()).registeredDate(userDTO.getRegisteredDate())
				.modifiedDate(userDTO.getModifiedDate()).build();
		return userEntity;
	}
}
