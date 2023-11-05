package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int year;
    private int semester;
    public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	@Column(name = "course_name")
	private String courseName;
	
    private String lecture;
    private String practical;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getLecture() {
		return lecture;
	}
	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	public String getPractical() {
		return practical;
	}
	public void setPractical(String practical) {
		this.practical = practical;
	}
	public String getSkilling() {
		return skilling;
	}
	public void setSkilling(String skilling) {
		this.skilling = skilling;
	}
	private String skilling;
	
	 private int lectureCapacity;
	    private int practicalCapacity;
	    private int skillingCapacity;
		public int getLectureCapacity() {
			return lectureCapacity;
		}
		public void setLectureCapacity(int lectureCapacity) {
			this.lectureCapacity = lectureCapacity;
		}
		public int getPracticalCapacity() {
			return practicalCapacity;
		}
		public void setPracticalCapacity(int practicalCapacity) {
			this.practicalCapacity = practicalCapacity;
		}
		public int getSkillingCapacity() {
			return skillingCapacity;
		}
		public void setSkillingCapacity(int skillingCapacity) {
			this.skillingCapacity = skillingCapacity;
		}
	
}
