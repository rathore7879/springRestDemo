package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;

import exception.ResourceNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	List<Courses> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Courses(1,"Java","Learn Core Java"));
		list.add(new Courses(2,"Java Advance","Learn advance Java"));
		list.add(new Courses(3,"Android App development","Learn app development"));
		list.add(new Courses(4,"Kotlin","Learn Kotlin"));
		list.add(new Courses(5,"sql","Learn sql"));
		list.add(new Courses(6,"Jpa","Learn hibernate"));
	}
	
	@Override
	public List<Courses> getCourses() {

		return courseDao.findAll();
	}

	@Override
	public Courses getCourse(long id) throws ResourceNotFoundException {
		
			return courseDao.findById(id)
						.orElseThrow(()-> new ResourceNotFoundException("Course not found with id: "+id));
		/*
		 * Courses c =null;
		 * 
		 * for(Courses course : list) { if(course.getId() == id ) { c = course; break; }
		 * }
		 * 
		 * return c;
		 */
	}

	@Override
	public Courses addCourse(Courses courses) {
		return courseDao.save(courses);
		/*
		 * list.add(courses); return courses;
		 */
	}

	@Override
	public Courses updateCourse(Courses course) {
		return courseDao.save(course);
		/*
		 * for (Courses c : list) { if(c.getId() == course.getId()) {
		 * c.setDescription(course.getDescription()); c.setTitle(course.getTitle());
		 * break; } } return course;
		 */
	}

	@Override
	public void deleteCourse(long id) {
		Courses entity = courseDao.getOne(id);
		courseDao.delete(entity);
		/*
		 * for (Courses c : list) { if(c.getId() == id) { list.remove(c); break; } }
		 */
		//return "Course Deleted Successfully";
	}

}
