package in.limebrew.limecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    @Id
    @Field( name = "_id" )
    public ObjectId id;

    @Field( name = "name" )
    public String name;

    @Field( name = "description" )
    public String description;

    @Field( name = "stock_count" )
    public Integer stock_count;

    @Field( name = "price" )
    public Double price;

    @Field( name = "rating" )
    public Float rating;
}
