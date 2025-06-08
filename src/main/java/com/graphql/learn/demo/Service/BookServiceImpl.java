package com.graphql.learn.demo.Service;

import com.graphql.learn.demo.Entity.Book;
import com.graphql.learn.demo.Repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book create(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBook(int bookId) {
        return bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
    }
}
