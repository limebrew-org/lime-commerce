package in.limebrew.limecommerce.service.impl;

import in.limebrew.limecommerce.entity.ProductItem;
import in.limebrew.limecommerce.repository.ProductRepository;
import in.limebrew.limecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductItem> findAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public ProductItem findProductById(String id){
        return productRepository.findById(id).get();
    }

    @Override
    public ProductItem addProduct(ProductItem productItem){
        return productRepository.save(productItem);
    }
}
