package com.nubnasir.newsstories.user.controller;

import com.nubnasir.newsstories.common.controller.BaseController;
import com.nubnasir.newsstories.user.model.dto.UserRegistrationDto;
import com.nubnasir.newsstories.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.xml.ws.soap.Addressing;

/**
 * Created by root on 9/12/18.
 */
@Controller
public class RegistrationController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("registrationDto", new UserRegistrationDto());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationPost(@Valid @ModelAttribute("registrationDto") UserRegistrationDto registrationDto, BindingResult result, Model model, RedirectAttributes redirectAttributes){

        if(!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())){
            result.addError(new FieldError("registrationDto", "password", "", false, null, null, "Password and confirm password doesn't match"));
        }
        if(result.hasErrors()){
            model.addAttribute("registrationDto", registrationDto);
            return "registration";
        }

        userService.registerUser(registrationDto);

        redirectAttributes.addFlashAttribute("successMsg", "Registration complete, please login");
        return "redirect:/login";
    }

    @RequestMapping(value = "/registration/unique/user/name", method = RequestMethod.GET)
    public @ResponseBody boolean checkUniqueUserName(@RequestParam String userName){
        return userService.getByUserName(userName) == null;
    }
}
