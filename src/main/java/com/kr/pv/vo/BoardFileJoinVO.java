package com.kr.pv.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardFileJoinVO {
	private int pv_board_idx;
	private String content;
	private String title;
	private Date regDate;
	private String savefilename;
}
