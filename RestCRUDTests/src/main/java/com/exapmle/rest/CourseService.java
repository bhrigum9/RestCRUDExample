package com.exapmle.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * @return
	 */
	public List<CourseDTO> getAllCourses() {
		return courseRepository.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	public Optional<CourseDTO> getCourseByID(int id) {
		return courseRepository.findById(id);
	}

	/**
	 * @param courseDTO
	 */
	public void createCourse(CourseBO bo) {
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		courseRepository.save(modelMapper.map(bo, CourseDTO.class));
	}

	/**
	 * @param courseDTOs
	 */
	public void createCourses(List<CourseBO> courseBOs) {
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		List<CourseDTO> courseDTOs = new ArrayList<>();
		for (CourseBO courseBO : courseBOs) {
			CourseDTO courseDTO = modelMapper.map(courseBO, CourseDTO.class);
			courseDTOs.add(courseDTO);
		}
		courseRepository.saveAll(courseDTOs);
	}

	/**
	 * @param courseBO
	 * @param id
	 */
	public void updateCourses(CourseBO courseBO, int id) {
		Optional<CourseDTO> courseDto = getCourseByID(id);

		Objects.requireNonNullElse(courseBO.getName(), courseDto.get().getName());
		Objects.requireNonNullElse(courseBO.getDescription(), courseDto.get().getDescription());
		Objects.requireNonNullElse(courseBO.getInstructor(), courseDto.get().getInstructor());
		Objects.requireNonNullElse(courseBO.getCategory(), courseDto.get().getCategory());
		Objects.requireNonNullElse(courseBO.getDuration(), courseDto.get().getDuration());
		Objects.requireNonNullElse(courseBO.getRatings(), courseDto.get().getRatings());

		createCourse(courseBO);
	}

	/**
	 * @param id
	 */
	public void deleteCourse(int id) {
		courseRepository.deleteById(id);
	}

	/**
	 * 
	 */
	public void deleteAllCourse() {
		courseRepository.deleteAllInBatch();
	}

}
