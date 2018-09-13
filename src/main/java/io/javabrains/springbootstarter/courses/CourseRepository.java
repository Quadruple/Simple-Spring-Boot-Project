package io.javabrains.springbootstarter.courses;

// Spring already knows that Course is an Entity. Which is going to be saved in the database. So Spring provides methods such as :
// GetAllTopics() , UpdateTopic() , DeleteTopic() ...
// All we need to update the database is just an interface

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// CrudRepository<Class you are working(Course) , PrimaryKey of the class (String id)>
public interface CourseRepository extends CrudRepository <Course, String> { // CrudRepository is defined by spring. This repo has all the common methods.

    public List<Course> findByTopicId(String topicId) ;

}
