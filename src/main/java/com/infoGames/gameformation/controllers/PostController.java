package com.infoGames.gameformation.controllers;

import com.infoGames.gameformation.models.Post;
import com.infoGames.gameformation.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/discussion")
    public String getPosts(Model model){
        model.addAttribute("post", new Post());
        return "discussion/feed";
    }

    @PostMapping("/create/post")
    public String createPost(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/discussion";
    }
}
