package com.kr.pv.vo;

import lombok.Data;

@Data
public class Pv_fileVO {
	private int pv_file_idx;
	private int pv_board_idx;
	private String originalfilename;
	private String savefilename;	
}
