package org.examples.IS_A_REALTIONSHIP.model;

/**
 * Created by yogesh.kadam on 03.09.17.
 */
public class Admin extends CompanyEmployee {

    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Admin(String department) {
        this.department = department;
    }

    public Admin(String name, String email, int salary, String department) {
        super(name, email, salary);
        this.department = department;
    }
}
