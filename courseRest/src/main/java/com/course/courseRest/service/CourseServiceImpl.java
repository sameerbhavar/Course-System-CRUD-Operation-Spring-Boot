package com.course.courseRest.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.courseRest.Dao.CourseDao;
import com.course.courseRest.Exception.CourseException;
import com.course.courseRest.Model.Courses;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired	
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
		
	}
	
	
	@Override
	public List<Courses> getCourses() throws CourseException {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}


	@Override
	public Courses getCourse(long courseId) throws CourseException {
		
		Optional<Courses> entity=courseDao.findById(courseId);
		if(entity.isPresent()) {
			return entity.get();
		}else {
			throw new CourseException("Course Not Found With this id"+courseId);
		}
	}


	@Override
	public Courses addCourse(Courses course) throws CourseException {
		// TODO Auto-generated method stub
		if(course!=null) {
			courseDao.save(course);
			return course;	
		}else {
			throw new CourseException("Enter Valid Course Details"+course.getId());
		}
	}


	@Override
	public Courses updateCourse(Courses course) throws CourseException {
		// TODO Auto-generated method stub
		Optional<Courses> entity=courseDao.findById(course.getId());
		if(entity.isPresent()) {
			return courseDao.save(course);
		}else {
			throw new CourseException("Course Not Found With this id"+course.getId());
		}
	}


	@Override
	public Courses deleteCourse(Courses courses) throws CourseException {
		// TODO Auto-generated method stub
		Optional<Courses> entity=courseDao.findById(courses.getId());
		if(entity.isPresent()) {
			courseDao.delete(courses);
			return courses;
		}else {
			throw new CourseException("Course Not Found With this id"+courses.getId());
		}
	}



}


