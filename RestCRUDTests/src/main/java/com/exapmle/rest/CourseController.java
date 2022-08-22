package com.exapmle.rest;

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

@RestController
public class CourseController {
	@Autowired
	CourseService courseService;

	@GetMapping("/courses")
	public ResponseEntity<List<CourseDTO>> getAllCourses() {
		try {
			List<CourseDTO> courseDTOs = courseService.getAllCourses();
			return ResponseEntity.ok().body(courseDTOs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/id")
	public ResponseEntity<Optional<CourseDTO>> getCourseByID(@PathVariable("id") int id) {

		try {
			Optional<CourseDTO> courseDTO = courseService.getCourseByID(id);
			return ResponseEntity.ok().body(courseDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody CourseBO courseBO) {
		courseService.createCourse(courseBO);
		return new ResponseEntity<>("Course created sucessfully !" + courseBO, HttpStatus.CREATED);
	}

	@PostMapping("/courses")
	public ResponseEntity<String> createCourse(@RequestBody List<CourseBO> courseBOs) {
		try {
			courseService.createCourses(courseBOs);
			return new ResponseEntity<>("Courses created sucessfully !", HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("CourseDTO creation list failed to insert records !", HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("/course/{id}")
	public ResponseEntity<String> updateCourse(@RequestBody CourseBO courseBO, @PathVariable("id") int id) {
		try {
			courseService.updateCourses(courseBO, id);
			return ResponseEntity.ok("Record updated sucessfully for id : " + id);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			return new ResponseEntity<>("Cannot update Record for id : " + id, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		try {
			courseService.deleteCourse(id);
			return new ResponseEntity<>("Record deleted for id : " + id + "!", HttpStatus.ACCEPTED);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Record not found for id : " + id, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/courses")
	public ResponseEntity<String> deleteAll() {
		try {
			courseService.deleteAllCourse();
			return new ResponseEntity<>("All Records deleted sucessfully !", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Failed to delete records", HttpStatus.NOT_FOUND);
		}
	}

}
