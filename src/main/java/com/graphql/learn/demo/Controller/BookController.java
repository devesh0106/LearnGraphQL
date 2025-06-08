package com.graphql.learn.demo.Controller;

import com.graphql.learn.demo.Entity.Book;
import com.graphql.learn.demo.Service.BookService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController
@RequestMapping("/library")*/
@Controller
public class BookController {
    @Autowired
    BookService bookService;

    //create
/*    @PostMapping("/book")*/
    @MutationMapping("createBook")
    public Book create(@Argument  BookInput book){
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setPrice(book.getPrice());
        b.setPages(book.getPages());
        b.setDesc(book.getDesc());
        b.setAuthor(book.getAuthor());
        return bookService.create(b);
    }

    //getAll
//    @GetMapping("/books")
    @QueryMapping("allBooks")
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    //getByBookId
   /* @GetMapping("/book/{bookId}")*/
    @QueryMapping("getBook")
    public Book getBookById(@Argument int bookId){
        return bookService.getBook(bookId);
    }
}

class BookInput{
    private String title;
    private String author;
    private String price;
    private String desc;
    private int pages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


}
