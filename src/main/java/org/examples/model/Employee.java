package org.examples.model;

/**
 * Created by yogesh.kadam on 02.09.17.
 */
public class Employee {

    private int id;
    private String name;
    private String departemnt;
    private int salary;

    public Employee() {
    }

    public Employee( String name, String departemnt, int salary) {
        this.name = name;
        this.departemnt = departemnt;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartemnt() {
        return departemnt;
    }

    public void setDepartemnt(String departemnt) {
        this.departemnt = departemnt;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
