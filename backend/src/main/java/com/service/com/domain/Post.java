package com.service.com.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)

public class Post {
	@Id
	@Column(name = "post_id")
	private String postId;

	@Column(name = "post_title")
	private String postTitle;

	@Column(name = "post_content")
	private String postContent;

	@Column(name = "attach_file_id")
	private String attachFileId;

	@Column(name = "post_passwd")
	private String postPasswd;

	@Column(name = "post_parent_id")
	private String postParentId;

	@Column(name = "post_read_cnt")
	private int postReadCnt;

	@Column(name = "reg_date")
	private LocalDateTime regDate;

	@Column(name = "mod_date")
	private LocalDateTime modDate;

	@Column(name = "reg_id")
	private String regId;

	@Column(name = "mod_id")
	private String modId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id", referencedColumnName = "board_id")
	private Board board;
}
