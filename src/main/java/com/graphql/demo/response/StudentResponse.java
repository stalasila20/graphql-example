package com.graphql.demo.response;

import java.util.List;

import com.graphql.demo.entity.StudentEntity;

public class StudentResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	private String fullName;
	private List<SubjectResponse> learningSubjects;
	private StudentEntity student;

	public StudentResponse() {

	}

	public StudentResponse(StudentEntity student) {
		this.student = student;
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();

		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();

//		if (student.getLearningSubjects() != null) {
//			learningSubjects = new ArrayList<SubjectResponse>();
//			for (SubjectEntity subject : student.getLearningSubjects()) {
//				learningSubjects.add(new SubjectResponse(subject));
//			}
//		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<SubjectResponse> getLearningSubjects() {
		return learningSubjects;
	}

	public void setLearningSubjects(List<SubjectResponse> learningSubjects) {
		this.learningSubjects = learningSubjects;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}