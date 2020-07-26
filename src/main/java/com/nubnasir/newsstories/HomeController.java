package com.nubnasir.newsstories;

import com.nubnasir.newsstories.news.service.NewStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 9/9/18.
 */

@Controller
public class HomeController {

    @RequestMapping(value = {"/home", "/", ""})
    public String getHome(Model model){
        return "home";
    }
}
