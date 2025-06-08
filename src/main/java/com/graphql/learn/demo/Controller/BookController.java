package com.graphql.learn.demo.Controller;

import com.graphql.learn.demo.Entity.Book;
import com.graphql.learn.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {
    @Autowired
    BookService bookService;

    //create
    @PostMapping("/book")
    public Book create(@RequestBody  Book book){
        return bookService.create(book);
    }

    //getAll
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    //getByBookId
    @GetMapping("/book/{bookId}")
    public Book getBookById(@PathVariable int bookId){
        return bookService.getBook(bookId);
    }
}
