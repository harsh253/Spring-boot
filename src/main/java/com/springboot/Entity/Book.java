package com.springboot.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Book") // for MongoDB
public class Book {

    @Id
    private String id;
    private String author;
    private String title;

//    public Book(String author, String title) {
  //      this.author = author;
    //    this.title = title;
    //}


    public Book(String id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
