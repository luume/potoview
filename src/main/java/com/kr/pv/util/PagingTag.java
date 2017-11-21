package com.kr.pv.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.kr.pv.vo.BoardFileJoinVO;

public class PagingTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5684951595902431402L;

	int endPage;
	int startPage;
	PageList<BoardFileJoinVO> pageList;

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setPageList(PageList<BoardFileJoinVO> pageList) {
		this.pageList = pageList;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub

		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		try {
			StringBuffer sb = new StringBuffer();
			//out.println(sb.toString());
			sb.append("<div class=\"pagination\">");
			sb.append(pageList.getPageList());
			sb.append("</div>");
			sb.append("<br>");
/*			sb.append("<div>");			
			sb.append("<select>");
			
			
			sb.append("<option value='0'>제목&");				
			sb.append("</option>");
			sb.append("<option value='0'>이름");				
			sb.append("</option>");
			sb.append("<option value='0'>모두");				
			sb.append("</option>");
			
			sb.append("</select>&nbsp;");
			sb.append("<input type='text' name='searchValue'>");
			sb.append("</div>");
*/			out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
