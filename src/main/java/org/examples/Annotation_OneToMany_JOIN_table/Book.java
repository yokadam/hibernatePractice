package org.examples.Annotation_OneToMany_JOIN_table;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "book555")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bid;
    private String bname;


    @OneToMany
    @JoinTable(name = "BOOK_CHAPTER_45",
                joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "chapt_id")
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Chapter> chapters;



    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }
}
