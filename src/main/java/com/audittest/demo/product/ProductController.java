package com.audittest.demo.product;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;
    private final ProductService productService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.mapToProductIgnoreId(productDTO);
        Product savedProduct = productService.save(product);
        return productMapper.mapToProductDTO(savedProduct);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ProductDTO findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return productMapper.mapToProductDTO(product);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ProductDTO updateById(@PathVariable Long id,
                                 @RequestBody ProductDTO productDTO) {
        Product product = productService.findById(id);
        productMapper.updateProductFromDTO(productDTO, product);
        Product updatedProduct = productService.save(product);
        return productMapper.mapToProductDTO(updatedProduct);
    }
}
