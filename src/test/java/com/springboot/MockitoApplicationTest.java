package com.springboot;

import com.springboot.DAO.BookRepository;
import com.springboot.Entity.Book;
import com.springboot.Service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;



import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoApplicationTest {
    @Autowired
    private BookService service;

    @MockBean
    private  BookRepository repository;

    @Test
    public void TestCases(){

        //Add books to collection
        Collection<Book> collection = new ArrayList<Book>();
        Book book1 = new Book("1", "Author 1", "Title 1");
        Book book2 = new Book("2", "Author 2","Title 2");
        collection.add(book1);
        collection.add(book2);

        //getAllBooks
        when(repository.findAll()).thenReturn((List<Book>) collection);
        assertEquals(2, service.getBooks().size());

        //getBookById
        when(repository.findById("2")).thenReturn(Optional.of(book2));
        assertEquals("Author 2", service.getBookById("2").get().getAuthor());

    }

}
