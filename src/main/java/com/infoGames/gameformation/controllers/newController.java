package com.infoGames.gameformation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class newController {

    @GetMapping(path ="/nintendoNews")
    public String nintendoNews(){
        return "gameNews/nintendoNews";
    }

    @GetMapping(path = "/generalNews")
    public String generalNewsPage(){
        return "gameNews/general";
    }
}
