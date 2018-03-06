package src.Tests;

import src.main.Book;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book newBook = new Book();

    @org.junit.jupiter.api.Test
    void add() {
        newBook.add("Dmitry", "");
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }

    @org.junit.jupiter.api.Test
    void changeAddress() {
    }

    @org.junit.jupiter.api.Test
    void getAddress() {
    }

    @org.junit.jupiter.api.Test
    void getPeopleByStreet() {
        assertEquals("Dmitry", newBook.getPeopleByStreet(""));
    }

    @org.junit.jupiter.api.Test
    void getPeopleByHouse() {
    }
}