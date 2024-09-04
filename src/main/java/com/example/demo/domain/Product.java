package com.example.demo.domain;

import com.example.demo.validators.ValidEnufParts;
import com.example.demo.validators.ValidProductPrice;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "products")
@ValidProductPrice
@ValidEnufParts
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Lob
    String description;
    String image;
    @Min(value = 0, message = "Price value must be positive") double price;
    @Min(value = 0, message = "Inventory value must be positive") int inv;
    @ManyToMany(mappedBy = "products")
    Set<Part> parts = new HashSet<>();

    public Product() {
    }

    public Product(final String name, final double price, final int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public Product(final long id, final String name, final String description, final String image, final double price, final int inv) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.inv = inv;
    }

    public Product(String name, String description, String image, double price, int inv) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.inv = inv;
    }


    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public int getInv() {
        return this.inv;
    }

    public void setInv(final int inv) {
        this.inv = inv;
    }

    public Set<Part> getParts() {
        return this.parts;
    }

    public void setParts(final Set<Part> parts) {
        this.parts = parts;
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;

        final Product product = (Product) o;

        return this.id == product.id;
    }

    @Override
    public int hashCode() {
        return (int) (this.id ^ (this.id >>> 32));
    }
}
