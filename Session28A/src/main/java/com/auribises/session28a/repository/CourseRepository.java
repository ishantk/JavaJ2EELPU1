package com.auribises.session28a.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auribises.session28a.model.Course;

public interface CourseRepository extends MongoRepository<Course, String>{

	//List<Course> findCoursesContainingTitle(String title);
	//List<Course> findActiveCourses(boolean active);
	
}
