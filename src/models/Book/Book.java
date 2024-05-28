/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.Book;

/**
 *
 * @author trinh
 */
public class Book {

    private String id;
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private int quantity;
    private int price;
    private int issuedQuantity;

    public Book() {
    }

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(String id, String title, int issuedQuantity) {
        this.id = id;
        this.title = title;
        this.issuedQuantity = issuedQuantity;
    }

    public Book(String id, String title, String author, String genre, String publisher, int price, int quantity) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(int issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

}
