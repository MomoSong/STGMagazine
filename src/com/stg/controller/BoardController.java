package com.stg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stg.crawler.DanswerBestCrawler;
import com.stg.crawler.DanswerNewCrawler;
import com.stg.crawler.RedHommeBestCrawler;
import com.stg.crawler.RedHommeNewCrawler;
import com.stg.crawler.drugHommeBestCrawler;
import com.stg.crawler.drugHommeNewCrawler;
import com.stg.crawler.elhommeBestCrawler;
import com.stg.crawler.elhommeNewCrawler;
import com.stg.crawler.enuffBestCrawler;
import com.stg.crawler.enuffNewCrawler;
import com.stg.crawler.locobasicBestCrawler;
import com.stg.crawler.lookpineBestCrawler;
import com.stg.crawler.lookpineNewCrawler;
import com.stg.crawler.modernifNewCrawler;
import com.stg.crawler.showpinBestCrawler;
import com.stg.crawler.showpinNewCrawler;
import com.webjjang.util.Beans;
import com.webjjang.util.ServiceInterface;

/**
 * Servlet implementation class BoardController
 */
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getClass().getName()+".doGet()");
		String command = Beans.getURI(request);
		// 기본으로는 forward 시킨 jsp 파일명을 저장한다. 앞에 redirect:이라고 붙이면 redirect 시킨 uri를 저장한다.
		String jsp = "";
		
		System.out.println(command);
		try {
			switch (command) {
			case "/views/main.do":
				ServiceInterface redhommeBest = new RedHommeBestCrawler();
				
				
				request.setAttribute("redHommeBest", redhommeBest.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/redHommeNew.do":
				ServiceInterface redhommeNew = new RedHommeNewCrawler();
				
				
				request.setAttribute("redHommeNew", redhommeNew.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
			
			case "/views/dAnswerBest.do":
				ServiceInterface dAnswerBest = new DanswerBestCrawler();
				
				
				request.setAttribute("dAnswerBest", dAnswerBest.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/dAnswerNew.do":
				ServiceInterface dAnswerNew = new DanswerNewCrawler();
				
				
				request.setAttribute("dAnswerNew", dAnswerNew.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/drugHommeBest.do":
				ServiceInterface drugHommeBest = new drugHommeBestCrawler();
				
				
				request.setAttribute("drugHommeBest", drugHommeBest.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/drugHommeNew.do":
				ServiceInterface drugHommeNew = new drugHommeNewCrawler();
				
				
				request.setAttribute("drugHommeNew", drugHommeNew.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/elhommeBest.do":
				ServiceInterface elhommeBest = new elhommeBestCrawler();
				
				
				request.setAttribute("elhommeBest", elhommeBest.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/elhommeNew.do":
				ServiceInterface elhommeNew = new elhommeNewCrawler();
				
				
				request.setAttribute("elhommeNew", elhommeNew.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/showpinBest.do":
				ServiceInterface showpinBest = new showpinBestCrawler();
				
				
				request.setAttribute("showpinBest", showpinBest.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/showpinNew.do":
				ServiceInterface showpinNew = new showpinNewCrawler();
				
				
				request.setAttribute("showpinNew", showpinNew.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/enuffBest.do":
				ServiceInterface enuffBest = new enuffBestCrawler();
				
				
				request.setAttribute("enuffBest", enuffBest.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/enuffNew.do":
				ServiceInterface enuffNew = new enuffNewCrawler();
				
				
				request.setAttribute("enuffNew", enuffNew.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/lookpineBest.do":
				ServiceInterface lookpineBest = new lookpineBestCrawler();
				
				
				request.setAttribute("lookpineBest", lookpineBest.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/lookpineNew.do":
				ServiceInterface lookpineNew = new lookpineNewCrawler();
				
				
				request.setAttribute("lookpineNew", lookpineNew.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/modernifNew.do":
				ServiceInterface modernifNew = new modernifNewCrawler();
				
				
				request.setAttribute("modernifNew", modernifNew.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
			case "/views/locobasicBest.do":
				ServiceInterface locobasicBest = new locobasicBestCrawler();
				
				
				request.setAttribute("locobasicBest", locobasicBest.excute() );
				
				jsp = Beans.getJsp(command);
				System.out.println(jsp);
				break;
				
				
			default:
				System.out.println("존재하지 않는 자원을 요청");
				jsp="/WEB-INF/views/error/404.jsp";
				break;
			}
			
			if(jsp.indexOf("redirect:") == -1) // redirect: 존재하지 않는다.
				// jsp쪽으로 이동한다.
				request.getRequestDispatcher(jsp).forward(request, response);
			else {// redirect: 존재한다.
				// 앞에 붙는 redirect: 을 없앤다.
				jsp = jsp.substring("redirect:".length());
				// uri쪽으로 이동한다.
				response.sendRedirect(jsp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}

	}
}
