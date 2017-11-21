package com.kr.pv.util;
// 제네릭을 이용하여 어떤 VO던지 리스트 항목에 필요한 정보를 저장할 클래스

import java.util.List;

public class PageList<T> {
	private int totalCount; 	// 전체 개수
	private int totalPage;  	// 전체 페이지수
	private int currentPage; 	// 현재 페이지수
	private int pageSize; 		// 1페이지당 글 수
	private int blockSize; 		// 하단의 리스트 표시 개수
	private int startNo; 		// 시작 글번호
	private int endNo; 			// 끝 글번호
	private int startPage; 		// 시작 페이지 번호
	private int endPage; 		// 끝 페이지 번호
	
	private List<T> list;	// 페이지를 나눌 데이터 리스트!!!

	
	public PageList(int totalCount, int currentPage, int pageSize, int blockSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		
		// 나머지 값들은 계산을 해서 얻는다.
		calc();
	}
	// 나머지 값을 계산해줄 메서드 
	private void calc(){
		// 전체페이지수 = (전체개수-1)/페이지당개수 + 1
		totalPage = (totalCount-1)/pageSize + 1;
		if(currentPage<1 || currentPage>totalPage) currentPage = 1;
		
		// 글 시작번호 = (현재페이지-1)*페이지사이즈 (오라클의 경우는 +1을 해주어야 한다.)
		startNo = (currentPage-1) * pageSize;
		// 글끝번호 = 시작번호 + 페이지사이즈 -1;
		endNo = startNo + pageSize - 1;
		//마지막페이지는 10개일수 없다~~~
		if(endNo>=totalCount) endNo = totalCount - 1; // (오라클의 경우는 -1을 하지 않는다.)
		
		// 시작 페이지 번호 = (현재페이지-1)/블록사이즈 * 블록사이즈  + 1
		startPage = (currentPage-1)/blockSize * blockSize + 1;
		// 끝 페이지 번호
		endPage = startPage + blockSize - 1;
		if(endPage>totalPage) endPage = totalPage;
		
		
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public int getStartNo() {
		return startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	@Override
	public String toString() {
		return "PageList [totalCount=" + totalCount + ", totalPage=" + totalPage + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + ", blockSize=" + blockSize + ", startNo=" + startNo + ", endNo=" + endNo
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", list=" + list + "]";
	}
	
	//=====================================================================================
	// 추가
	public String getPageInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("총 " + totalCount + "개");
		if(totalCount>0) sb.append("(" + currentPage + "/" + totalPage + "Page)");
		return sb.toString();
	}
	public String getPageList(){
		StringBuffer sb = new StringBuffer();
		if(startPage>1)
			sb.append("<a href='?p=" + (startPage-1)  + "&s=" + pageSize + "&=" + blockSize + "'>이전</a> ");

		for(int i=startPage;i<=endPage;i++){
			if(i==currentPage)
				sb.append("<a class='active'>"+i+"</a> ");
			else
				sb.append("<a href='?p=" + i + "&s=" + pageSize + "&=" + blockSize + "'>" + i + "</a> ");
		}
		if(endPage<totalPage)
			sb.append(" <a href='?p=" + (endPage+1)  + "&s=" + pageSize + "&=" + blockSize + "'>다음</a>");
		
		return sb.toString();
	}
	
}
