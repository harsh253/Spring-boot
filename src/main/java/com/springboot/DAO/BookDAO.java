package com.springboot.DAO;

import com.springboot.Entity.Book;
import com.springboot.Entity.BookUpdatePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookDAO {
    @Autowired
    private BookRepository repository;

    public Collection<Book> getBooks(){
        Collection<Book> collection = repository.findAll();
        Iterator<Book> iterator = collection.iterator();

        while(iterator.hasNext()){
            System.out.println("Getting data from Db: " + iterator.next().getAuthor());
        }

        return repository.findAll();
    }

    public Book createBook(Book book) {
        return repository.insert(book);
    }

    public Optional<Book> getBookById(String id) {
        return repository.findById(id);
    }

    public Optional<Book> deleteBookById(String id) {
        Optional<Book> book = repository.findById(id);
        book.ifPresent(b -> repository.delete(b));
        return book;
    }

    public Optional<Book> updateBookById(String id, BookUpdatePayload bookUpdatePayload) {
        Optional<Book> book = repository.findById(id);
        book.ifPresent(b -> b.setTitle(bookUpdatePayload.getTitle()));
        book.ifPresent(b -> b.setAuthor(bookUpdatePayload.getAuthor()));
        book.ifPresent(b -> repository.save(b));
        return book;
    }
}
