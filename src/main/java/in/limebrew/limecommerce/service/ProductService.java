package in.limebrew.limecommerce.service;

import in.limebrew.limecommerce.entity.ProductItem;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductItem> findAllProducts();
    Optional<ProductItem> findProductById(ObjectId id);
    Optional<ProductItem> addProduct(ProductItem productItem);
    void deleteProductById(ObjectId id);
}
