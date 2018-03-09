package src.Tests;

import src.main.Book;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;



class BookTest {

    HashMap test = new HashMap();
    Book newBook = new Book(test);


    @org.junit.jupiter.api.Test
    void add() {
        newBook.add("Dmitry", "1,1,1");
    }
   /* @org.junit.jupiter.api.Test
    void delete() {
    }

    @org.junit.jupiter.api.Test
    void changeAddress() {
    }

    @org.junit.jupiter.api.Test
    void getAddress() {
    }*/

    @org.junit.jupiter.api.Test
    void getPeopleByStreet() {
        newBook.add("Dmitry", "1,1,1");

        assertEquals("Dmitry", newBook.getPeopleByStreet("1"));
    }

    @org.junit.jupiter.api.Test
    void getPeopleByHouse() {
    }
}