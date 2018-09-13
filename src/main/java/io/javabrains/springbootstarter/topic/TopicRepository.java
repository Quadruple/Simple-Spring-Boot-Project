package io.javabrains.springbootstarter.topic;

// Spring already knows that Course is an Entity. Which is going to be saved in the database. So Spring provides methods such as :
// GetAllTopics() , UpdateTopic() , DeleteTopic() ...
// All we need to update the database is just an interface

import org.springframework.data.repository.CrudRepository;

// CrudRepository<Class you are working(Course) , PrimaryKey of the class (String id)>
public interface TopicRepository extends CrudRepository <Topic , String> { // CrudRepository is defined by spring. This repo has all the common methods.



}
