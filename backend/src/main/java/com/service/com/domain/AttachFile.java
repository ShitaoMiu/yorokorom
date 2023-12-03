package com.service.com.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "attach_file")

public class AttachFile {

	@Id
	@Column(name = "attach_file_id")
	private String attachFileId;

	@Column(name = "file_order")
	private int fileOrder;

	@Column(name = "origin_file_nm")
	private String originFileNm;

	@Column(name = "store_file_nm")
	private String storeFileNm;

	@Column(name = "store_file_path")
	private String storeFilePath;

	@Column(name = "file_ext")
	private String fileExt;

	@Column(name = "file_content")
	private String fileContent;

	@Column(name = "file_size")
	private int fileSize;

	@Column(name = "reg_id")
	private String regId;

	@Column(name = "reg_date")
	private Date regDate;

	@Column(name = "mod_id")
	private String modId;

	@Column(name = "mod_date")
	private Date modDate;

}
