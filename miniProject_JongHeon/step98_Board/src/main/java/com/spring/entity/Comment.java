package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.CommentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_no")
	private Long commentNo;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "board_no")
	private Board board;

	@Column(name = "commenter")
	private String commenter;

	@Column(name = "comment_content")
	private String commentContent;

	@CreatedDate
	@Column(name = "registered_date")
	private LocalDateTime registeredDate;

	@LastModifiedDate
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;

	public CommentDTO toDTO(Comment comment) {
		CommentDTO commentDTO = CommentDTO.builder().commentNo(comment.getCommentNo()).board(comment.getBoard())
				.commenter(comment.getCommenter()).commentContent(comment.getCommentContent())
				.registeredDate(comment.getRegisteredDate()).modifiedDate(comment.getModifiedDate()).build();
		return commentDTO;
	}
}
