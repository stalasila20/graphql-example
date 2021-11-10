package com.graphql.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.demo.entity.AddressEntity;
import com.graphql.demo.entity.StudentEntity;
import com.graphql.demo.entity.SubjectEntity;
import com.graphql.demo.repository.AddressRepository;
import com.graphql.demo.repository.StudentRepository;
import com.graphql.demo.repository.SubjectRepository;
import com.graphql.demo.request.CreateStudentRequest;
import com.graphql.demo.request.CreateSubjectRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	SubjectRepository subjectRepository;

	public StudentEntity getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}
	
	public StudentEntity createStudent (CreateStudentRequest createStudentRequest) {
		StudentEntity student = new StudentEntity(createStudentRequest);
		
		AddressEntity address = new AddressEntity();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());
		
		address = addressRepository.save(address);
		
		student.setAddress(address);
		student = studentRepository.save(student);
		
		List<SubjectEntity> subjectsList = new ArrayList<SubjectEntity>();
		
		if(createStudentRequest.getSubjectsLearning() != null) {
			for (CreateSubjectRequest createSubjectRequest : 
					createStudentRequest.getSubjectsLearning()) {
				SubjectEntity subject = new SubjectEntity();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);
				
				subjectsList.add(subject);
			}
			
			subjectRepository.saveAll(subjectsList);
			
		}
		
		student.setLearningSubjects(subjectsList);
		
		return student;
	}
}