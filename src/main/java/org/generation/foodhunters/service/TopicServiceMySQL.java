package org.generation.foodhunters.service;

import org.generation.foodhunters.repository.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopicServiceMySQL implements TopicService {

    public TopicServiceMySQL()
    {

    }

    @Override
    public Topic save(Topic item)
    {
        return null;
    }

    @Override
    public void delete(int itemId)
    {

    }

    @Override
    public ArrayList<Topic> all()
    {
        return null;
    }

    @Override
    public Topic findById(int itemId)
    {
        return null;
    }

}
