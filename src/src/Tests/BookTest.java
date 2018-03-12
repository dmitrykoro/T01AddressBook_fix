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

        assertEquals("Dmitry", newBook.getPeopleByHouse("1"));
    }

    @org.junit.jupiter.api.Test
    void delete() {
        newBook.add("Anton Ivanov", "Slavy prospect,1,55");
        newBook.delete("Anton Ivanov");

       // assertEquals(, newBook.getAddress("Anton Ivanov"));

    }

    @org.junit.jupiter.api.Test
    void changeAddress() {
        newBook.add("Anton Ivanov", "Slavy prospect,1,55");
        newBook.add("Ivan Petrov", "Nevsky,74,89");
        newBook.changeAddress("Ivan Petrov", "1,1,1");

        assertEquals("1,1,1", newBook.getAddress("Ivan Petrov"));
    }

    @org.junit.jupiter.api.Test
    void getAddress() {
        newBook.add("Dmitry Korobeynikov", "Ulitsa,78,242");
        newBook.add("Anton Ivanov", "Slavy prospect,1,55");
        newBook.add("Ivan Petrov", "Nevsky,74,89");
        newBook.add("Fedor Korolev", "Nevsky,45,99");
        newBook.add("Aalexandr Petrov", "Nevsky,74,55");
        newBook.add("Michail", "Ulitsa1,1,1");

        assertEquals("Ulitsa,78,242", newBook.getAddress("Dmitry Korobeynikov"));

    }

    @org.junit.jupiter.api.Test
    void getPeopleByStreet() {
        newBook.add("Dmitry Korobeynikov", "Ulitsa,78,242");
        newBook.add("Anton Ivanov", "Slavy prospect,1,55");
        newBook.add("Ivan Petrov", "Nevsky,74,89");
        newBook.add("Fedor Korolev", "Nevsky,45,99");
        newBook.add("Aalexandr Petrov", "Nevsky,74,55");
        newBook.add("Michail", "Ulitsa1,1,1");

        assertEquals("Ivan Petrov Fedor Korolev Aalexandr Petrov",
                newBook.getPeopleByStreet("Nevsky"));

    }

    @org.junit.jupiter.api.Test
    void getPeopleByHouse() {
        newBook.add("Dmitry Korobeynikov", "Ulitsa,78,242");
        newBook.add("Anton Ivanov", "Slavy prospect,1,55");
        newBook.add("Ivan Petrov", "Nevsky,74,89");
        newBook.add("Fedor Korolev", "Nevsky,45,99");
        newBook.add("Aalexandr Petrov", "Nevsky,74,55");
        newBook.add("Michail", "Ulitsa1,1,1");

        assertEquals("Ivan Petrov Aalexandr Petrov", newBook.getPeopleByHouse("74"));
    }
}