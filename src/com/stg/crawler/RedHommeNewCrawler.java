package com.stg.crawler;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webjjang.util.ServiceInterface;

public class RedHommeNewCrawler implements ServiceInterface {
	
	@Override
	public ArrayList<String> excute() throws Exception {
//		String bURL = "http://redhomme.com/category/best-seller/387/?page=1#Product_ListMenu";
		String nURL = "http://redhomme.com/category/new-in/111/?page=1#Product_ListMenu";
		
//		Document bestInitDoc = Jsoup.connect(bURL).get();
		Document newInInitDoc = Jsoup.connect(nURL).get();
		
//		Elements idxBest = bestInitDoc.select("ol li.xans-record-");
//		System.out.println(idxBest);
		Elements idxNew = newInInitDoc.select("ol li.xans-record-");
		
		ArrayList<String> newAr = new ArrayList<>();
		
		// TODO Auto-generated method stub
		for(int i =1; i <= idxNew.size() ; i++) {
			
			String URL = "http://redhomme.com/category/new-in/111/?page="+i+"#Product_ListMenu";
			Document newDoc = Jsoup.connect(URL).get();
			
			Elements newElsLink = newDoc.select("ul.grid4 li div.thumb a.tiny");
			Elements newElsImage = newDoc.select("ul.grid4 li div.thumb a.tiny img");
			Elements newElsDesc = newDoc.select("ul.grid4 li div.info");
			
			System.out.println("링크 사이즈 " + newElsLink.size());
			System.out.println("이미지 사이즈 " + newElsImage.size());
			System.out.println("설명 사이즈 " + newElsDesc.size());
			
			for(int j = 0; j < newElsImage.size(); j++) {
				Element es = newElsLink.get(j);
//				System.out.println(es.attr("abs:href"));
				newAr.add(es.attr("abs:href"));
				es = newElsImage.get(j);
				newAr.add(es.attr("abs:src"));
//				System.out.println(es.attr("abs:src"));
				es = newElsDesc.get(j);
				newAr.add(es.text());
//				System.out.println(es.text());
				
			}
			
		}
		
//		for(int i=1; i < idxNew.size(); i++) {
//			String URL = "http://redhomme.com/category/new-in/111/?page=" + i + "#Product_ListMenu";
//		}
		
		return newAr;
	}
	
	
			
}
