package com.infoGames.gameformation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    @GetMapping(path ="/nintendoNews")
    public String nintendoNews(){
        return "gameNews/nintendoNews";
    }

    @GetMapping(path = "/generalNews")
    public String generalNewsPage(){
        return "gameNews/general";
    }

    @GetMapping(path = "/articles")
    public String articlesPage(){
        return "/gameNews/articles";
    }

}
