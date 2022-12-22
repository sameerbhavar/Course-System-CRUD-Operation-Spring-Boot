package com.course.courseRest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.courseRest.Exception.CourseException;
import com.course.courseRest.Model.Courses;

@Service
public class CourseServiceImpl implements CourseService {

	List<Courses> list;
	
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Courses(1, "Java", "Full Stack Java Course"));
		list.add(new Courses(2, "php", "Full Stack php Course"));
		list.add(new Courses(3, "Spring", "Full Stack Spring Course"));
		list.add(new Courses(4, "Mysql", "Full Stack Mysql Course"));
	}
	
	
	@Override
	public List<Courses> getCourses() throws CourseException {
		// TODO Auto-generated method stub
		return list;
	}


	@Override
	public Courses getCourse(long courseId) throws CourseException {

		Courses c=null;
		for(Courses course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}


	@Override
	public Courses addCourse(Courses course) throws CourseException {
		// TODO Auto-generated method stub
		
		try {
			list.add(course);
			return course;
		} catch (Exception e) {
			// TODO: handle exception
			throw new CourseException("Please Enter Valid Data");
		}
	}
}


