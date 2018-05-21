package src.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.*;

public class Book {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(data, book.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public ArrayList<Info> data;

    public Book(ArrayList<Info> data) {
        this.data = data;
    }

    public Book addPeople(String name, String street, String house, String flat) {
        data.add(new Info(name, street, house, flat));
        return this;
    }

    public Book delete(String name) {
        boolean removed = false;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                removed = true;
            }
        }
        if (!removed)throw new IllegalArgumentException("There's no such name in the Book");
        return this;
    }

    public Book changeAddress(String name, String newStreet, String newHouse, String newFlat) {
        boolean changed = false;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.set(i, new Info(name, newStreet, newHouse, newFlat));
                changed = true;
            }
        }
        if (!changed) throw new IllegalArgumentException("Nothing to replace");
        return this;
    }

    public Info getAddress(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                return data.get(i);
            }
        }
        throw new IllegalArgumentException("There's no people with this name");
    }

    public ArrayList<String> getPeopleByStreet(String street) {
        ArrayList<String> allOnStreet = new ArrayList<String>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getStreet().equals(street)) {
                allOnStreet.add(data.get(i).getName());
            }
        }
        return allOnStreet;
    }

    public ArrayList<String> getPeopleByHouse(String house) {
        ArrayList<String> allInHouse = new ArrayList<String>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getHouse().equals(house)) {
                allInHouse.add(data.get(i).getName());
            }
        }
        return allInHouse;
    }
}