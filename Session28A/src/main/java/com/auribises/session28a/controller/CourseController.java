package com.auribises.session28a.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auribises.session28a.model.Course;
import com.auribises.session28a.repository.CourseRepository;

@RestController
@RequestMapping("/api")
public class CourseController {

	// Automatically the Object of CourseRepository will be linked :)
	@Autowired
	CourseRepository courseRepository;

	@GetMapping("/create-course")
	public ResponseEntity<Course> createCourse(){
		try {
			Course cRef = courseRepository.save(new Course("Flutter App Development", "Cross Platform App Development", "John", 2, true));
			// JSON Response for COURSE attributes
			return new ResponseEntity<Course>(cRef, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add-course")
	public ResponseEntity<Course> addCourse(@RequestParam String title, @RequestParam String description, @RequestParam String instructor, @RequestParam int duration){
		try {
			Course cRef = courseRepository.save(new Course(title, description, instructor, duration, true));
			// JSON Response for COURSE attributes
			return new ResponseEntity<Course>(cRef, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> listCourses(@RequestParam(required = false, defaultValue = "") String title){
		try {
			
			List<Course> courses = new ArrayList<Course>();
			
			if(title.isEmpty()) {
				courseRepository.findAll().forEach(courses::add);
			}else {
				//courseRepository.findCoursesContainingTitle(title).forEach(courses::add);
			}
			
			if(courses.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(courses, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> findCourseByID(@PathVariable("id") String id){
		try {
			Optional<Course> course = courseRepository.findById(id);
			
			if(course.isPresent()) {
				return new ResponseEntity<Course>(course.get(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/update-course/{id}")
	public ResponseEntity<Course> updateCourseByID(@PathVariable("id") String id, @RequestParam String title, @RequestParam String description, @RequestParam String instructor, @RequestParam int duration){
		try {
			Optional<Course> course = courseRepository.findById(id);
			
			if(course.isPresent()) {
				
				Course courseToBeUpdated = course.get();
				courseToBeUpdated.setTitle(title);
				courseToBeUpdated.setDescription(description);
				courseToBeUpdated.setInstructor(instructor);
				courseToBeUpdated.setDuration(duration);
				
				Course cRef = courseRepository.save(courseToBeUpdated);
				
				return new ResponseEntity<Course>(cRef, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/delete-course/{id}")
	public ResponseEntity<HttpStatus> deleteCourseByID(@PathVariable("id") String id){
		try {
				courseRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
				
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
