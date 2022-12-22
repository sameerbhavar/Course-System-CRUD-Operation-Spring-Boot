package com.course.courseRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Courses getCourse(@PathVariable String id) throws CourseException{
		return this.courseService.getCourse(Long.parseLong(id));
		
	}
	
	@PostMapping("courses")
	public Courses addCourse(@RequestBody Courses course) throws CourseException{
		return this.courseService.addCourse(course);
	}
	
	
	
}
