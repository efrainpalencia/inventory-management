package com.example.demo.domain;

import com.example.demo.validators.ValidDeletePart;
import com.example.demo.validators.ValidEnufParts;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
public abstract class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Price value must be positive")
    int inv;

    @Min(value = 0, message = "Price value must be positive")
    @Column(name = "min_inventory")
    int minInventory;

    @Min(value = 0, message = "Price value must be positive")
    @Column(name = "max_inventory")
    int maxInventory;

    @ManyToMany
   @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
           inverseJoinColumns=@JoinColumn(name="product_id"))

    Set<Product> products= new HashSet<>();

    public Part() {
    }

    public Part(final String name, final double price, final int inv, final int minInventory, final int maxInventory) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInventory = minInventory;
        this.maxInventory = maxInventory;
    }

    public Part(final long id, final String name, final double price, final int inv, final int minInventory, final int maxInventory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInventory = minInventory;
        this.maxInventory = maxInventory;
    }

    public int getMinInventory() {
        return this.minInventory;
    }

    public void setMinInventory(final int minInventory) {
        this.minInventory = minInventory;
    }

    public int getMaxInventory() {
        return this.maxInventory;
    }

    public void setMaxInventory(final int maxInventory) {
        this.maxInventory = maxInventory;
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

    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(final Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return name;
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;

        final Part part = (Part) o;

        return this.id == part.id;
    }

    @Override
    public int hashCode() {
        return (int) (this.id ^ (this.id >>> 32));
    }
}
