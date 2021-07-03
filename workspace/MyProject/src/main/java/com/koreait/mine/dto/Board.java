package com.koreait.mine.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {

	private long no;
	private String writer;
	private String title;
	private String content;
	private int hit;
	private String ip;
	private String filename;
	private Date postdate;
	private Date lastmodified;
	
}