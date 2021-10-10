package edu.si.ing1.pds.vsc.connectionPool;

public class Person {

    private int id;
    private String name;
    private int age;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setAge(int a) {
        this.age = a;
    }

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
