package in.limebrew.limecommerce.controller;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import in.limebrew.limecommerce.entity.ProductItem;
import in.limebrew.limecommerce.service.ProductService;
import in.limebrew.limecommerce.utils.ProductItemResponse;
import in.limebrew.limecommerce.utils.ResponseStatusHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;
import java.util.*;


@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {
    private final String Schema = "Product";
    @Autowired
    private ProductService productService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> getAllProducts(){
        //? Initialize wrapper storage
        ArrayList<Map<String,Object>> parsedAllProducts = new ArrayList<>();

        //? Get All Products
        List<ProductItem> allProducts = productService.findAllProducts();

        //? wrap all product items
        allProducts.forEach((productItem -> {
            Map<String,Object> parsedProductItem = ProductItemResponse.parseProductItem(productItem);
            parsedAllProducts.add(parsedProductItem);
        }));

        //? Return response
        return ResponseStatusHandler.responseSuccessGetMany(parsedAllProducts,Schema);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getProductById(@PathVariable("id") ObjectId id){
        //? Find Product Item By Id
        Optional<ProductItem> foundItem = productService.findProductById(id);

        //? Handle if not found
        if(foundItem.isEmpty()){
            return ResponseStatusHandler.responseErrorNotFound(id,Schema);
        }

        //? Add wrapper function to parse product entity
        Map<String,Object> parsedProductItem = ProductItemResponse.parseProductItem(foundItem.get());

        //? Return response
        return ResponseStatusHandler.responseSuccessGetOne(id,parsedProductItem,Schema);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String,Object>> addProduct(@RequestBody ProductItem productItem){
        //? Add product item into db
        Optional<ProductItem> addedProductItem = productService.addProduct(productItem);

        //? Handle if not added
        if(addedProductItem.isEmpty()){
            return ResponseStatusHandler.responseErrorInternal();
        }

        //? Add wrapper function to parse product entity
        Map<String,Object> parsedProductItem = ProductItemResponse.parseProductItem(addedProductItem.get());

        //? Return response
        return ResponseStatusHandler.responseSuccessAddOne(parsedProductItem,Schema);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String,Object>> updateProductById(@PathVariable("id") ObjectId id,@RequestBody ProductItem productItem){
        //? Check if product item exist with the given id
        Update updateFields = new Update();

        //? Update the fields
        updateFields.set("name",productItem.name);
        updateFields.set("description",productItem.description);
        updateFields.set("stock_count",productItem.stock_count);
        updateFields.set("price",productItem.price);
        updateFields.set("rating",productItem.rating);

        //? Update Query
        UpdateResult updateResult = mongoTemplate.update(ProductItem.class)
                .matching(Criteria.where("_id").is(id))
                .apply(updateFields)
                .first();

        //! Error not found
        if(updateResult.getMatchedCount() == 0){
            return ResponseStatusHandler.responseErrorNotFound(id,Schema);
        }

        //! Internal Server Error
        if(updateResult.getModifiedCount() == 0){
            return ResponseStatusHandler.responseErrorInternal();
        }

        //? Set the id
        productItem.id = id;

        //? Add wrapper function to parse product entity
        Map<String,Object> parsedProductItem = ProductItemResponse.parseProductItem(productItem);

        //? Return response
        return ResponseStatusHandler.responseSuccessUpdateOne(id,parsedProductItem,Schema);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Object>> deleteProductById(@PathVariable("id") ObjectId id){
        //? Delete by Id
        DeleteResult deleteResult = mongoTemplate.remove(ProductItem.class).matching(Criteria.where("_id").is(id)).one();

        //! Error not found
        if(deleteResult.getDeletedCount() == 0){
            return ResponseStatusHandler.responseErrorNotFound(id,Schema);
        }

        //? Return response
        return ResponseStatusHandler.responseSuccessDelete(id,Schema);
    }
}
