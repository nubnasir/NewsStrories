package com.nubnasir.newsstories.news.controller;

import com.nubnasir.newsstories.news.converter.NewsStoryModelConverter;
import com.nubnasir.newsstories.news.model.dtos.NewsStoryDto;
import com.nubnasir.newsstories.news.model.entity.NewsStory;
import com.nubnasir.newsstories.news.model.thirdparty.ApiNewsStory;
import com.nubnasir.newsstories.news.service.NewStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlAnyAttribute;

/**
 * Created by root on 9/11/18.
 */
@RestController
@RequestMapping("/public/api/news/stories")
public class NewsStoryThirdPartyController {

    @Autowired
    private NewStoryService newStoryService;

    @Autowired
    private NewsStoryModelConverter newsStoryModelConverter;

    @RequestMapping(value = "/json/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ApiNewsStory getJsonNewsStory(@PathVariable("id") long id){
        return newsStoryModelConverter.convertToDtoToApi(newStoryService.getById(id));
    }

    @RequestMapping(value = "/xml/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody ApiNewsStory getXmlNewsStory(@PathVariable("id") long id){
        return newsStoryModelConverter.convertToDtoToApi(newStoryService.getById(id));
    }
}
