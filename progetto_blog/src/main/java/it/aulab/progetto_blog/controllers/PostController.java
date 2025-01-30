package it.aulab.progetto_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.aulab.progetto_blog.models.Post;
import it.aulab.progetto_blog.repositories.PostRepository;

@Controller
@RequestMapping("/posts")
public class PostController {
    
    @Autowired
    PostRepository postRepository;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<Post> getAllPost(){
        return postRepository.findAll();
    }
}
