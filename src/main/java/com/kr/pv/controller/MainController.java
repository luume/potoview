package com.kr.pv.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kr.pv.service.SelectServiceImpl;
import com.kr.pv.vo.BoardFileJoinVO;

@Controller
public class MainController {
	
	@Autowired
	SelectServiceImpl selectServiceImpl;
	
	@RequestMapping(value="/getPv", method=RequestMethod.GET)
	public String getPv(Model model) {
		//model.addAttribute("showImg","0");
		return "theme/body";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request) {		
		return "login/login";
	}
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model) {
		//model.addAttribute("showImg","1");
		return "theme/body";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("showImg", 0);
		return "login/login";
	}
	
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.GET)
	public String uploadForm(HttpServletRequest request, Model model) {		
		return "upload/uploadForm";
	}
	
	
	@RequestMapping(value="/selectByIdx", method=RequestMethod.GET)
	public String selectByIdx(@RequestParam(value="idx") int idx, Model model) {
		BoardFileJoinVO vo = selectServiceImpl.selectByIdx(idx);
		model.addAttribute("vo", vo);
		return "upload/result";
	}
	
	@RequestMapping(value="/404error")
	public String error404(HttpServletRequest request, Model model) {
		
		return "error/404error";
	}
	
}
