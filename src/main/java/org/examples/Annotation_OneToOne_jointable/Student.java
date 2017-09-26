package org.examples.Annotation_OneToOne_jointable;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_2")
public class Student implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "s_name")
    private String name;

    @OneToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "STUD_ADDR",
            joinColumns = @JoinColumn(name = "STUD_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDR_ID")
    )
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
