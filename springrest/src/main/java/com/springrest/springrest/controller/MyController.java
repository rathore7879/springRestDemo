package com.springrest.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home(){
		return "This is home page";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Courses> getCourse(@PathVariable String courseId) {
	Courses course = this.courseService.getCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@PostMapping(path="/courses",consumes ="application/json")
	public ResponseEntity<String> addCourse(@RequestBody Courses request) {
		if(request.getTitle() == null || request.getDescription() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course title and description are required");
		} 

		if(request.getTitle() != null && "ANY".equals(request.getDescription())){
			this.courseService.addCourse(request);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully saved course");
		}
		throw new RuntimeException("Internal Server Error occured");
	}
	
	
	@PutMapping(path="/courses",consumes ="application/json")
	public Courses updateCourse(@RequestBody Courses courses) {
		return this.courseService.updateCourse(courses);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			 this.courseService.deleteCourse(Long.parseLong(courseId));
			 return new ResponseEntity(HttpStatus.OK);

		}catch(Exception exe) {
			 return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleGenericError(RuntimeException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}
	

}
