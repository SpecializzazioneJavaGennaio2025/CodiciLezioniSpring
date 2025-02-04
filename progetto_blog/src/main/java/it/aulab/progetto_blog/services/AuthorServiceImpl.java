package it.aulab.progetto_blog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.aulab.progetto_blog.dtos.AuthorDto;
import it.aulab.progetto_blog.models.Author;
import it.aulab.progetto_blog.models.Post;
import it.aulab.progetto_blog.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
    
    @Autowired
    private AuthorRepository authorRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public List<AuthorDto> readAll() {
        // return authorRepository.findAll();
        List<AuthorDto> dtos = new ArrayList<AuthorDto>();
        for(Author author: authorRepository.findAll()){
            dtos.add(modelMapper.map(author, AuthorDto.class));
        }
        return dtos;
    }
    
    @Override
    public AuthorDto read(Long id) {
        // Optional<Author> optAuthor = authorRepository.findById(id);
        // if(optAuthor.isPresent()){
        //     return optAuthor.get();
        // }else{
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author id=" + id + " not found");
        // }
        Optional<Author> optAuthor = authorRepository.findById(id);
        if (optAuthor.isPresent()) {
            return modelMapper.map(optAuthor.get(), AuthorDto.class);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author id=" + id + " not found");
        }
    }
    
    @Override
    public List<AuthorDto> read(String email) {
        // if(email == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        // return authorRepository.findByEmail(email);
        if(email == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        List<AuthorDto> dtos = new ArrayList<AuthorDto>();
        for(Author author: authorRepository.findByEmail(email)){
            dtos.add(modelMapper.map(author, AuthorDto.class));
        }
        return dtos ;
    }
    
    @Override
    public List<AuthorDto> read(String firstname, String lastname) {
        // if (firstname == null || lastname == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        // return authorRepository.findByNameAndSurname(firstname, lastname);
        if (firstname == null || lastname == null)
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        List<AuthorDto> dtos = new ArrayList<AuthorDto>();
        for(Author author: authorRepository.findByNameAndSurname(firstname, lastname)){
            dtos.add(modelMapper.map(author, AuthorDto.class));
        }
        return dtos ;
    }
    
    @Override
    public AuthorDto create(Author author) {
        // if (author.getEmail() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        // return authorRepository.save(author);
        if (author.getEmail() == null)
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return modelMapper.map(authorRepository.save(author), AuthorDto.class);
    }
    
    @Override
    public AuthorDto update(Long id, Author author) {
        // if(authorRepository.existsById(id)){
        //     author.setId(id);
        //     return authorRepository.save(author);
        // }else{
        //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        // }
        if (authorRepository.existsById(id)) {
            author.setId(id);
            return modelMapper.map(authorRepository.save(author), AuthorDto.class) ;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    
    @Override
    public void delete(Long id) {
        if(authorRepository.existsById(id)){
            Author author = authorRepository.findById(id).get();
            List<Post> authorPosts = author.getPosts();
            for (Post post : authorPosts) {
                post.setAuthor(null);
            }
            authorRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }
    }
    
}
