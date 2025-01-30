package it.aulab.progetto_blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import it.aulab.progetto_blog.models.Author;

public interface AuthorRepository extends ListCrudRepository<Author, Long> {
    //Se scrivo ByName la proprietà nel modello author SI DEVE CHIAMARE "name"
    List<Author> findByName(String firstname);

    List<Author> findBySurname(String lastname);

    List<Author> findByNameAndSurname(String name, String surname);

    //Query nativa, perchè utilizza sql PURO
    @Query(value = "SELECT * FROM authors a WHERE a.firstname = 'Giuseppe'", nativeQuery = true)
    List<Author> authorsWithSpecifiedName();

    //Query non nativa, perchè non utilizza sql puro ma gli oggetti
    @Query(value = "SELECT a FROM Author a WHERE a.name= 'Giuseppe'")
    List<Author> authorsWithSpecifiedNameNonNative();
}
