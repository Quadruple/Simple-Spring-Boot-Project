package io.javabrains.springbootstarter.courses;

import io.javabrains.springbootstarter.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity // This tells spring jpa that this is the data to be saved in the database
public class Course {

    @Id // This tells spring that String id is the primary key needed by the database
    private String id ;
    private String name ;
    private String description ;

    @ManyToOne // This indicates to Spring that there are many Courses under only one Topic. Actual meaning : ManyToOne
    private Topic topic ;

    public Course() {}

    public Course(String id , String name , String description , String topicId) {

        super() ;
        this.id = id ;
        this.name = name ;
        this.description = description ;
        this.topic = new Topic(topicId , "" , "") ;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
