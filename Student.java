package com.example.backend.entity;
	import jakarta.persistence.*;
	import java.util.List;

	@Entity
	public class Student {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String studentId; // Unique ID for the student (e.g., roll number)

	    @Column(nullable = false)
	    private String firstName;

	    @Column(nullable = false)
	    private String lastName;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String password; // Ensure to hash passwords in real applications

	    @ManyToMany
	    @JoinTable(
	        name = "student_courses",
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "course_id")
	    )
	    private List<Course> courses; // List of courses the student is enrolled in

	    // Constructors
	    public Student() {
	    }

	    public Student(String studentId, String firstName, String lastName, String email, String password) {
	        this.studentId = studentId;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.password = password;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getStudentId() {
	        return studentId;
	    }

	    public void setStudentId(String studentId) {
	        this.studentId = studentId;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public List<Course> getCourses() {
	        return courses;
	    }

	    public void setCourses(List<Course> courses) {
	        this.courses = courses;
	    }

	    // toString method for debugging
	    @Override
	    public String toString() {
	        return "Student{" +
	                "id=" + id +
	                ", studentId='" + studentId + '\'' +
	                ", firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", email='" + email + '\'' +
	                '}';
	    }
	}



