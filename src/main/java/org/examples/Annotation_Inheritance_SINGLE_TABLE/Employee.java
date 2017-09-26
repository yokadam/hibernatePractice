package org.examples.Annotation_Inheritance_SINGLE_TABLE;

import javax.persistence.*;

@Entity
@Table(name = "emp001")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "D_TYPE",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
