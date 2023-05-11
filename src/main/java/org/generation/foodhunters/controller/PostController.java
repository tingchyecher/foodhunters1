package org.generation.foodhunters.controller;

import org.generation.foodhunters.service.PostService;
import org.generation.foodhunters.repository.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {


    private final PostService postService;


    public PostController(@Autowired PostService postService )
    {
        this.postService = postService;
    }


    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Post> getPost()
    {
        return postService.all();
    }

}
