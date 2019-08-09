package com.data.dataproject.utils.crawling;

import com.data.dataproject.dto.DefaultRes;
import com.data.dataproject.dto.main.NewsDto;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class JsoupParser {

    public List<NewsDto> news() {

        List<NewsDto> newsDtoList = new ArrayList<>();
        Long id = 0L;

        String url = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=농민";
        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch(IOException e) {
            e.printStackTrace();
        }

        Elements element = doc.select("ul.type01 > li");

        for(Element el : element) {
            id += 1;
            Elements element1 = el.select("dl > dt > a");
            Elements element2 = el.select("div > a > img");

            NewsDto newsDto = new NewsDto();
            newsDto.setId(id);
            newsDto.setTitle(element1.attr("title"));
            newsDto.setImage(element2.attr("src"));
            newsDto.setRink(element1.attr("href"));

            newsDtoList.add(newsDto);
        }

        return newsDtoList;
    }

    public void food() {

        String url = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=농민";
        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch(IOException e) {
            e.printStackTrace();
        }



    }


}
