package com.webjjang.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;




/**
 * Servlet implementation class Beans
 */
public class Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 실행해야할 모든 서비스객체를 저장해 놓는 Map
	public static Map<String, ServiceInterface> beans = new HashMap<>();

	// 실행해야할 모든 DAO객체를 저장해 놓는 Map
	public static Map<String, Object> daoBeans = new HashMap<>();

	// 실행할 서비스를 받아가는 메서드
	public static ServiceInterface getService(String uri) {
		return beans.get(uri);
	}
	
	// 실행할 DAO를 받아가는 메서드 
	public static Object getDAO(String uri) {
		return daoBeans.get(uri);
	}
	
	// request받아서 URI를 리턴하는 프로그램 작성
	// 모든 Controller에서는 따로 작성하지 않고 받아가서 처리한다.
	public static String getURI(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.substring(uri.indexOf(request.getServletPath()));
	}

	public static String pre = "/src/";
	public static String suf = ".jsp";
	
	// 정제된 URI 넣으면 foward할 jsp로 만들어주는 메서드
	public static String getJsp(String uri) {
		return pre+uri.substring(6, uri.lastIndexOf("."))+suf;
	}
	
	/**
	 * @see Servlet#init(ServletConfig)
	 * 여기가 제일 먼저 실행이 되서 모든 객체를 생성한다.
	 */
	public void init() throws ServletException {
		
	}

}
