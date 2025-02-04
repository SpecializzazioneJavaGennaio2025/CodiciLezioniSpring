package it.aulab.progetto_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.aulab.progetto_blog.dtos.AuthorDto;
import it.aulab.progetto_blog.models.Author;
import it.aulab.progetto_blog.models.Post;
import it.aulab.progetto_blog.repositories.AuthorRepository;
import it.aulab.progetto_blog.services.AuthorService;

@RestController
// @Controller
@RequestMapping("/api/authors")
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;

    // @Autowired
    // private AuthorRepository authorRepository;
    
    // @RequestMapping(value="/authors" , method=RequestMethod.GET)
    // @RequestMapping(method=RequestMethod.GET)
    @GetMapping
    // public @ResponseBody List<Author> getAllAuthors() {
    public List<AuthorDto> getAllAuthors() {
        // return authorRepository.findAll();
        return authorService.readAll();
    }

    @GetMapping("/{id}")
    // public @ResponseBody Author getAuthor(@PathVariable("id") Long id){
    public AuthorDto getAuthor(@PathVariable("id") Long id){
        // return authorRepository.findById(id).get();
        return authorService.read(id);
    }

    @GetMapping("/{email}")
    public List<AuthorDto> getAuthor(@PathVariable("email") String email){
        return authorService.read(email);
    }

    @GetMapping("/{firstname}/{lastname}")
    public List<AuthorDto> getAuthor(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname){
        return authorService.read(firstname, lastname);
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody Author author){
        // return authorRepository.save(author);
        return authorService.create(author);
    }

    @PutMapping("/{id}")
    public AuthorDto updateAuthor(@PathVariable("id") Long id, @RequestBody Author author){
        // author.setId(id);
        // return authorRepository.save(author);
        return authorService.update(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") Long id){

        // authorRepository.deleteById(id);

        // if(authorRepository.existsById(id)){
        //     authorRepository.deleteById(id);
        // }else{
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        // }

        // if(authorRepository.existsById(id)){
        //     Author author = authorRepository.findById(id).get();
        //     List<Post> authorPosts = author.getPosts();
        //     for (Post post : authorPosts) {
        //         post.setAuthor(null);
        //     }
        //     authorRepository.deleteById(id);
        // }else{
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        // }

        authorService.delete(id);
    }

}