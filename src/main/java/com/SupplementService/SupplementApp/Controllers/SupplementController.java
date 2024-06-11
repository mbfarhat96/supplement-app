package com.SupplementService.SupplementApp.Controllers;

import com.SupplementService.SupplementApp.Models.Supplement;
import com.SupplementService.SupplementApp.Services.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.List;

@Controller
public class SupplementController {

    @Autowired
    private SupplementService supplementService;

    //Return all Supplements
    @GetMapping("/")
    public String getSupplements(){
        return "home";
    }

    //Return a single supplement by name
    @GetMapping("/supplement")
    public String getSupplement(@RequestParam String name, Model model){
        System.out.println("Working on it" +name);
        Supplement supplement = supplementService.returnSupplement(name);

        System.out.println(supplement);
        model.addAttribute(supplement);
        return "supplementResult";
    }

    @GetMapping("/supplement-details")
    @ResponseBody
    public Supplement getSupplementJSON(@RequestParam String name){
        return supplementService.returnSupplement(name);
    }

    //Error handling draft
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No Such Supplement exists.")
    public static class SupplementNotFoundException extends RuntimeException {
        //...
    }
}
