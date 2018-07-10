package com.stg.crawler;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webjjang.util.ServiceInterface;

public class locobasicBestCrawler implements ServiceInterface {

	@Override
	public ArrayList<String> excute() throws Exception {
		String url = "http://locobasic.com/";
		
		ArrayList<String> ar = new ArrayList<>();

		Document doc = Jsoup.connect(url).get();

		Elements elsImg = doc.select("li.item.xans-record- div.box div.thumbnail a img.thumb");
		Elements elsLink = doc.select("li.item.xans-record- div.box div.thumbnail a");
		Elements elsDesc = doc.select("li.item.xans-record- div.box div.description div.fadearea");

		System.out.println("링크 사이즈 " + elsLink.size());
		System.out.println("이미지 사이즈 " + elsImg.size());
		System.out.println("설명 사이즈 " + elsDesc.size());

		for (int j = 0; j < elsImg.size(); j++) {
			Element es = elsLink.get(j);
			// System.out.println(es.attr("abs:href"));
			ar.add(es.attr("abs:href"));
			es = elsImg.get(j);
			ar.add(es.attr("abs:src"));
			// System.out.println(es.attr("abs:src"));
			es = elsDesc.get(j);
			ar.add(es.text());
			// System.out.println(es.text());

		}

		return ar;
	}

}
