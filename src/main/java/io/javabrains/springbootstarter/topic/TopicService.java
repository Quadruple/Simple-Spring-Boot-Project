package io.javabrains.springbootstarter.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // This tells that this is a rest service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository ;

    public List<Topic> getAllTopics() {

        List<Topic> topics = new ArrayList<>() ;
        topicRepository.findAll().forEach(topics::add); // Returns an iterable object full of topics
        return topics ;

    }

    public Optional<Topic> getTopic(String id) {

        return topicRepository.findById(id) ;

    }

    public void addTopic(Topic topic) {

        topicRepository.save(topic) ; // Saving a new topic to the database

    }

    public void updateTopic(String id , Topic topic) {

        topicRepository.save(topic) ; // Save method also provides update if an id that is already in the database is entered

    }

    public void deleteTopic(String id) {

        topicRepository.deleteById(id) ;

    }

}
