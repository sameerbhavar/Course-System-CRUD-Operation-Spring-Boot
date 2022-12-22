package com.course.courseRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.courseRest.Exception.CourseException;
import com.course.courseRest.Model.Courses;
import com.course.courseRest.service.CourseService;

@RestController
public class Mycontroller {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String Home() {
		return "In home page";
	}
	
	@GetMapping("/courseList")
	public List<Courses> getCourses() throws CourseException
	{
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Courses> getCourse(@PathVariable String id) throws CourseException{
		Courses course= this.courseService.getCourse(Long.parseLong(id));
		return new ResponseEntity<Courses>(course,HttpStatus.OK);
		
	}
	
	@PostMapping("courses")
	public ResponseEntity<Courses> addCourse(@RequestBody Courses course) throws CourseException{
		Courses c=courseService.addCourse(course);
		return new ResponseEntity<Courses>(c,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCourse")
	public ResponseEntity<Courses> updateCourse(@RequestBody Courses courses) throws CourseException{
		Courses c=courseService.updateCourse(courses);
		return new ResponseEntity<Courses>(c,HttpStatus.ACCEPTED);

	}
	
	@DeleteMapping("/deleteCourse")
	public ResponseEntity<Courses> deleteCourse(@RequestBody Courses courses) throws CourseException{
		Courses c=courseService.deleteCourse(courses);
		return new ResponseEntity<Courses>(c,HttpStatus.OK);
	}
	
	
	
}
