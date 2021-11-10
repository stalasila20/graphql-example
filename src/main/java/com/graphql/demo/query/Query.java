package com.graphql.demo.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.demo.request.SampleRequest;
import com.graphql.demo.response.StudentResponse;
import com.graphql.demo.service.StudentService;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	StudentService studentService;

	public String firstQuery() {
		return "First Query";
	}

	public String secondQuery() {
		return "Second Query";
	}

	public String getFullName(String firstName, String lastName) {
		return "First Name: " + firstName + " - Last Name: " + lastName;
	}

	public String getDetailsFromRequest(SampleRequest sampleRequest) {
		return sampleRequest.getFirstName() + " " + sampleRequest.getLastName() + " " + sampleRequest.getId();
	}

	public StudentResponse getStudents(Long id) {
		return new StudentResponse(studentService.getStudentById(id));
	}
}
