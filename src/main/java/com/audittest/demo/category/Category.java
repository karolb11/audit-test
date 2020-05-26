package com.audittest.demo.category;

import com.audittest.demo.audit.Audit;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(nullable = false,
            unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
