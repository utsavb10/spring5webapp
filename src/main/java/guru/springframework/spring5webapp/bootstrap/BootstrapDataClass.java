package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapDataClass implements CommandLineRunner {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;

  public BootstrapDataClass(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author a = new Author("Utsav", "Bansal");
    Book b = new Book("My Sad Life" ,"54353");
    Book b2 = new Book("Dear Love", "123");

    // Get the Set and add books to set
    a.getBooks().add(b);
    a.getBooks().add(b2);

    //Add the entity to Repository, saved in memory datatbase rn
    authorRepository.save(a);

    System.out.println("In Bootsrap Class");
    System.out.println(a.getFirstName() + " has "+ a.getBooks().size() + "books");
  }

}
