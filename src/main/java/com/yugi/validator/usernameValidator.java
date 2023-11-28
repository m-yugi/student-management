package com.yugi.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.yugi.DTO.studentDto;

public class usernameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return studentDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentname", "empty.student", "*Please enter a valid name");
	}

}
