package org.generation.foodhunters.controller.dto;

import org.generation.foodhunters.service.ItemService;
import org.generation.foodhunters.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/item")
public class ItemController {


    private final ItemService itemService;


    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }


    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }


}
