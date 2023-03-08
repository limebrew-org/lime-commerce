package in.limebrew.limecommerce.entity;

import jakarta.annotation.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")
public class ProductItem {
    @Id
    @Field( name = "id" )
    public String id;

    @Field( name = "name" )
    public String name;

    @Field( name = "description" )
    public String description;

    @Field( name = "count" )
    public Integer stockCount;

    @Field( name = "price" )
    public Double price;

    @Field( name = "rating" )
    public Float rating;

    public ProductItem() {
    }

    public ProductItem(String id, String name, String description, Integer stockCount, Double price, Float rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stockCount = stockCount;
        this.price = price;
        this.rating = rating;
    }
}
