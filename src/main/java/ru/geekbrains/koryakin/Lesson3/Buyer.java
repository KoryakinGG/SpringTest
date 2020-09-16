package ru.geekbrains.koryakin.Lesson3;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyers_details")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @OneToMany (mappedBy = "buyer")
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Buyer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Buyer() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "Buyer{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
