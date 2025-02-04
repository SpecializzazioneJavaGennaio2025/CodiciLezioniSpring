package it.aulab.progetto_blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.progetto_blog.models.Author;
import it.aulab.progetto_blog.services.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String authorsIndex(Model viewModel){
        viewModel.addAttribute("title", "Tutti gli autori");
        viewModel.addAttribute("authors", authorService.readAll());
        return "authors";
    }

    @GetMapping("/create")
    public String create(Model viewModel){
        viewModel.addAttribute("title", "Crea un nuovo autore");
        viewModel.addAttribute("author", new Author());
        return "create";
    } 

    @PostMapping
    public String store(@ModelAttribute("author") Author author){
        authorService.create(author);
        return "redirect:/authors";
    }

}
