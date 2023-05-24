package org.generation.foodhunters.repository.entity;

import org.generation.foodhunters.controller.dto.PostDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;             //retrieve product item by ID - has to be an object
    private String content;
    private String postDate;
    private Integer idTopic;
    private Integer idUsers;



    public Post() {}


    public Post(PostDTO postDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.content = postDTO.getContent();
        this.postDate = postDTO.getPostDate();
        this.idTopic = postDTO.getIdTopic();
        this.idUsers = postDTO.getIdUsers();

    }


    public Integer getIdPost()
    {
        return idPost;
    }


    public void setIdPost( Integer idPost )
    {
        this.idPost = idPost;
    }


    public String getContent()
    {
        return content;
    }


    public void setContent( String content )
    {
        this.content = content;
    }


    public String getPostDate()
    {
        return postDate;
    }


    public void setPostDate( String postDate )
    {
        this.postDate = postDate;
    }


    public Integer getIdTopic()
    {
        return idTopic;
    }


    public void setIdTopic( Integer idTopic )
    {
        this.idTopic = idTopic;
    }


    public Integer getIdUsers()
    {
        return idUsers;
    }


    public void setIdUsers( Integer idUsers )
    {
        this.idUsers = idUsers;
    }

    @Override
    public String toString()
    {
        return "Post{" + "idPost=" + idPost + ", content='" + content + '\'' + ", postDate='" +
                postDate + '\'' + ", idTopic='"
                + idTopic + '\'' + ",idUsers='" + idUsers + '}';
    }
}

