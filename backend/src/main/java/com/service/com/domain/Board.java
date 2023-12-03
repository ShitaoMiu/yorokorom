package com.service.com.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Board {
	@Id
	@Column(name = "board_id")
	private String boardId;

	@Column(name = "board_name")
	private String boardName;

	@Enumerated(EnumType.STRING)
	private BoardType boardType;

	@Column(name = "board_use_yn")
	private char boardUseYn;

	@Column(name = "attatch_file_yn")
	private char attatchFileYn;

	@Column(name = "attach_file_num")
	private int attachFileNum;

	@Column(name = "reply_post_yn")
	private char replyPostYn;

	@Column(name = "post_passwd_yn")
	private char postPasswdYn;

	@Column(name = "board_editor_yn")
	private char boardEditorYn;

	@Column(name = "reg_date")
	private Date regDate;

	@Column(name = "mod_date")
	private Date modDate;

	@Column(name = "reg_id")
	private String regId;

	@Column(name = "mod_id")
	private String modId;
	@JsonIgnore
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<Post>();

}
