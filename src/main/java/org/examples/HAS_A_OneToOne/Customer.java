package org.examples.HAS_A_OneToOne;

/**
 * Created by yogesh.kadam on 04.09.17.
 */
public class Customer {

    private int cId;
    private String name;
    private Address address;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
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
