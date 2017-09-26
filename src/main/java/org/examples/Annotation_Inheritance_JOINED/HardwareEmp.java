package org.examples.Annotation_Inheritance_JOINED;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "hemp002")
@PrimaryKeyJoinColumn(name = "EMP_ID")
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
