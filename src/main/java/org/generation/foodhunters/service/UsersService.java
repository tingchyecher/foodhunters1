package org.generation.foodhunters.service;

import org.generation.foodhunters.repository.entity.Users;

import java.util.ArrayList;

public interface UsersService {
    //save method is for 2 purposes - Create new item & Update existing item
    Users save(Users users);


    //Delete item from database - based on item Id
    void delete(int idUsers);


    //Read all item from database
    ArrayList<Users> all();


    //Read an item from database - based on item Id
    Users findById(int idUsers);
}
