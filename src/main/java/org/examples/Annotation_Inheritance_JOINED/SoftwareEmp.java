package org.examples.Annotation_Inheritance_JOINED;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "semp002")
@PrimaryKeyJoinColumn(name = "EMP_ID")
public class SoftwareEmp extends Employee {

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
