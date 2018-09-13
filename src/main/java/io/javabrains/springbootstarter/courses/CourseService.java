package io.javabrains.springbootstarter.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // This tells that this is a rest service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String id) {

        List<Course> courses = new ArrayList<>() ;
        courseRepository.findAll().forEach(courses::add); // Returns an iterable object full of courses
        return courses;

    }

    public Optional<Course> getCourse(String id) {

        return courseRepository.findById(id) ;

    }

    public void addCourse(Course course) {

        courseRepository.save(course) ; // Saving a new course to the database

    }

    public void updateCourse(Course course) {

        courseRepository.save(course) ; // Save method also provides update if an id that is already in the database is entered

    }

    public void deleteCourse(String id) {

        courseRepository.deleteById(id) ;

    }

}
