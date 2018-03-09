package src.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

    public class Book {

        private HashMap data;

    public Book (HashMap data) {
       this.data = data;
    }


    public void add (String name, String address) {  //adding people + address
        data.put(name, address);
    }

    public void delete (String name) {    //deleting people by name
        if (data.containsKey(name)) {
            data.remove(name);
        }
        else throw new IllegalArgumentException("There's no such name in the Book");
    }

    public void changeAddress (String name, String address) {         //changing address by people's name
        if (data.containsKey(name)) {
            data.replace(name, address);
        }
        else throw new IllegalArgumentException("Nothing to replace");
    }

    public String getAddress (String name) {                 //getting address by people's name
        if (data.containsKey(name)) {
            return data.get(name).toString();
        }
        else throw new IllegalArgumentException("There's no people with this name");
    }

    public String getPeopleByStreet (String street) {           //getting all people by street
       // Book newBook = new Book()
        List names = new ArrayList(data.keySet());
        List addresses = new ArrayList(data.values());
        String peopleByStreet = "";
       for (int i = 0; i < names.size(); i++) {
           String temp = addresses.get(i).toString().split(",")[0];
            //if (addresses.get(i).toString().split(",")[0] == street) {
           if (addresses.get(i).toString().split(",")[0].equals(street)) {
                peopleByStreet += names.get(i).toString();
            }
        }
        return peopleByStreet;
    }

    public String getPeopleByHouse (String house) {         //getting all people by house
        List names = new ArrayList(data.keySet());
        List addresses = new ArrayList(data.values());
        String peopleByHouse = "";
        for (int i = 0; i < names.size(); i++) {
            if (addresses.get(i).toString().split(",")[1].equals(house)) {
                peopleByHouse += names.get(i).toString();
            }
        }
        return peopleByHouse;
    }
}
