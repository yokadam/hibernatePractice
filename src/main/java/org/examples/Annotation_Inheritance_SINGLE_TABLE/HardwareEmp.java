package org.examples.Annotation_Inheritance_SINGLE_TABLE;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hemp001")
@DiscriminatorValue("h_emp")
public class HardwareEmp extends Employee {

    String dept;
    Integer wHours;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getwHours() {
        return wHours;
    }

    public void setwHours(Integer wHours) {
        this.wHours = wHours;
    }
}
