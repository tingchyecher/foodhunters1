package org.generation.foodhunters.service;

import org.generation.foodhunters.repository.TopicRepository;
import org.generation.foodhunters.repository.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class TopicServiceMySQL implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceMySQL(@Autowired TopicRepository topicRepository)
    {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic save(Topic item)
    {
        return topicRepository.save(item);
    }

    @Override
    public void delete(int idTopic)
    {
        topicRepository.deleteById(idTopic);
    }

    @Override
    public ArrayList<Topic> all()
    {
        ArrayList<Topic> result = new ArrayList<>();
        topicRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Topic findById(int idTopic)
    {
        Optional<Topic> topic = topicRepository.findById(idTopic);
        return topic.get();
    }

}
