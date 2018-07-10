package com.stg.crawler;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webjjang.util.ServiceInterface;

public class showpinNewCrawler implements ServiceInterface {

	
	
	@Override
	public ArrayList<String> excute() throws Exception {
		String url = "https://showpin.co.kr/product/list.html?cate_no=122&page=1";
		
		Document docOuter = Jsoup.connect(url).get();
		Elements elsInner = docOuter.select("div.xans-element-.xans-product.xans-product-normalpaging.ec-base-paginate ol li:last-child");
		
		Element esInner = elsInner.get(0);
		String idxStr = esInner.text();
		int idx = Integer.parseInt(idxStr);
		System.out.println("라스트 인덱스 : " + idx);
		
		ArrayList<String> ar = new ArrayList<>();
		
		Elements specialPriceImg = docOuter.select("div.xans-element-.xans-product.xans-product-listrecommend.ec-base-product "
				+ "ul.prdList.grid4 li.xans-record- div.thumbnail a img");
		Elements specialPriceLink = docOuter.select("div.xans-element-.xans-product.xans-product-listrecommend.ec-base-product "
				+ "ul.prdList.grid4 li.xans-record- div.thumbnail a");
		Elements specialPriceDesc = docOuter.select("div.xans-element-.xans-product.xans-product-listrecommend.ec-base-product "
				+ "ul.prdList.grid4 li.xans-record- div.description");
		
		for(int i = 0; i < specialPriceImg.size(); i++) {
			Element es = specialPriceLink.get(i);
//			System.out.println(es.attr("abs:href"));
			ar.add(es.attr("abs:href"));
			es = specialPriceImg.get(i);
			ar.add(es.attr("abs:src"));
//			System.out.println(es.attr("abs:src"));
			es = specialPriceDesc.get(i);
			ar.add(es.text());
//			System.out.println(es.text());
			
		}
		
		for(int i = 1; i <= idx; i++) {
			String URL = "https://showpin.co.kr/product/list.html?cate_no=122&page="+i;
			Document doc = Jsoup.connect(URL).get();
			
			String imgCss = "div.xans-element-.xans-product.xans-product-listnormal.ec-base-product "
					+ "ul.prdList.grid3 li.xans-record- div.thumbnail a img";
			String linkCss = "div.xans-element-.xans-product.xans-product-listnormal.ec-base-product " 
					+ "ul.prdList.grid3 li.xans-record- div.thumbnail a";
			String descCss = "div.xans-element-.xans-product.xans-product-listnormal.ec-base-product "
					+ "ul.prdList.grid3 li.xans-record- div.description";
			
			Elements elsImg = doc.select(imgCss);
			Elements elsLink = doc.select(linkCss);
			Elements elsDesc = doc.select(descCss);
			
			System.out.println("링크 사이즈 " + elsLink.size());
			System.out.println("이미지 사이즈 " + elsImg.size());
			System.out.println("설명 사이즈 " + elsDesc.size());
			
			for(int j = 0; j < elsImg.size(); j++) {
				Element es = elsLink.get(j);
//				System.out.println(es.attr("abs:href"));
				ar.add(es.attr("abs:href"));
				es = elsImg.get(j);
				ar.add(es.attr("abs:src"));
//				System.out.println(es.attr("abs:src"));
				es = elsDesc.get(j);
				ar.add(es.text());
//				System.out.println(es.text());
				
			}
			
		}
		
		
		return ar;
	}
	
}
