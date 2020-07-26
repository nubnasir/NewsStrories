package com.nubnasir.newsstories.news.controller;

import com.nubnasir.newsstories.common.enums.DateFlagEnum;
import com.nubnasir.newsstories.common.enums.PageSizeEnum;
import com.nubnasir.newsstories.common.enums.UserTypeEnum;
import com.nubnasir.newsstories.news.model.dtos.NewsStoryPageData;
import com.nubnasir.newsstories.news.service.NewStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by root on 9/12/18.
 */
@Controller
@RequestMapping("/public/news/stories")
public class PublicNewsStoriesController {

    @Autowired
    private NewStoryService newsStoriesService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String getStoryListing(Model model){
        model.addAttribute("storyPageData", newsStoriesService.getNewsStoriesPageData(DateFlagEnum.ALL.getCode(), 0, PageSizeEnum.FOUR.getCode(), "", UserTypeEnum.ANONYMOUS.getCode()));
        return "public-listing";
    }

    @RequestMapping(value = "/ajax/{date}/{pageNumber}", method = RequestMethod.GET)
    public ResponseEntity<NewsStoryPageData> getAjaxData(@PathVariable("date") long date, @PathVariable("pageNumber") int pageNumber, @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText){
        return ResponseEntity.ok(newsStoriesService.getNewsStoriesPageData(date, pageNumber-1, PageSizeEnum.FOUR.getCode(), searchText, UserTypeEnum.ANONYMOUS.getCode()));
    }

}
