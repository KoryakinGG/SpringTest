package ru.geekbrains.koryakin.Lesson3;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "item")
    private String item;

    @Column (name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "buyers_id")
    private Buyer buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product() {

    }

    public Product(Long id, String item, int price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    @Override
    public String toString () {
        return String.format("Product: [id = %d; item = %s, price = %d]", id, item, price);
    }
}
