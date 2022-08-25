package com.exapmle.controller;

import java.util.List;
import java.util.Optional;

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

import com.exapmle.exception.CourseDaoException;
import com.exapmle.exception.CourseServiceException;
import com.exapmle.model.CourseBO;
import com.exapmle.model.CourseDTO;
import com.exapmle.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	CourseService courseService;

	@GetMapping("/courses")
	public ResponseEntity<List<CourseDTO>> getAllCourses() throws CourseServiceException, CourseDaoException {

		List<CourseDTO> courseDTOs = courseService.getAllCourses();
		return ResponseEntity.ok().body(courseDTOs);
	}

	@GetMapping("/id")
	public ResponseEntity<Optional<CourseDTO>> getCourseByID(@PathVariable("id") int id)
			throws CourseServiceException, CourseDaoException {

		Optional<CourseDTO> courseDTO = courseService.getCourseByID(id);
		return ResponseEntity.ok().body(courseDTO);
	}

	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody CourseBO courseBO)
			throws CourseServiceException, CourseDaoException {

		courseService.createCourse(courseBO);
		return new ResponseEntity<>("Course created sucessfully !" + courseBO, HttpStatus.CREATED);
	}

	@PostMapping("/courses")
	public ResponseEntity<String> createCourse(@RequestBody List<CourseBO> courseBOs)
			throws CourseServiceException, CourseDaoException {

		courseService.createCourses(courseBOs);
		return new ResponseEntity<>("Courses created sucessfully !", HttpStatus.CREATED);
	}

	@PutMapping("/course/{id}")
	public ResponseEntity<String> updateCourse(@RequestBody CourseBO courseBO, @PathVariable("id") int id)
			throws CourseServiceException, CourseDaoException {

		courseService.updateCourses(courseBO, id);
		return ResponseEntity.ok("Record updated sucessfully for id : " + id);

	}

	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id)
			throws CourseServiceException, CourseDaoException {

		courseService.deleteCourse(id);
		return new ResponseEntity<>("Record deleted for id : " + id + "!", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/courses")
	public ResponseEntity<String> deleteAll() throws CourseServiceException, CourseDaoException {

		courseService.deleteAllCourse();
		return new ResponseEntity<>("All Records deleted sucessfully !", HttpStatus.ACCEPTED);
	}

}
