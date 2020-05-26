package com.audittest.demo.category;

import com.audittest.demo.util.Payload;
import lombok.Data;

@Data
public class CategoryRequest extends Payload {
    private String name;
    private String description;
}
