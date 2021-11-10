package com.graphql.demo.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.demo.entity.StudentEntity;
import com.graphql.demo.entity.SubjectEntity;
import com.graphql.demo.enums.SubjectNameFilter;
import com.graphql.demo.response.StudentResponse;
import com.graphql.demo.response.SubjectResponse;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

	public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse,
			SubjectNameFilter subjectNameFilter) {

		List<SubjectResponse> learningSubjects = new ArrayList<>();
		StudentEntity student = studentResponse.getStudent();

		if (student.getLearningSubjects() != null) {
			learningSubjects = new ArrayList<SubjectResponse>();
			for (SubjectEntity subject : student.getLearningSubjects()) {
				if (subjectNameFilter.name().equalsIgnoreCase("All")) {
					learningSubjects.add(new SubjectResponse(subject));
				} else if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
					learningSubjects.add(new SubjectResponse(subject));
				}
			}
		}

		return learningSubjects;
	}

	public String getFullName(StudentResponse studentResponse) {
		return studentResponse.getFirstName() + " " + studentResponse.getLastName();
	}
}