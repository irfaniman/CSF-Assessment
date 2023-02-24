package vttp2022.csf.assessment.server.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;

import vttp2022.csf.assessment.server.models.*;
@Repository
public class RestaurantRepository {

	@Autowired
    private MongoTemplate mongoTemplate;

	public static final String RESTAURANT = "restaurant";

	// TODO Task 2
	// Use this method to retrive a list of cuisines from the restaurant collection
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method

	// db.restaurant.distinct('cuisine')
	public List<String> getCuisines() {
		// Implementation in here
		return mongoTemplate.findDistinct(new Query(), "cuisine", RESTAURANT, String.class);
    }

	// TODO Task 3
	// Use this method to retrive all restaurants for a particular cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHANGE THE METHOD'S NAME
	// Write the Mongo native query above for this method

	// db.restaurant.find({'cuisine': {$in: ['<cuisine_name>']}}, {name:1, _id:0})
	public List<Document> getRestaurantsByCuisine(String cuisine) {
		// Implmementation in here
		Criteria c = Criteria.where("cuisine")
			.in(cuisine);
		Query q = Query.query(c);

		return mongoTemplate.find(q, Document.class, RESTAURANT)
			.stream()
			.toList();

	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	
	//  db.restaurant.find({ name: '<restaurant_name>' })
	public Optional<Restaurant> getRestaurant(String name) {
		// Implementation in here
		 // Create a criteria/predicate
		 Criteria c = Criteria.where("name").is(name);

		 // Query to use the criteria
		 Query q = Query.query(c);
		 
		//  return Optional.of(mongoTemplate.find(q, Restaurant.class, RESTAURANT));
		
	}

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method

	//  
	public void addComment(Comment comment) {
		// Implmementation in here
		
	}
	
	// You may add other methods to this class

}

