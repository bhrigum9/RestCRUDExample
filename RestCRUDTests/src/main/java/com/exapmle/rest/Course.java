package com.exapmle.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author bhrigu
 *
 */
@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue
	private int id;
	private String courseName;
	private String courseDescription;
	private String courseInstructor;
	private String ratings;
	private int courseLength;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the courseDescription
	 */
	public String getCourseDescription() {
		return courseDescription;
	}

	/**
	 * @param courseDescription the courseDescription to set
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	/**
	 * @return the courseInstructor
	 */
	public String getCourseInstructor() {
		return courseInstructor;
	}

	/**
	 * @param courseInstructor the courseInstructor to set
	 */
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	/**
	 * @return the reviews
	 */
	public String getRatings() {
		return ratings;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setRatings(String reviews) {
		this.ratings = reviews;
	}

	/**
	 * @return the courseLength
	 */
	public int getCourseLength() {
		return courseLength;
	}

	/**
	 * @param courseLength the courseLength to set
	 */
	public void setCourseLength(int courseLength) {
		this.courseLength = courseLength;
	}

}
