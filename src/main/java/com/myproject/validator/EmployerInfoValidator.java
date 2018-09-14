package com.myproject.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myproject.dao.EmployerDAO;
import com.myproject.entity.Employers;
import com.myproject.model.EmployerInfo;

// @Component: As a Bean.
@Component
public class EmployerInfoValidator implements Validator {

	@Autowired
	private EmployerDAO employerDAO;

	// This Validator support EmployerInfo class.
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == EmployerInfo.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmployerInfo employerInfo = (EmployerInfo) target;

		// Check the fields of EmployerInfo class.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emplName",
				"NotEmpty.employerForm.emplName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emplCity",
				"NotEmpty.employerForm.emplCity");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emplVacancy",
				"NotEmpty.employerForm.emplVacancy");

		String emplName = employerInfo.getEmplName();
		if (emplName != null && emplName.length() > 0) {
			if (emplName.matches("\\s+")) {
			} else if (employerInfo.isNewEmployer()) {
				Employers employers = employerDAO.findEmployer(emplName);
				if (employers != null) {
					errors.rejectValue("emplName",
							"Duplicate.employerForm.emplName");
				}
			}
		}
	}

}