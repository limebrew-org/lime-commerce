package in.limebrew.limecommerce.service.impl;

import in.limebrew.limecommerce.entity.ProductItem;
import in.limebrew.limecommerce.repository.ProductRepository;
import in.limebrew.limecommerce.service.ProductService;
import org.bson.types.ObjectId;
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
    public Optional<ProductItem> findProductById(ObjectId id){
        return productRepository.findById(id);
    }

    @Override
    public Optional<ProductItem> addProduct(ProductItem productItem){
        return Optional.of(productRepository.save(productItem));
    }

    @Override
    public void deleteProductById(ObjectId id){
        productRepository.deleteById(id);
    }
}
