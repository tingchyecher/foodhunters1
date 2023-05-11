package org.generation.foodhunters.service;

import org.generation.foodhunters.repository.entity.Topic;

import java.util.ArrayList;

public interface TopicService {

    //save method is for 2 purposes - Create new item & Update existing item
    Topic save(Topic topic);


    //Delete item from database - based on item Id
    void delete(int topicId);


    //Read all item from database
    ArrayList<Topic> all();


    //Read an item from database - based on item Id
    Topic findById(int topicId);
}

