package org.generation.foodhunters.controller;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.generation.foodhunters.component.FileUploadUtil;
import org.generation.foodhunters.controller.dto.UsersDTO;
import org.generation.foodhunters.repository.entity.Users;
import org.generation.foodhunters.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Value("${image.folder}")
    private String imageFolder;

    private final UsersService usersService;

    //Dependency Injection of the itemService object so that the Controller can call any methods
    //in the ItemServiceMySQL class
    public UsersController(@Autowired UsersService usersService )
    {
        this.usersService = usersService;
    }

    //1) AOI endpoint - to be able to return all products to the front-en
    //Frontend will issue a GET http request
    //Not in a valid domain ( e.g. tp.edu.sg, generation.org)
    //localhost is NOT a valid domain



    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Users> getItems()
    {
//        To display images from local folder
//        for (Users image: usersService.all())
//        {
//            //productimages/t-shirt1.jpg
//            String setURL = imageFolder + "/" + image.getProfilePic();
//            image.setProfilePic(setURL);
//        }

        //To display images from the Server Container
        String connectStr2 = "DefaultEndpointsProtocol=https;AccountName=productimagesfoodhunters;AccountKey=tg11RSVkF7ESwHMmrkmSSE4B9XI1uKWE0OuGQy+67yOS12MYzGdZBFPh+arQCrZCFvH+NR9vETf8+AStXW9o3Q==;EndpointSuffix=core.windows.net";
        //System.out.println("Connect String: " + connectStr2);
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr2).buildClient();
        String containerName = "prodimage";
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        //URL orpath of the azure storage container
        BlobClient blobClient = containerClient.getBlobClient(usersService.all().get(0).getProfilePic());


        //Loop through the ArrayList of itemService.all() and append the Blob url to the imageUrl
        for (Users image: usersService.all())
        {

            //path: productimagesspring/prodimage/t-shirt_new.jpg
            String setURL = blobClient.getAccountUrl() + "/" + containerName + "/" + image.getProfilePic();
            image.setProfilePic(setURL);
        }

        //return in the Controller represents a response to the Client
        return usersService.all();
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="userName", required = true) String userName,
                       @RequestParam(name="email", required = true) String email,
                       @RequestParam(name="profilePic", required = true) String profilePic,
                       @RequestParam("imagefile")
                        MultipartFile multipartFile) throws
            IOException
        {

            //t-shirt_new.jpg
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        //productimages , t-shirt_new.jpg, object
        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);

        //String fullPath = imageFolder + "/" + imageUrl;

        UsersDTO usersDTO = new UsersDTO(userName, email, profilePic);
        usersService.save(new Users(usersDTO));
    }

//    The id value will send from the front-end through the API parameter
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




