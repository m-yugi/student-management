package com.yugi.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.yugi.DTO.studentDto;

public class countryValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return studentDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentcountry", "empty.country","*please enter a valid country");
	}

}
