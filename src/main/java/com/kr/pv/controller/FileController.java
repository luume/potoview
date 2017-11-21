package com.kr.pv.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.kr.pv.service.SelectServiceImpl;
import com.kr.pv.service.UploadServiceImpl;
import com.kr.pv.util.PageList;
import com.kr.pv.util.Util;
import com.kr.pv.vo.BoardFileJoinVO;
import com.kr.pv.vo.FileBean;
import com.kr.pv.vo.Pv_boardVO;
import com.kr.pv.vo.Pv_fileVO;

@Controller
public class FileController implements ApplicationContextAware {

	// 컨텍스트 변수 선언
	private WebApplicationContext context = null;
	
	@Autowired
	UploadServiceImpl uploadServiceImpl;
	@Autowired
	SelectServiceImpl selectServiceImpl;
	
	Pv_fileVO dataset_vo;
	

	
	@RequestMapping(value="/index")
	public String index(Model model, HttpSession httpSession,
			@RequestParam(value="showImg", required=false, defaultValue="0") int showImg) {
		//model.addAttribute("showImg","0");
		List<BoardFileJoinVO> list = uploadServiceImpl.selectTitleList();
		System.out.println("리스트 사이즈 :" +list.size());
		model.addAttribute("imgList",list);
		if(showImg==1)
			httpSession.setAttribute("showImg", "1");
		else if(showImg==0)
			httpSession.setAttribute("showImg", "0");
		return "theme/body";
	}
	
	
	
	@ModelAttribute("singletonFileVo")
	public  Pv_fileVO dataset() {
		System.out.println("모델어트리부트");
		return dataset_vo;
	}	
	
	
	@RequestMapping(value="/boardList", method = RequestMethod.GET)
	public String selectBoardList(
			Model model,
			@RequestParam(value="s", defaultValue="5", required=false) int pageSize,
			@RequestParam(value="b", defaultValue="10", required=false) int blockSize,
			@RequestParam(value="p", defaultValue="1", required=false) int currentPage) {				
		
		PageList<BoardFileJoinVO> pageList = selectServiceImpl.selectList(currentPage, pageSize, blockSize);
		model.addAttribute("pageList",pageList);
		return "board/boardList";
	}
	

	@RequestMapping(value = "/uploadFile")
	public String uploadFile(HttpServletRequest request, Model model, FileBean fileBean) {
		String result = "";
		if (!fileBean.getUpload().isEmpty()) {
			String fName = request.getSession().getServletContext().getRealPath("/resources/file/");
			System.out.println(fName + fileBean.getUpload().getOriginalFilename());
			String saveName = "";
			try {
				saveName = Util.uploadFile(fName, fileBean.getUpload().getOriginalFilename(), fileBean.getUpload().getBytes());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			model.addAttribute("result",
					"../resources" + File.separator + "file" + File.separator + fileBean.getUpload().getOriginalFilename());
			result = "resources/file/" + saveName;
			System.out.println(saveName);
			model.addAttribute("sName", saveName);
			Pv_fileVO fileVo = new Pv_fileVO();			
			fileVo.setOriginalfilename(fileBean.getUpload().getOriginalFilename());
			fileVo.setSavefilename(saveName);
			System.out.println("미리보기 : " + fileVo.getOriginalfilename());
			dataset_vo = new Pv_fileVO();
			dataset_vo.setOriginalfilename(fileBean.getUpload().getOriginalFilename());
			dataset_vo.setSavefilename(saveName);
			dataset();
		}

		String funcNum = request.getParameter("CKEditorFuncNum");
		String urls = "<script>window.parent.CKEDITOR.tools.callFunction('" + funcNum + "', '" + result + "','hi')</script>";
		model.addAttribute("url",urls);
				
		
		return "upload/uploadForm";
	}
	
	
	@RequestMapping(value="/uploadOk", method=RequestMethod.POST)
	public String uploadOk(HttpServletRequest request, Model model, @ModelAttribute("singletonFileVo") Pv_fileVO fVo,
			MultipartFile multipartfile,FileBean fileBean) {
		String edit = request.getParameter("editor1");
		System.out.println(edit);
		model.addAttribute("edit",edit);
		
		Pv_boardVO boardVo = new Pv_boardVO();
		boardVo.setContent(request.getParameter("editor1"));
		boardVo.setTitle(request.getParameter("title"));
		//Pv_fileVO fileVo = new Pv_fileVO();
	/*	String fName = request.getSession().getServletContext().getRealPath("/resources/file/");
		String saveName = "";
		try {
			saveName = Util.uploadFile(fName, multipartfile.getOriginalFilename(), multipartfile.getBytes());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		//fileVo.setOriginalfilename(multipartfile.getOriginalFilename());
		//fileVo.setSavefilename(saveName);
		System.out.println("여기옴?");
		System.out.println("값확인 : " + boardVo.getContent());		
		uploadServiceImpl.insert(boardVo, fVo);
		
		return "redirect:/index";
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		this.context = (WebApplicationContext) arg0;
	}

}
