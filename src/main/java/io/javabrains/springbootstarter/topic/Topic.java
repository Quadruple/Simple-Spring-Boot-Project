package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // This tells spring jpa that this is the data to be saved in the database
public class Topic {

    @Id // This tells spring that String id is the primary key needed by the database
    private String id ;
    private String name ;
    private String description ;

    public Topic() {}

    public Topic(String id , String name , String description) {

        super() ;
        this.id = id ;
        this.name = name ;
        this.description = description ;

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
}
