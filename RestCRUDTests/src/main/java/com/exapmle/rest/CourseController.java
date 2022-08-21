package com.exapmle.rest;

import java.util.List;
import java.util.Objects;
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
	public ResponseEntity<List<Course>> getAllCourses() {
		try {
			List<Course> courses = courseService.getAllCourses();
			return ResponseEntity.ok().body(courses);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/id")
	public ResponseEntity<Optional<Course>> getCourseByID(@PathVariable("id") int id) {

		try {
			Optional<Course> course = courseService.getCourseByID(id);
			return ResponseEntity.ok().body(course);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
		try {
			courseService.createCourse(course);
			return new ResponseEntity<>("Course created sucessfully !", HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Course creation failed to insert record !", HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/courses")
	public ResponseEntity<String> createCourse(@RequestBody List<Course> courses) {
		try {
			courseService.createCourses(courses);
			return new ResponseEntity<>("Courses created sucessfully !", HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Course creation list failed to insert records !", HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("/course/{id}")
	public ResponseEntity<String> updateCourse(@RequestBody Optional<Course> courseBO, @PathVariable("id") int id) {
		try {
			Optional<Course> course = courseService.getCourseByID(id);
			if (Optional.ofNullable(course) != null) {
				course.get()
						.setCourseName(Objects.nonNull(courseBO.get().getCourseName()) ? courseBO.get().getCourseName()
								: course.get().getCourseName());
				course.get()
						.setCourseInstructor(Objects.nonNull(courseBO.get().getCourseInstructor())
								? courseBO.get().getCourseInstructor()
								: course.get().getCourseInstructor());
				course.get()
						.setCourseDescription(Objects.nonNull(courseBO.get().getCourseDescription())
								? courseBO.get().getCourseDescription()
								: course.get().getCourseDescription());
				course.get()
						.setCourseLength(!Optional.ofNullable(courseBO.get().getCourseLength()).get().equals(0)
								? courseBO.get().getCourseLength()
								: course.get().getCourseLength());

				course.get().setRatings(Objects.nonNull(courseBO.get().getRatings()) ? courseBO.get().getRatings()
						: course.get().getRatings());
			}
			courseService.createCourse(course.get());
			return ResponseEntity.ok("Record updated sucessfully for id : " + id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
