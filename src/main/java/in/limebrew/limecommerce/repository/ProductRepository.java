package in.limebrew.limecommerce.repository;

import in.limebrew.limecommerce.entity.ProductItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends MongoRepository<ProductItem,String> {
    @Query("{id :?0}")
    Optional<ProductItem> findById(String id);
}
