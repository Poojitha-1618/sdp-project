package com.example.backend.entity;

	import jakarta.persistence.*;
	import java.time.LocalDate;

	@Entity
	public class Registeration {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "student_id", nullable = false)
	    private Student student;

	    @ManyToOne
	    @JoinColumn(name = "course_id", nullable = false)
	    private Course course;

	    private LocalDate registrationDate;

		private LocalDate registerationDate;

	    // Default constructor
	    public Registeration() {
	    }

	    // Parameterized constructor
	    public Registeration(Student student, Course course, LocalDate registerationDate) {
	        this.student = student;
	        this.course = course;
	        this.registerationDate = registerationDate;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Student getStudent() {
	        return student;
	    }

	    public void setStudent(Student student) {
	        this.student = student;
	    }

	    public Course getCourse() {
	        return course;
	    }

	    public void setCourse(Course course) {
	        this.course = course;
	    }

	    public LocalDate getRegisterationDate() {
	        return registrationDate;
	    }

	    public void setRegisterationDate(LocalDate registerationDate) {
	        this.registerationDate = registerationDate;
	    }
	}



