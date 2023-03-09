package in.limebrew.limecommerce.utils;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResponseStatusHandler {
    //? status -> 200
    public static ResponseEntity<Map<String,Object>> responseSuccessGetOne(ObjectId id, Map<String, Object> entity, String schema){
        Map<String,Object> response = new HashMap<>();
        response.put("status",200);
        response.put("message",String.format("%s item found for id = %s",schema,id.toString()));
        response.put("data",entity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //? status -> 200
    public static ResponseEntity<Map<String,Object>> responseSuccessGetMany(ArrayList<Map<String,Object>> entityList, String schema){
        Map<String,Object> response = new HashMap<>();
        response.put("status",200);
        response.put("message",String.format("%d %s were found",entityList.size(),schema));
        response.put("data",entityList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    //? status -> 201
    public static ResponseEntity<Map<String,Object>> responseSuccessAddOne(Map<String, Object> entity, String schema){
        Map<String,Object> response = new HashMap<>();
        response.put("status",201);
        response.put("message",String.format("%s item added successfully",schema));
        response.put("data",entity);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //? status -> 201
    public static ResponseEntity<Map<String,Object>> responseSuccessUpdateOne(ObjectId id,Map<String, Object> entity, String schema){
        Map<String,Object> response = new HashMap<>();
        response.put("status",201);
        response.put("message",String.format("%s item with id = %s updated successfully",schema,id.toString()));
        response.put("data",entity);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //? status -> 201
    public static ResponseEntity<Map<String,Object>> responseSuccessDelete(ObjectId id, String schema){
        Map<String,Object> response = new HashMap<>();
        response.put("status",201);
        response.put("message",String.format("%s item with id = %s was deleted successfully",schema,id.toString()));
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //? status -> 404
    public static ResponseEntity<Map<String,Object>> responseErrorNotFound(ObjectId id, String schema){
        Map<String,Object> response = new HashMap<>();
        response.put("status",404);
        response.put("error",String.format("%s item not found for id = %s!",schema,id));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    //? status -> 400
    public static ResponseEntity<Map<String,Object>> responseBadRequest(){
        Map<String,Object> response = new HashMap<>();
        response.put("status",400);
        response.put("error",String.format("Bad Request!"));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    //? status -> 500
    public static ResponseEntity<Map<String,Object>> responseErrorUnknown(){
        Map<String,Object> response = new HashMap<>();
        response.put("status",500);
        response.put("error",String.format("Something went wrong, Internal Server Error!"));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //? status -> 500
    public static ResponseEntity<Map<String,Object>> responseErrorKnown(String error){
        Map<String,Object> response = new HashMap<>();
        response.put("status",500);
        response.put("error",String.format(error));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //? status -> 500
    public static ResponseEntity<Map<String,Object>> responseErrorInternal(){
        Map<String,Object> response = new HashMap<>();
        response.put("status",500);
        response.put("error",String.format("Internal Server Error!"));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //? status -> 401
    public static ResponseEntity<Map<String,Object>> responseErrorAuth(){
        Map<String,Object> response = new HashMap<>();
        response.put("status",500);
        response.put("error",String.format("Authorization error!"));
        return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
    }

}
