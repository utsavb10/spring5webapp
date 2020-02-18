package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapDataClass implements CommandLineRunner {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  public BootstrapDataClass(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author a = new Author("Utsav", "Bansal");
    Book b = new Book("My Sad Life" ,"54353");
    Book b2 = new Book("Dear Love", "123");
    Publisher p = new Publisher("BansalJi", "1234 gali", "Rohtak", "Haryana", 124001);
    // Get the Set and add books to set

    bookRepository.save(b);
    bookRepository.save(b2);
    publisherRepository.save(p);


    a.getBooks().add(b);
    a.getBooks().add(b2);
    b.setPublisher(p);
    b2.setPublisher(p);
    p.getBookSet().add(b);
    p.getBookSet().add(b2);

    //Add the entity to Repository, saved in memory datatbase rn
    authorRepository.save(a);

    System.out.println("In Bootsrap Class");
    System.out.println(a.getFirstName() + " has "+ a.getBooks().size() + "books");

    //had to save all objects in repo first or they wouldn't find the associated objects
    bookRepository.save(b);
    bookRepository.save(b2);
    publisherRepository.save(p);
    System.out.println("Number of publishers right now: "+publisherRepository.count());

  }

}
