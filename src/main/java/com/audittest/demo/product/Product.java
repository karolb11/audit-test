package com.audittest.demo.product;

import com.audittest.demo.audit.Audit;
import com.audittest.demo.category.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Product  extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(nullable = false,
            unique = true)
    private String name;

    @Column(nullable = false)
    private Float price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Product() {
    }

    public Product(String name, Float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}

