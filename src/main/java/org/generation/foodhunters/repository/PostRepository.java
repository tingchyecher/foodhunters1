package org.generation.foodhunters.repository;

import org.generation.foodhunters.repository.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {

    //Nothing for now bcoz we can just use the methods from the CrudRepository object


    //For more complex system, feature, there might be other methods that I need to addon in the PostRepository
    // interface with the relevant class
    //ArrayList<Item> getProductWithCategory(String categoryName);


}
