package org.generation.foodhunters.service;

import org.generation.foodhunters.repository.entity.Post;


import java.util.ArrayList;
import java.util.List;

public interface PostService {

    //save method is for 2 purposes - Create new item & Update existing item
    Post save(Post post);


    //Delete item from database - based on item Id
    void delete(int idPost);


    //Read all item from database
    List<Post> all();


    //Read an item from database - based on item Id
    Post findById(int idPost);

}
