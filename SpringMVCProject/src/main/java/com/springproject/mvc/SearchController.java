package com.springproject.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.mvc.domain.SearchType;

@Controller
public class SearchController {
	
	//1. 정보 전달할 뷰페이지 정의
	@RequestMapping(value = "/search/search")
	public String searchForm() {
		return "search/form";
	}
	
	//4. 뷰페이지가 하나 더 추가된다면? 
	@RequestMapping("/search/search2")
	public String searchForm2() {
		return "search/form2";
	}
	
	//2. 뷰페이지로 보낼 데이터 1 
	@ModelAttribute("optionList")
	public List<SearchType> getSearchType() {
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "제목"));
		options.add(new SearchType(3, "내용"));
		options.add(new SearchType(4, "제목+내용"));
		
		return options;
	}
	
	//3. 뷰페이지로 보낼 데이터 2 
	@ModelAttribute("popularList")
	public String[] getPopularList() {
		return new String[] {"java", "python", "jsp", "Spring"};
	}
	
	//@ModelAttribute() 어노테이션이 적용된 메서드가 리턴한 객체들은 
	//해당 컨트롤러에서 출력하고 있는 모든 뷰페이지에 공유될 수 있다! 
	
	//만약 DB에서 받아오는 정보들이 변경될때에도 한꺼번에 뷰페이지에 수정된 사항들을 표현할 수 있다. 
	//- ex) 
	//- 인기검색어
	//- 좋아요가 가장 많은 맛집 리스트
	//- 조회수가 가장 많은 게시글의 리스트 
	
	//혹은 한 페이지에 여러개의 리스트를 출력해야할 때 
	//--> 네이버 영화 게시판 같은것 
	
	

}
