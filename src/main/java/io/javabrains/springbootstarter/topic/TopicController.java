package io.javabrains.springbootstarter.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired // This is asking for service
    private TopicService topicService ;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {

        return topicService.getAllTopics() ;

    }

    /*
    @RequestMapping("/topics/id") // This is the way of request mapping with a variable on the url
    public Course getCourse(String id) {

        return topicService.getCourse(id) ;

    }
    */

    // Below code does the same thing but the @pathVariable notation is missed
    // if the variable on the method is same with the @requestMapping variable there is no need for the notation of @PathVariable
    // This is the recommended way of doing this
    @RequestMapping("/topics/{foo}") // This is the way of request mapping with a variable on the url
    public Optional<Topic> getTopic(@PathVariable("foo") String id) {

        return topicService.getTopic(id) ;

    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics") // This is for mapping every post request on topics URL to the method addCourse
    public void addTopic(@RequestBody Topic topic) { // This line gets the topic variable to the JSON Object and get it prepared to send

        topicService.addTopic(topic) ;

    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic , @PathVariable String id) {

        topicService.updateTopic(id , topic) ;

    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {

        topicService.deleteTopic(id) ;

    }

}
