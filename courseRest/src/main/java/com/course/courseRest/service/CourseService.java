package com.course.courseRest.service;

import java.util.List;

import com.course.courseRest.Exception.CourseException;
import com.course.courseRest.Model.Courses;

public interface CourseService {
	
	public List<Courses> getCourses() throws CourseException;
	
	public Courses getCourse(long courseId) throws CourseException;
	
	public Courses addCourse(Courses course) throws CourseException;
	
	public Courses updateCourse(Courses courses) throws CourseException;
	
	public Courses deleteCourse(Courses courses) throws CourseException;

}
