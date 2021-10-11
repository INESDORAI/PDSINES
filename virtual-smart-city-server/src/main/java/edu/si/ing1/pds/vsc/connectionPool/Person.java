package edu.si.ing1.pds.vsc.connectionPool;

public class Person {

    private int id_person;
    private String firstname;
    private int age;

    public int getId_person() {
        return this.id_person;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public int getAge() {
        return this.age;
    }

    public void setFirstname(String n) {
        this.firstname = n;
    }

    public void setAge(int a) {
        this.age = a;
    }

    public Person() {
    }

    public Person(int id_person, String fisrtname, int age) {
        this.id_person = id_person;
        this.firstname = firstname;
        this.age = age;
    }
}
