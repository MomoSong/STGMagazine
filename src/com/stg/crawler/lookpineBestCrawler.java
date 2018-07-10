package com.stg.crawler;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webjjang.util.ServiceInterface;

public class lookpineBestCrawler implements ServiceInterface {

	@Override
	public ArrayList<String> excute() throws Exception {
		String url = "http://www.lookpine.com/";
		
		ArrayList<String> ar = new ArrayList<>();

		Document doc = Jsoup.connect(url).get();

		Elements elsImg = doc.select("div#contents div.xans-element-.xans-product.xans-product-listmain-1.xans-product-listmain.xans-product-1 ul.prdList.column3 li.item.xans-record- div.box div.prdover a img");
		Elements elsLink = doc.select("div#contents div.xans-element-.xans-product.xans-product-listmain-1.xans-product-listmain.xans-product-1 ul.prdList.column3 li.item.xans-record- div.box div.prdover a:last-child");
		Elements elsDesc = doc.select("div#contents div.xans-element-.xans-product.xans-product-listmain-1.xans-product-listmain.xans-product-1 ul.prdList.column3 li.item.xans-record- div.box div.prdover a:last-child div.infobox");

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
