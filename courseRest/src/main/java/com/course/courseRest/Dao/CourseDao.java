package com.course.courseRest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.courseRest.Model.Courses;

public interface CourseDao extends JpaRepository<Courses,Long> {

}
