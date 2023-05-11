package org.generation.foodhunters.service;

import org.generation.foodhunters.repository.PostRepository;
import org.generation.foodhunters.repository.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceMySQL implements PostService{

    private final PostRepository postRepository;

    public PostServiceMySQL(@Autowired PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post)
    {
        return postRepository.save(post);
    }


    @Override
    public void delete(int idPost)
    {
    postRepository.deleteById(idPost);

    }


    @Override
    public List<Post> all()
    {
        ArrayList<Post> result = new ArrayList<>();
        postRepository.findAll().forEach(result::add);
        return result;
    }


    @Override
    public Post findById(int idPost)
    {
        Optional<Post> post = postRepository.findById(idPost);
        Post itemResponse = post.get();
        return itemResponse;
    }

}
