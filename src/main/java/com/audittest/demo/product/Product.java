package com.audittest.demo.product;

import com.audittest.demo.audit.Audit;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
class Product  extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(nullable = false,
            unique = true)
    private String name;

    @Column(nullable = false)
    private Float price;

    public Product() {
    }

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }
}

