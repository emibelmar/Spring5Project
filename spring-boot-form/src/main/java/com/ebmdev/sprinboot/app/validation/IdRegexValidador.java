package com.ebmdev.sprinboot.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdRegexValidador implements ConstraintValidator<IdRegex, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.matches("[\\d]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")) {
			return true;
		}
		return false;
	}

}
