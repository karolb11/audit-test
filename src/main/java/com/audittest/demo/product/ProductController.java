package com.audittest.demo.product;

import com.audittest.demo.util.CRUDController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController extends CRUDController<Product> {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/newProduct")
    public ResponseEntity<?> saveNewProduct(@RequestBody Product product) {
        return handleCreateRequest(productService::create, product);
    }

}
