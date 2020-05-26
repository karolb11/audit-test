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
    private String price;

    public Product() {
    }

    public Product(ProductRequest payload) {
        name = payload.getName();
        price = payload.getPrice();
    }

    public void update(ProductRequest payload) {
        name = payload.getName();
        price = payload.getPrice();
    }
}

