package net.javaguides.springboot.model;
import javax.persistence.*;
import net.javaguides.springboot.model.User;
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student; // The student who made the request

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course; // The ID of the course for which access is requested

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    
}