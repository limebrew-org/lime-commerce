package in.limebrew.limecommerce.service;

import in.limebrew.limecommerce.entity.ProductItem;
import java.util.List;

public interface ProductService {
    List<ProductItem> findAllProducts();
    ProductItem findProductById(String id);
//    ProductItem findProductByName(String name);
    ProductItem addProduct(ProductItem productItem);
//    void updateProductById(String id);
//    void deleteProductbyId(String id);
//    void deleteAll();
}
