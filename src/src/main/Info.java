package src.main;

import java.util.List;
import java.util.Objects;


public class Info  {
    public Info(String name, String street, String house, String flat) {
        this.name = name;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(name, info.name) &&
                Objects.equals(street, info.street) &&
                Objects.equals(house, info.house) &&
                Objects.equals(flat, info.flat);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, street, house, flat);
    }

    public String name;
    public String street;
    public String house;
    public String flat;

    public String getFlat() {
        return flat;
    }

    public String getHouse() {
        return house;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }
}
