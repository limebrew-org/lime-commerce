package in.limebrew.limecommerce.utils;

import in.limebrew.limecommerce.entity.ProductItem;
import java.util.HashMap;
import java.util.Map;

public class ProductItemResponse {
    //? Wrapper function to parse Product Entity
    public static Map<String, Object> parseProductItem(ProductItem productItem) {
        Map<String,Object> productResponse = new HashMap<>();
        productResponse.put("id",productItem.id.toString());
        productResponse.put("name",productItem.name);
        productResponse.put("description",productItem.description);
        productResponse.put("stock_count",productItem.stock_count);
        productResponse.put("price",Math.round(productItem.price*100)/100D);
        productResponse.put("rating",Math.round(productItem.rating*10)/10F);
        return productResponse;
    }
}
