package com.yugi.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.yugi.DTO.studentDto;

public class mobileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return studentDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Long mobile = ((studentDto) target).getStudentmobile();
		int length=Long.toString(mobile).length();
		if(length<10 || length>10) {
			errors.rejectValue("studentmobile","mobile.lesslength","*mobile number should me 10 digit long");
		}
	}

}
