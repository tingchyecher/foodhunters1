package org.generation.foodhunters.controller.dto;

public class TopicDTO {

    private String name;


    public TopicDTO(String name)
    {
        this.name = name;
    }


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }

}

