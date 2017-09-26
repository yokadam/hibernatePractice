package org.examples.Annotation_Inheritance_SINGLE_TABLE;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hemp001")
@DiscriminatorValue("s_emp")
public class SoftwareEmp extends Employee{

    private String skills;
    private Integer salary;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
