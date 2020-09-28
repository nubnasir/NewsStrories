package com.nubnasir.newsstories.news.controller;

import com.nubnasir.newsstories.news.converter.NewsStoryModelConverter;
import com.nubnasir.newsstories.news.model.thirdparty.ApiNewsStory;
import com.nubnasir.newsstories.news.service.NewStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api/news/stories")
public class NewsStoryThirdPartyController {

    private NewStoryService newStoryService;
    private NewsStoryModelConverter newsStoryModelConverter;

    @Autowired
    public NewsStoryThirdPartyController(NewStoryService newStoryService,
                                         NewsStoryModelConverter newsStoryModelConverter) {
        this.newStoryService = newStoryService;
        this.newsStoryModelConverter = newsStoryModelConverter;
    }

    @RequestMapping(value = "/json/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ApiNewsStory getJsonNewsStory(@PathVariable("id") long id){
        return newsStoryModelConverter.convertToDtoToApi(newStoryService.getById(id));
    }

    @RequestMapping(value = "/xml/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody ApiNewsStory getXmlNewsStory(@PathVariable("id") long id){
        return newsStoryModelConverter.convertToDtoToApi(newStoryService.getById(id));
    }
}
