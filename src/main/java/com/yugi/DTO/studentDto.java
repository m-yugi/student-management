package com.yugi.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class studentDto {

	private long studentId;
	@NotEmpty(message="*this feild should not be empty")
	private String studentname;
	@NotNull(message="*this feild should not be empty")
	private Long studentmobile;
	@NotEmpty(message="*this feild should not be empty")
	private String studentcountry;

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public Long getStudentmobile() {
		return studentmobile;
	}

	public void setStudentmobile(Long studentmoblie) {
		this.studentmobile = studentmoblie;
	}

	public String getStudentcountry() {
		return studentcountry;
	}

	public void setStudentcountry(String studentcountry) {
		this.studentcountry = studentcountry;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
}
