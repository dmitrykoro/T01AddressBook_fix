package src.Tests;

import org.junit.jupiter.api.Test;
import src.main.Book;
import src.main.Info;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    public ArrayList<Info> test = new ArrayList<Info>();
    public Book bookTest = new Book(test);


    @Test
    void add() {

        bookTest.addPeople("Dmitry", "Nevsky", "44", "57");
        bookTest.addPeople("Ivan", "Nevsky", "35", "654");
        bookTest.addPeople("Fedor", "Nevsky", "2", "10");

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Dmitry");
        expected.add("Ivan");
        expected.add("Fedor");

        assertEquals(expected, bookTest.getPeopleByStreet("Nevsky"));
    }

    @Test
    void delete() {

        bookTest.addPeople("Dmitry", "Nevsky", "44", "57");
        bookTest.addPeople("Ivan", "Nevsky", "35", "654");
        bookTest.addPeople("Fedor", "Nevsky", "2", "10");

        bookTest.delete("Ivan");

        assertThrows(IllegalArgumentException.class, () -> bookTest.getAddress("Ivan"));
    }

    @Test
    void changeAddress() {

        bookTest.addPeople("Dmitry", "Nevsky", "44", "57");
        bookTest.addPeople("Ivan", "Nevsky", "35", "654");
        bookTest.addPeople("Fedor", "Nevsky", "2", "10");

        bookTest.changeAddress("Dmitry", "Slavy prospect", "50", "189");

        ArrayList<Info> expected = new ArrayList<Info>();
        expected.add(new Info("Dmitry", "Slavy prospect", "50", "189"));
        expected.add(new Info("Ivan", "Nevsky", "35", "654"));
        expected.add(new Info("Fedor", "Nevsky", "2", "10"));

        assertEquals(expected, bookTest.data);
        assertThrows(IllegalArgumentException.class, () -> bookTest.changeAddress("Petor", "", "", ""));

    }

    @Test
    void getAddress() {

        bookTest.addPeople("Dmitry", "Nevsky", "44", "57");
        bookTest.addPeople("Ivan", "Nevsky", "35", "654");
        bookTest.addPeople("Fedor", "Nevsky", "2", "10");

        Info expected = new Info("Fedor", "Nevsky", "2", "10");

        assertEquals(expected, bookTest.getAddress("Fedor"));
    }

    @Test
    void getPeopleByStreet() {

        bookTest.addPeople("Dmitry", "Nevsky", "44", "57");
        bookTest.addPeople("Ivan", "Nevsky", "35", "654");
        bookTest.addPeople("Fedor", "Nevsky", "2", "10");
        bookTest.addPeople("Anton Ivanov", "Slavy prospect","1", "55");
        bookTest.addPeople("Ivan Petrov", "Nevsky","74","89");
        bookTest.addPeople("Fedor Korolev", "Nevsky","45","99");
        bookTest.addPeople("Aalexandr Petrov", "Nevsky","74","55");

        ArrayList<String> expected = new ArrayList<String>();

        expected.add("Dmitry");
        expected.add("Ivan");
        expected.add("Fedor");
        expected.add("Ivan Petrov");
        expected.add("Fedor Korolev");
        expected.add("Aalexandr Petrov");

        assertEquals(expected, bookTest.getPeopleByStreet("Nevsky"));
    }

    @Test
    void getPeopleByHouse() {
        bookTest.addPeople("Dmitry", "Nevsky", "44", "57");
        bookTest.addPeople("Ivan", "Nevsky", "35", "654");
        bookTest.addPeople("Fedor", "Nevsky", "2", "10");
        bookTest.addPeople("Anton Ivanov", "Slavy prospect","1", "55");
        bookTest.addPeople("Ivan Petrov", "Nevsky","74","89");
        bookTest.addPeople("Fedor Korolev", "Nevsky","45","99");
        bookTest.addPeople("Aalexandr Petrov", "Nevsky","74","55");

        ArrayList<String> expected = new ArrayList<String>();

        expected.add("Ivan Petrov");
        expected.add("Aalexandr Petrov");

        assertEquals(expected, bookTest.getPeopleByHouse("74"));
    }
}