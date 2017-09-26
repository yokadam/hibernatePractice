package org.examples.IS_A_REALTIONSHIP.model;

/**
 * Created by yogesh.kadam on 03.09.17.
 */
public class CompanyEmployee {

    private Integer id;
    private String name;
    private String email;
    private int salary;

    public CompanyEmployee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CompanyEmployee(String name, String email, int salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
