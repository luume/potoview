package com.kr.pv.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Pv_boardVO {
	private int pv_board_idx;
	private String content;
	private String title;
	private Date regDate;
}
