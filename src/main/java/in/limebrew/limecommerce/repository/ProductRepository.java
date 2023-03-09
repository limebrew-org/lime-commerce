package in.limebrew.limecommerce.repository;

import in.limebrew.limecommerce.entity.ProductItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductItem, ObjectId> {
}
