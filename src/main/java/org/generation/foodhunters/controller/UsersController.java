package org.generation.foodhunters.controller;

import org.generation.foodhunters.repository.entity.Users;
import org.generation.foodhunters.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class UsersController {

    @Value("${image.folder}")
    private String imageFolder;

    private final UsersService usersService;

    //Dependency Injection of the itemService object so that the Controller can call any methods
    //in the ItemServiceMySQL class
    public UsersController( @Autowired UsersService usersService )
    {
        this.usersService = usersService;
    }

    //1) AOI endpoint - to be able to return all products to the front-en
    //Frontend will issue a GET http request
    //Not in a valid domain ( e.g. tp.edu.sg, generation.org)
    //localhost is NOT a valid domain



//    @CrossOrigin
//    @GetMapping( "/all" )
//    public Iterable<Users> getItems()
//    {
//        //To display images from local folder
//        for (Item image: itemService.all())
//        {
//            //productimages/t-shirt1.jpg
//            String setURL = imageFolder + "/" + image.getImageUrl();
//            image.setImageUrl(setURL);
//        }

//        //To display images from the Server Container
//        String connectStr2 = "DefaultEndpointsProtocol=https;AccountName=hizamiproductimagespring;AccountKey=4FZSN0un/Gpa81O0SvBr0vT9WB72G+5ev3584lXef181aOvyREoL/il1l2jIZkQNWqwLGZXkQNFj+AStUvB/pw==;EndpointSuffix=core.windows.net";
//        //System.out.println("Connect String: " + connectStr2);
//        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr2).buildClient();
//        String containerName = "prodimage";
//        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
//
//        //URL orpath of the azure storage container
//        BlobClient blobClient = containerClient.getBlobClient(itemService.all().get(0).getImageUrl());
//
//
//        //Loop through the ArrayList of itemService.all() and append the Blob url to the imageUrl
//        for (Item image: itemService.all())
//        {
//
//            //path: productimagesspring/prodimage/t-shirt_new.jpg
//            String setURL = blobClient.getAccountUrl() + "/" + containerName + "/" + image.getImageUrl();
//            image.setImageUrl(setURL);
//
//
//        }
//
//
//
//        //return in the Controller represents a response to the Client
//        return itemService.all();
//    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="userName", required = true) String userName,
                       @RequestParam(name="email", required = true) String email,
                       @RequestParam(name="profilePic", required = true) String profilePic){


//        //t-shirt_new.jpg
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//
//        //productimages , t-shirt_new.jpg, object
//        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);
//
//        //String fullPath = imageFolder + "/" + imageUrl;
//
//        ItemDTO itemDto = new ItemDTO(name, description, imageUrl, style, price);
//        itemService.save(new Item(itemDto));
    }

    //The id value will send from the front-end through the API parameter
    @CrossOrigin
    @GetMapping( "/{id}" )
    public Users findUsersById( @PathVariable Integer idUsers )
    {
        return usersService.findById( idUsers );
    }

    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        usersService.delete( id );
    }
}




