package com.example.myprject;

public class Animal {
String name,phone,animaltype,location,askingprice;
        String image;

    public Animal() {
    }

    public Animal(String name, String phone, String animaltype, String location, String askingprice) {
        this.name = name;
        this.phone = phone;
        this.animaltype = animaltype;
        this.location = location;
        this.askingprice = askingprice;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAskingprice() {
        return askingprice;
    }

    public void setAskingprice(String askingprice) {
        this.askingprice = askingprice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", animaltype='" + animaltype + '\'' +
                ", location='" + location + '\'' +
                ", askingprice='" + askingprice + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
