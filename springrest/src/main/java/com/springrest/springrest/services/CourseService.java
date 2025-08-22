package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import com.springrest.springrest.entities.Courses;

public interface CourseService {

	public List<Courses> getCourses();

	public Courses getCourse(long id);

	public Courses addCourse(Courses courses);

	public Courses updateCourse(Courses courses);

	public void deleteCourse(long id);
}
