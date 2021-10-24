package edu.si.ing1.pds.vsc.connectionPool;

public class Person {

    private int idPerson;
    private String firstname;
    private int age;

    public int getIdPerson() {
        return this.idPerson;
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

    public Person(int idPerson, String fisrtname, int age) {
        this.idPerson = idPerson;
        this.firstname = firstname;
        this.age = age;
    }
}
