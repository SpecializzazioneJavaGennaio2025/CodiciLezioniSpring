package it.aulab.progetto_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.aulab.progetto_blog.models.Comment;
import it.aulab.progetto_blog.repositories.CommentRepository;

@Controller
@RequestMapping("/comments")
public class CommentController {
 @Autowired
    private CommentRepository commentRepository;
    
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}
