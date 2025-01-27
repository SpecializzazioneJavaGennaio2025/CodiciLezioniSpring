package it.aulab.progetto_blog;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import it.aulab.progetto_blog.models.Author;
import it.aulab.progetto_blog.repositories.AuthorRepository;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ProgettoBlogApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@BeforeEach
    void load(){
        Author a1 = new Author();
        a1.setName("Giuseppe");
        a1.setSurname("Verdi");
		a1.setEmail("VerdiG@test.it");
        authorRepository.save(a1);
    }

	@Test
	void findByName(){
        assertThat(authorRepository.findByName("Giuseppe"))
        .extracting("name")
        .containsOnly("Giuseppe");
    }

	@Test
    void specifiedNameAuthor(){
        assertThat(authorRepository.authorsWithSpecifiedName())
            .extracting("name")
            .containsOnly("Giuseppe");
    }
	

	@Test
    void sameNameAuthorNonNative(){
        assertThat(authorRepository.authorsWithSpecifiedNameNonNative())
            .extracting("name")
            .containsOnly("Giuseppe");
    }
}
