package com.graphql.learn.demo;

import com.graphql.learn.demo.Entity.Book;
import com.graphql.learn.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1= new Book();
		Book b2 = new Book();
		b1.setAuthor("Devesh");
		b1.setDesc("Life of Pooja");
		b1.setPages(20);
		b1.setPrice("50.00");
		b1.setTitle("Emotional Story");

		b2.setAuthor("Anand");
		b2.setDesc("Life of Sharma");
		b2.setPages(200);
		b2.setPrice("500.00");
		b2.setTitle("Emotional Story of Devesh and Pooja");

		bookService.create(b1);
		bookService.create(b2);
	}
}
