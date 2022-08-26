package com.exapmle.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exapmle.model.CourseDTO;

@Repository
public interface CourseRepository extends JpaRepository<CourseDTO, Integer> {

	@Query(value = "select creationDate from CourseDTO where instructor =:instructor order by creationDate")
	public Date getByCreateDate(@Param("instructor") String instructor);
}
