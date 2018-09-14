package com.myproject.validator;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myproject.dao.DeveloperDAO;
import com.myproject.entity.Developers;
import com.myproject.model.DeveloperInfo;
 
// @Component: As a Bean.
@Component
public class DeveloperInfoValidator implements Validator {
 
    @Autowired
    private DeveloperDAO developerDAO;
 
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == DeveloperInfo.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        DeveloperInfo developerInfo = (DeveloperInfo) target;
 
        // Check the fields of EmployerInfo class.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "devName", "NotEmpty.developerForm.devName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "devCity", "NotEmpty.developerForm.devCity");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "devJob", "NotEmpty.developerForm.devJob");
 
        String devName= developerInfo.getDevName();
        if (devName != null && devName.length() > 0) {
            if (devName.matches("\\s+")) {
            } else if(developerInfo.isNewDeveloper()) {
                Developers developer = developerDAO.findDeveloper(devName);
                if (developer != null) {
                    errors.rejectValue("devName", "Duplicate.developerForm.devName");
                }
            }
        }
    }
 
}