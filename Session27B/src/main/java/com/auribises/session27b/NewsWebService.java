package com.auribises.session27b;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsWebService {
	
	ArrayList<News> getNews(){
		
		ArrayList<News> news = new ArrayList<News>();
		
		news.add(new News("john", "Samsung will reportedly test remote work program as South Korea copes with new COVID-19 cases", "Samsung Electronics will reportedly begin trialing a work-from-home program for some employees next month as South Korea as the country deals with its largest increase in COVID-19 cases since March."));
		news.add(new News("jennie", "Fairphone's new flagship, the 3+, costs just €70 as a modular upgrade", "Dutch social enterprise, Fairphone, has moved a little closer to the sustainability dream of a circular economy by announcing the launch of a modular upgrade for its flagship smartphone."));
		news.add(new News("fionna", "Passion Capital has backed Fronted, the startup that wants to offers loans to cover rent deposits", "Fronted, the new London-based startup aiming to make life easier for renters, including lending the cash needed for a deposit, has picked up seed investment from Passion Capital"));
		news.add(new News("jim", "On-demand grocery startup Instashop acquired by Delivery Hero for $360M ", "Instashop, the Greece-headquartered on-demand grocery business, is being acquired by Delivery Hero for $360 million — thought to be the country’s biggest tech exit yet."));
		news.add(new News("jack", "TikTok CEO Kevin Mayer resigns after 100 days", "Kevin Mayer, the chief executive of TikTok, announced on Wednesday that he is resigning, just over 100 days after the former Disney executive joined the world’s largest short video app in mid-May"));
		news.add(new News("joe", "Facebook removes 'Kenosha Guard' militia account after shooter kills two at protest", "Facebook has removed a local self-declared militia’s page and a related event following the events that unfolded last night in Kenosha, Wisconsin."));
		
		return news;
	}
	
	@GetMapping("/news")
	public News latestNews(@RequestParam(name="author", required = false, defaultValue = "john") String author) {
		
		News news = new News("NA", "NA", "NA");
		
		for(News nRef : getNews()) {
			if(nRef.getAuthor().equals(author)){
				news = nRef;
				break;
			}
		}
		
		// It will automatically convert news object into JSON :) | jackson JSON library is used by Spring Boot Web FW
		return news;
	}
	
}

// Assignment: 
// Explore a Spring Boot Starter Project which will fetch JSON Data from Some other Web Service
// https://spring.io/guides/gs/consuming-rest/
