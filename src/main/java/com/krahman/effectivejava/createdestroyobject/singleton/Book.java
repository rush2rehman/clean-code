package com.krahman.effectivejava.createdestroyobject.singleton;

import java.io.Serializable;

/*Approach 1 - public field:
1. Simple
2. API makes is clear that the class in singleton - public static final
*/
public class Book implements Serializable {

    private String name;

    public static final Book INSTANCE = new Book("Homo Sapiens");

    private Book(String name){
        this.name = name;
    }

    public Book getINSTANCE() {
        return INSTANCE;
    }


    public Object readResolve(){
        return INSTANCE;
    }

}

//Approach 2 - public accessor method
// Can accommodate change of mind - singleton to non singleton
// Can be used as supplier Phone::getInstance


class Phone{

    private String brand;

    private static final Phone INSTANCE = new Phone("Nokia");

    private Phone(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public static Phone getInstance(){
        return INSTANCE;
    }

    public Object readResolve(){
        return INSTANCE;
    }


}


//Approach 3
//Foolproof method, takes care of single instance criteria every where - serialization, reflective attacks etc

enum Pen{

    INSTANCE("Blue");

    private String color;

    private Pen(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static void main(String...s){
        Book book =  Book.INSTANCE;
        Phone phone = Phone.getInstance();
        Pen pen = Pen.INSTANCE;
        System.out.println(pen.getColor());
    }
}