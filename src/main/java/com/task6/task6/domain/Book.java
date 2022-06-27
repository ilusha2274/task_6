package com.task6.task6.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String dateCreate;

    private String text;

    public Long getId() {
        return id;
    }

    public Book() {
    }

    public Book(String name, String dateCreate, String text) {
        this.name = name;
        this.dateCreate = dateCreate;
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
