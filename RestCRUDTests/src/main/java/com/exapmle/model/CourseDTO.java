package com.exapmle.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author bhrigu
 *
 */
@Entity
@Table(name = "courses")
public class CourseDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name is mandatory !")
	private String name;
	@NotBlank(message = "Name of instructor is mandatory !")
	private String instructor;
	@NotNull(message = "Course duration is mandatory to define !")
	private int duration;
	@NotBlank(message = "Course category is mandatory to define !")
	private String category;

	private int ratings;
	private String description;

	@javax.persistence.Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date creationDate = new Date();

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * @return the ratings
	 */
	public int getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "CourseDTO [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (instructor != null ? "instructor=" + instructor + ", " : "") + "ratings=" + ratings + ", duration="
				+ duration + ", " + (category != null ? "category=" + category + ", " : "") + "getId()=" + getId()
				+ ", " + (getName() != null ? "getName()=" + getName() + ", " : "")
				+ (getDescription() != null ? "getDescription()=" + getDescription() + ", " : "")
				+ (getInstructor() != null ? "getInstructor()=" + getInstructor() + ", " : "") + "getRatings()="
				+ getRatings() + ", getDuration()=" + getDuration() + ", "
				+ (getCategory() != null ? "getCategory()=" + getCategory() + ", " : "")
				+ (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + ", "
				+ (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
	}

}
