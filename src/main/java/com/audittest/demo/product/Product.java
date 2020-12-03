package com.audittest.demo.product;

import com.audittest.demo.audit.Audit;
import com.audittest.demo.category.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Product  extends Audit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false,
            unique = true)
    private String name;

    @Column(nullable = false)
    private Float price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

}

