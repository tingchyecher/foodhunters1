package org.generation.foodhunters.service;

import org.generation.foodhunters.repository.entity.UsersRepository;
import org.generation.foodhunters.repository.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class UsersServiceMySQL implements UsersService {
    private final UsersRepository userRepository;


    //Dependency Injection of another class object to this class object can be done with
    // @Autowired annotation
    public UsersServiceMySQL(@Autowired UsersRepository userRepository) { this.userRepository = userRepository; }


    @Override
    public Users save(Users users)
    {
        //Since we have done the dependency injection of the itemRepository, therefore now we
        //can call any methods from the CRUDRepository Class
        return this.userRepository.save(users);
    }


    @Override
    public void delete(int idUsers)
    {
        this.userRepository.deleteById(idUsers);


    }


    @Override
    public ArrayList<Users> all()
    {
        //1) @Query class provide by SpringBoot : select * from item
        //2) Repository class provided by SpringBoot : we o not need to write a single query
        ArrayList<Users> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }


    @Override
    public Users findById(int idUsers){
        //Optional is list that accept either a null (empty), or with item
        Optional<Users> users = userRepository.findById(idUsers);
        return users.get();
    }
}
