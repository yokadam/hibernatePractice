package org.examples.Annotation_OneToOne_JOIN_column;


import javax.persistence.*;

@Entity
@Table(name = "address_1")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "a_id")
    private int aid;

    @Column(name = "a_pinCode")
    private String pinCode;

    @Column(name = "a_state")
    private String state;

    @OneToOne(mappedBy = "address")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
