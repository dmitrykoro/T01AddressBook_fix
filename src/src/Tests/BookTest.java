package src.Tests;

import src.main.Book;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book newBook = new Book();

    @org.junit.jupiter.api.Test
    void add() {
        newBook.add("Dmitry", "Bely Kuna,5,144");
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
        assertEquals("Dmitry", newBook.getPeopleByStreet("Bely kuna"));
    }

    @org.junit.jupiter.api.Test
    void getPeopleByHouse() {
    }
}