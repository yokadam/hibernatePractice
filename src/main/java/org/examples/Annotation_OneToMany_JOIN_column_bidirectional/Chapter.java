package org.examples.Annotation_OneToMany_JOIN_column_bidirectional;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "c444")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;

    private String cname;

    private Integer pages;

    // @ManyToOne ...there is no mappedBy
    @ManyToOne
    @JoinColumn(name = "book_join_chapter_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

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
