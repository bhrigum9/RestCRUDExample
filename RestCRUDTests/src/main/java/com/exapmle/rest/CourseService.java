package com.exapmle.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;

	/**
	 * @return
	 */
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<Course> getCourseByID(int id) {
		return courseRepository.findById(id);
	}

	/**
	 * @param course
	 */
	public void createCourse(Course course) {
		courseRepository.save(course);
	}

	/**
	 * @param courses
	 */
	public void createCourses(List<Course> courses) {
		courseRepository.saveAll(courses);
	}

	public void deleteCourse(int id) {
		courseRepository.deleteById(id);
	}

	public void deleteAllCourse() {
		courseRepository.deleteAllInBatch();
	}

}
