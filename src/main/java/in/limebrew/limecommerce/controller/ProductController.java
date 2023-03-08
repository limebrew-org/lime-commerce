package in.limebrew.limecommerce.controller;

import in.limebrew.limecommerce.entity.ProductItem;
import in.limebrew.limecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Map<String, Object> healthCheck(){
        Map<String, Object> response = new HashMap<>();
        response.put("message","Server running successfully!");
        return response;
    }

    @GetMapping("/all")
    public List<ProductItem> getAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ProductItem getProductById(@PathVariable("id") String id){
        return productService.findProductById(id);
    }

    @PostMapping("/create")
    public ProductItem addProduct(@RequestBody ProductItem productItem){
        return productService.addProduct(productItem);
    }
}
