package com.stg.crawler;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webjjang.util.ServiceInterface;

public class enuffBestCrawler implements ServiceInterface {

	
	
	@Override
	public ArrayList<String> excute() throws Exception {
		String url = "http://enuffnuff.com/product/list.html?cate_no=42&page=1";
		
		Document docOuter = Jsoup.connect(url).get();
		Elements elsInner = docOuter.select("div.xans-element-.xans-product.xans-product-normalpaging.ec-base-paginate-text ol li:last-child");
		
		Element esInner = elsInner.get(0);
		String idxStr = esInner.text();
		int idx = Integer.parseInt(idxStr);
		System.out.println("라스트 인덱스 : " + idx);
		
		ArrayList<String> ar = new ArrayList<>();
		
		for(int i = 1; i <= idx; i++) {
			String URL = "http://enuffnuff.com/product/list.html?cate_no=42&page="+i;
			Document doc = Jsoup.connect(URL).get();
			
			
			Elements elsImg = doc.select("ul.prdList.grid2 li.item.xans-record- div.box div.thumbnail a img");
			Elements elsLink = doc.select("ul.prdList.grid2 li.item.xans-record- div.box div.thumbnail a");
			Elements elsDesc = doc.select("ul.prdList.grid2 li.item.xans-record- div.box div.item_info");
			
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
