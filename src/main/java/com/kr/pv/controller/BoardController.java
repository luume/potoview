package com.kr.pv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kr.pv.service.BoardServiceImpl;

@Controller
public class BoardController {
	
	@Autowired
	BoardServiceImpl boardServiceImpl;
	
	@RequestMapping(value="/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		boardServiceImpl.deleteBoardFile(idx);				
		return "redirect:/boardList";
	}
}
