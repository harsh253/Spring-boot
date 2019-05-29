package com.springboot.Controller;

import com.springboot.Entity.Book;
import com.springboot.Entity.BookUpdatePayload;
import com.springboot.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping //For Spring to know that it is a getter method
    public Collection<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping //Create Operation
    public Book postBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping(value="/{id}")
    public Optional<Book> getBookById(@PathVariable("id") String id){
        return bookService.getBookById(id);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Book> deleteBookById(@PathVariable("id") String id){
        return bookService.deleteBookById(id);
    }

    @PutMapping(value="/{id}")
    public Optional<Book> updateBookById(@PathVariable("id") String id, @RequestBody BookUpdatePayload bookUpdatePayload){
        return bookService.updateBookById(id, bookUpdatePayload);
    }


}
