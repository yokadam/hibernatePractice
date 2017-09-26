package org.examples.Annotation_OneToMany_JOIN_column_bidirectional;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "book_444")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bid;
    private String bname;

    @OneToMany(mappedBy = "book")
    // When used mappedBy ....You can not use @JoinColumn
    /*@JoinColumn(name = "book_join_chapter_id")*/
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
