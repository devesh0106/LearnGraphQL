package com.graphql.learn.demo.Service;

import com.graphql.learn.demo.Entity.Book;

import java.util.List;

public interface BookService {
    //create
    Book create(Book book);

    //getAll
    List<Book> getAll();

    //get Single Book
    Book getBook(int bookId);
}
