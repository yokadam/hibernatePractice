package org.examples.Annotation_ManyToOne_JOIN_table;

import javax.persistence.*;

@Entity
public class Book_1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String name;
    private String price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "BOOK_PUBLISHER",
            joinColumns = @JoinColumn(name = "BOOKID"),
            inverseJoinColumns = @JoinColumn(name = "PUBID"))
    private Publisher_1 publisher1;

    public Publisher_1 getPublisher1() {
        return publisher1;
    }

    public void setPublisher1(Publisher_1 publisher1) {
        this.publisher1 = publisher1;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
