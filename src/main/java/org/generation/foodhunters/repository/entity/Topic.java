package org.generation.foodhunters.repository.entity;

import org.generation.foodhunters.controller.dto.TopicDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import jakarta.persistence.*;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTopic;             //retrieve product item by ID - has to be an object
    private String name;


    public Topic() {}


    public Topic(TopicDTO topicDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.name = topicDTO.getName();
    }


    public Integer getidTopic()
    {
        return idTopic;
    }


    public void setidTopic( Integer idTopic )
    {
        this.idTopic = idTopic;
    }


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }



    @Override
    public String toString()
    {
        return "Item{" + "idTopic=" + idTopic + ", name='" + name +
                '}';
    }
}

