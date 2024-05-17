package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{

    public static final String xs = "XS";
    public static final String s = "S";
    public static final String m = "M";
    public static final String l = "L";
    public static final String xl = "XL";

    private String size;

    public Dog () {

    }

    public Dog (String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Pet {"
                + "type: " + getType()
                + ", sex: " + getSex()
                + ", age: " + getAge()
                + ", name: " + getName()
                + ", size: " + size
                + ", ownerName: " + getOwnerName()
                + "}";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
}
