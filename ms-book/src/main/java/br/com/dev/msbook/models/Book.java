package br.com.dev.msbook.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Book implements Serializable {
    private Long id;
    private String author;
    private Date launchDate;
    private BigDecimal price;
    private String title;
    private String currency;
    private String environment;

    public Book() {
    }

    public Book(Long id, String author, Date launchDate, BigDecimal price, String title, String currency, String environment) {
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
        this.currency = currency;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id) && author.equals(book.author) && launchDate.equals(book.launchDate) && price.equals(book.price) && title.equals(book.title) && currency.equals(book.currency) && environment.equals(book.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, launchDate, price, title, currency, environment);
    }
}
