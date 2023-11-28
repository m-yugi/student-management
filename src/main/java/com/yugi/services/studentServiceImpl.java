package com.yugi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yugi.DAO.studentDao;
import com.yugi.DTO.studentDto;
import com.yugi.hibernateEntity.students;

@Service
public class studentServiceImpl implements studentService {
	@Autowired
	private studentDao student;

	private students dtoToDbmapping(studentDto student) {
		students studentinfo = new students();
		studentinfo.setName(student.getStudentname());
		studentinfo.setMoblie(student.getStudentmobile());
		studentinfo.setCountry(student.getStudentcountry());
		return studentinfo;
	}

	private studentDto dbToDtoMapping(students student) {
		studentDto studentdata = new studentDto();
		studentdata.setStudentname(student.getName());
		studentdata.setStudentmobile(student.getMoblie());
		studentdata.setStudentcountry(student.getCountry());
		return studentdata;
	}

	@Override
	public List<students> getstudentList() {
		return student.getstudentList();
	}

	@Override
	public studentDto getStudentData(int id) {
		return dbToDtoMapping(student.getStudent(id));
	}

	@Override
	public void saveStudent(studentDto studentinfo) {

		student.saveStudent(dtoToDbmapping(studentinfo));
	}

	@Override
	public void updateStudent(int userid, studentDto studentinfo) {
		students studentdata = dtoToDbmapping(studentinfo);
		studentdata.setId(userid);
		student.updateStudent(studentdata);
	}

	public void deleteStudent(int userid) {
		student.deleteStudent(student.getStudent(userid));
	}

	public boolean isPresentInDB(String studentname) {
		return student.isPresentInDB(studentname);
	}
}
