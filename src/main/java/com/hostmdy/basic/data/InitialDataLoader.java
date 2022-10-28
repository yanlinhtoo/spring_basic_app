package com.hostmdy.basic.data;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.hostmdy.basic.entity.Author;
import com.hostmdy.basic.entity.Book;
import com.hostmdy.basic.repository.AuthorRepository;
import com.hostmdy.basic.repository.BookRepository;


@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public InitialDataLoader(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;//placeholder
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initialize();
		
	}
	
	private void initialize() {
		Book book1 = new Book("Domain Driven Design","Programming",34.0);
		Author author1 = new Author("Eris", "Evan", "eris@gmail.com");
		//ManyToMany connect
		book1.getAuthors().add(author1);
		author1.getBooks().add(book1);
		authorRepository.save(author1);//saved first inverse entity
		bookRepository.save(book1);
		
		Book book2 = new Book("Java 8 in Action","Programming",54.0);
		Author author2 = new Author("Jhon", "Doe", "doe@gmail.com");
		//ManyToMany connect
		book2.getAuthors().add(author2);
		author2.getBooks().add(book2);
		authorRepository.save(author2);//saved first inverse entity
		bookRepository.save(book2);
		
		
		Book book3 = new Book("Effective Java","Programming",20.0);
		Author author3 = new Author("Jhon", "Smith", "smith@gmail.com");
		//ManyToMany connect
		book3.getAuthors().add(author3);
		author3.getBooks().add(book3);
		authorRepository.save(author3);//saved first inverse entity
		bookRepository.save(book3);
		
		Book book4 = new Book("Modern", "IT", 60.77);
		book4.getAuthors().add(author1);
		book4.getAuthors().add(author2);
		book4.getAuthors().add(author3);
		
		
		authorRepository.save(author1);
		authorRepository.save(author2);
		authorRepository.save(author3);
		
		bookRepository.save(book4);
		
	}
	
	
}
