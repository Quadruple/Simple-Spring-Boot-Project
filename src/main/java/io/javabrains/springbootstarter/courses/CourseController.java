package io.javabrains.springbootstarter.courses;


import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired // This is asking for service
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllTopics(@PathVariable String id) {

        return courseService.getAllCourses(id) ;

    }

    /*
    @RequestMapping("/topics/id") // This is the way of request mapping with a variable on the url
    public Course getCourse(String id) {

        return courseService.getCourse(id) ;

    }
    */

    // Below code does the same thing but the @pathVariable notation is missed
    // if the variable on the method is same with the @requestMapping variable there is no need for the notation of @PathVariable
    // This is the recommended way of doing this
    @RequestMapping("/topics/{topicId}/courses/{id}") // This is the way of request mapping with a variable on the url
    public Optional<Course> getCourse(@PathVariable("topicId") String id) {

        return courseService.getCourse(id) ;

    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics/{topicId}/courses") // This is for mapping every post request on topics URL to the method addCourse
    public void addCourse(@RequestBody Course course , @PathVariable String topicId) { // This line gets the course variable to the JSON Object and get it prepared to send

        course.setTopic(new Topic(topicId , "" , ""));
        courseService.addCourse(course) ;

    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId , @PathVariable String id) {

        course.setTopic(new Topic(topicId , "" , ""));
        courseService.updateCourse(course) ;

    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id) {

        courseService.deleteCourse(id) ;

    }

}
