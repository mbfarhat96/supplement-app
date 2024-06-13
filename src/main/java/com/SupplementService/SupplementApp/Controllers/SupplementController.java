package com.SupplementService.SupplementApp.Controllers;

import com.SupplementService.SupplementApp.Models.Supplement;
import com.SupplementService.SupplementApp.Services.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SupplementController {

    @Autowired
    private SupplementService supplementService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    //Homepage
    @GetMapping("/")
    public String getSupplements(){
        return "home";
    }

    //Return a single supplement by name (used first when searching from homepage)
    @GetMapping("/supplement")
    public String getSupplement(@RequestParam String name, Model model){
        System.out.println("Working on it" +name);
        Supplement supplement = supplementService.returnSupplement(name);

        System.out.println(supplement);
        model.addAttribute(supplement);
        return "supplementResult";
    }

    //Used for every subsequent search to via javascript
    @GetMapping("/supplement-details")
    @ResponseBody
    public Supplement getSupplementJSON(@RequestParam String name){

        //Grab supplement from cache
        Supplement supplement = (Supplement) redisTemplate.opsForValue().get(name);

        //If supplement doesn't exist, then grab from database
        if(supplement == null){
            System.out.println("Supplement not found in cache. Fetching from database.");
            supplement = supplementService.returnSupplement(name);
            //Store supplement in cache
            if(supplement != null){
                System.out.println("Storing supplement in cache: " + name);
                redisTemplate.opsForValue().set(name,supplement);
            }
        } else {
            System.out.println("Found supplement in cache:"+ name);
        }
        //Return supplement
        return supplement;
    }


}
