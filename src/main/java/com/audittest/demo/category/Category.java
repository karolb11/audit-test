package com.audittest.demo.category;

import com.audittest.demo.audit.Audit;
import com.audittest.demo.product.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Category extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false,
            unique = true)
    private String name;

    @Column(nullable = false)
    private String description;
    
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

}
