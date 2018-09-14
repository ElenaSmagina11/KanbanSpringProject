package com.myproject.validator;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import com.myproject.dao.KanbanDAO;

import com.myproject.model.KanbanInfo;
 
// @Component: As a Bean.
@Component
public class KanbanInfoValidator implements Validator {
 
    @Autowired
    private KanbanDAO kanbanDAO;
 
    // This Validator support EmployerInfo class.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == KanbanInfo.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        KanbanInfo kanbanInfo = (KanbanInfo) target;
 
        // Check the fields of KanbanInfo class. A NADO LI MNE ETI POLJA PROVERAT??
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cvDate", "NotEmpty.kanbanForm.cvDate");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "interviewDate", "NotEmpty.kanbanForm.interviewDate");
//       
        String userName = kanbanInfo.getUserName();
        String jobName = kanbanInfo.getJobName();
        if (userName != null && userName.length() > 0) {
            if (userName.matches("\\s+")) {
                errors.rejectValue("userName", "Pattern.kanbanForm.userName");
//            } else if(kanbanInfo.isNewKanban()) {
//                Kanban kanban = kanbanDAO.findKanban(userName, jobName);
//                if (kanban != null ) {
//                    errors.rejectValue("userName", "Duplicate.kanabnForm.userName");
//                }
            }
        }
    }
 
}