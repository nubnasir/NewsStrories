package com.nubnasir.newsstories.news.controller;

import com.nubnasir.newsstories.common.controller.BaseController;
import com.nubnasir.newsstories.common.enums.DateFlagEnum;
import com.nubnasir.newsstories.common.enums.OperationType;
import com.nubnasir.newsstories.common.enums.PageSizeEnum;
import com.nubnasir.newsstories.common.enums.ResponseCodeEnum;
import com.nubnasir.newsstories.common.model.OperationResponse;
import com.nubnasir.newsstories.news.model.dtos.NewsStoryDto;
import com.nubnasir.newsstories.news.model.dtos.NewsStoryPageData;
import com.nubnasir.newsstories.news.model.entity.NewsStory;
import com.nubnasir.newsstories.news.service.NewStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/news/stories")
public class NewsStoryController extends BaseController{

    @Autowired
    private NewStoryService newsStoriesService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String getStoryListing(Model model, HttpSession session){
        model.addAttribute("storyPageData", newsStoriesService.getNewsStoriesPageData(DateFlagEnum.ALL.getCode(), 0, PageSizeEnum.FOUR.getCode(), "", getAuthenticatedUserId(session)));
        return "listing";
    }

    @RequestMapping(value = "/ajax/{date}/{pageNumber}", method = RequestMethod.GET)
    public ResponseEntity<NewsStoryPageData> getAjaxData(@PathVariable("date") long date, @PathVariable("pageNumber") int pageNumber, @RequestParam(value = "searchText", required = false, defaultValue = "") String searchText, HttpSession session){
        return ResponseEntity.ok(newsStoriesService.getNewsStoriesPageData(date, pageNumber-1, PageSizeEnum.FOUR.getCode(), searchText, getAuthenticatedUserId(session)));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("newsStory", new NewsStoryDto());
        model.addAttribute(OPERATION_TYPE, OperationType.CREATE.getType());
        return "news-form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postForm(@Valid @ModelAttribute("newsStory") NewsStoryDto newsStoryDto, BindingResult result, Model model, RedirectAttributes redirectAttributes, HttpSession session){

        if(result.hasErrors()){
            model.addAttribute("newsStory", newsStoryDto);
            model.addAttribute(OPERATION_TYPE, OperationType.CREATE.getType());
            return "news-form";
        }
        newsStoriesService.createNewsStories(newsStoryDto, getAuthenticatedUserId(session));
        redirectAttributes.addFlashAttribute("successMsg", "News Story Created Successfully");
        return "redirect:/news/stories";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") long id, Model model, RedirectAttributes redirectAttributes, HttpSession session){
        NewsStoryDto newsStoryDto = newsStoriesService.getByIdAndUserId(id, getAuthenticatedUserId(session));
        if(newsStoryDto == null){
            redirectAttributes.addFlashAttribute("errorMsg", "Selected Item not found");
            return "redirect:/news/stories";
        }

        model.addAttribute("newsStory", newsStoryDto);
        model.addAttribute(OPERATION_TYPE, OperationType.EDIT.getType());
        return "news-form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String postEditForm(@PathVariable("id") long id, @Valid @ModelAttribute("newsStories") NewsStoryDto newsStoryDto, BindingResult result, Model model, HttpSession session, RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            model.addAttribute("newsStory", newsStoryDto);
            model.addAttribute(OPERATION_TYPE, OperationType.EDIT.getType());
            return "news-form";
        }
        OperationResponse response = newsStoriesService.updateNewsStories(newsStoryDto, getAuthenticatedUserId(session));
        if(response.getResponseCode() == ResponseCodeEnum.FAILED.getCode()) {
            redirectAttributes.addFlashAttribute("successMsg", "News Story Updated Successfully");
        } else {
            redirectAttributes.addFlashAttribute("errorMsg", response.getMessage());
        }
        return "redirect:/news/stories";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String postDelete(@RequestParam("id") long id, HttpSession session, RedirectAttributes redirectAttributes){
        NewsStory newsStory = newsStoriesService.getEntityByIdAndUserId(id, getAuthenticatedUserId(session));
        if(newsStory == null){
            redirectAttributes.addFlashAttribute("errorMsg", "Selected Item not found");
            return "redirect:/news/stories";
        }

        newsStoriesService.deleteNewsStories(newsStory);
        redirectAttributes.addFlashAttribute("successMsg", newsStory.getTitle() + " news story deleted permanently");
        return "redirect:/news/stories";
    }
}
