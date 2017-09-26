package org.examples.Annotation_OneToMany_JOIN_column;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "chapter444")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;

    private String cname;

    private Integer pages;


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
