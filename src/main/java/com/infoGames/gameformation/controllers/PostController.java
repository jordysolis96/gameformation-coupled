package com.infoGames.gameformation.controllers;

import com.infoGames.gameformation.models.Category;
import com.infoGames.gameformation.models.Post;
import com.infoGames.gameformation.models.User;
import com.infoGames.gameformation.repositories.CategoryRepository;
import com.infoGames.gameformation.repositories.PostRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class PostController {

    private PostRepository postDao;
    private CategoryRepository categoryDao;

    public PostController(PostRepository postDao, CategoryRepository categoryDao){
        this.postDao = postDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/discussion")
    public String getPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("post", new Post());
        return "discussion/feed";
    }

    @PostMapping("/create/post")
    public String createPost(@ModelAttribute Post post, @RequestParam(name = "category")long catgory){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(currentUser);
        Category postCategory = categoryDao.getReferenceById(catgory);
        post.setCategory(postCategory);
        post.setLocalDate(LocalDate.now());
        postDao.save(post);
        return "redirect:/discussion";
    }
}
