package org.generation.foodhunters.controller;

import org.generation.foodhunters.service.PostService;
import org.generation.foodhunters.repository.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Value;
import org.generation.foodhunters.component.FileUploadUtil;
import org.generation.foodhunters.controller.dto.PostDTO;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RestController
@RequestMapping("/post")
public class PostController {

    @Value("${image.folder}")
    private String imageFolder;


    private final PostService postService;


    public PostController(@Autowired PostService postService )
    {
        this.postService = postService;
    }


    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Post> getPost()
    {
        return postService.all();
    }

    @CrossOrigin
    @GetMapping( "/{id}" )
    public Post findItemById( @PathVariable Integer id )
    {
        return postService.findById( id );
    }


    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        postService.delete( id );
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="content", required = true) String content,
                       @RequestParam(name="postDate", required = true) String postDate,
                       @RequestParam(name="idTopic", required = true) Integer idTopic,
                       @RequestParam(name="idUsers", required = true) Integer idUsers)
//                     @RequestParam("imagefile") MultipartFile multipartFile) throws IOException
    {

//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());


//productimages, t-shirt_new.jpg, object
//        FileUploadUtil.saveFile(imageFolder, fileName, multipartFile);


//String fullPath = imageFolder + "/" + imageUrl;


        PostDTO postDTO = new PostDTO(content, postDate, idTopic, idUsers);
        postService.save(new Post(postDTO));

    }



}
