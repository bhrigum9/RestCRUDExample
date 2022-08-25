package com.exapmle.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.exapmle.exception.CourseServiceException;
import com.exapmle.model.CourseBO;
import com.exapmle.model.CourseDTO;
import com.exapmle.util.Utilitaries;

@Service
public class CourseService {

	@Autowired(required = true)
	CourseRepository courseRepository;
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * @return
	 * @throws CourseServiceException
	 */
	public List<CourseDTO> getAllCourses() throws CourseServiceException {
		return courseRepository.findAll(Sort.by(Sort.Direction.ASC, "instructor"));
	}

	/**
	 * @param id
	 * @return
	 * @throws CourseServiceException
	 */
	public Optional<CourseDTO> getCourseByID(int id) throws CourseServiceException {
		return courseRepository.findById(id);
	}

	/**
	 * @param bo
	 * @throws CourseServiceException
	 */
	public void createCourse(CourseBO bo) throws CourseServiceException {
		Date creationDate = getByCreateDate(bo.getInstructor());
		if (creationDate == null || (Utilitaries.checkDateByMonth(creationDate) > 6)) {
			modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			courseRepository.save(modelMapper.map(bo, CourseDTO.class));
		}
	}

	/**
	 * @param courseBOs
	 * @throws CourseServiceException
	 */
	public void createCourses(List<CourseBO> courseBOs) throws CourseServiceException {
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
	 * @throws CourseServiceException
	 */
	public void updateCourses(CourseBO courseBO, int id) throws CourseServiceException {
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
	 * @throws CourseServiceException
	 */
	public void deleteCourse(int id) throws CourseServiceException {
		courseRepository.deleteById(id);
	}

	/**
	 * @throws CourseServiceException
	 */
	public void deleteAllCourse() throws CourseServiceException {
		courseRepository.deleteAllInBatch();
	}

	/**
	 * @param name
	 * @return
	 * @throws CourseServiceException
	 */
	public Date getByCreateDate(String name) throws CourseServiceException {
		return courseRepository.getByCreateDate(name);
	}

}
