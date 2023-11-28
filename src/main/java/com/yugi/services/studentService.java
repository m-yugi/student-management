package com.yugi.services;

import java.util.List;

import com.yugi.DTO.studentDto;
import com.yugi.hibernateEntity.students;

public interface studentService {

	public List<students> getstudentList();

	public void saveStudent(studentDto studentinfo);

	public void updateStudent(int useid, studentDto student);

	public studentDto getStudentData(int id);

	public void deleteStudent(int userid);

	public boolean isPresentInDB(String studentname);
}
