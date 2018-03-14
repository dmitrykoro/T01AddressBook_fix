package src.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    private Map<String, String> data;

    public Book(Map<String, String> data) {
        this.data = data;
    }

    public Book add(String name, String address) {                                 //adding people + address
        data.put(name, address);
        return this;
    }

    public Book delete(String name) {                                              //deleting people by name
        if (data.containsKey(name)) {
            data.remove(name);
        }
        else throw new IllegalArgumentException("There's no such name in the Book");
        return this;
    }

    public Book changeAddress(String name, String address) {                       //changing address by people's name
        if (data.containsKey(name)) {
            data.replace(name, address);
        }
        else throw new IllegalArgumentException("Nothing to replace");
        return this;
    }

    public String getAddress(String name) {                                        //getting address by people's name
        if (data.containsKey(name)) {
            return data.get(name);
        }
        else throw new IllegalArgumentException("There's no people with this name");
    }

    public List<String> getPeopleByStreet(String street) {                             //getting all people by street
        ArrayList<String> peopleByStreet = new ArrayList<String>();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getValue().split(",")[0].equals(street)) {
                peopleByStreet.add(entry.getKey());
            }
        }
        return peopleByStreet;
    }

    public List<String> getPeopleByHouse(String street) {                             //getting all people by street
        ArrayList<String> peopleByHouse = new ArrayList<String>();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getValue().split(",")[1].equals(street)) {
                peopleByHouse.add(entry.getKey());
            }
        }
        return peopleByHouse;
    }
}