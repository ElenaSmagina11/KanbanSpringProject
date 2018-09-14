package com.myproject.validator;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myproject.dao.AccountDAO;
import com.myproject.entity.Account;
import com.myproject.model.AccountInfo;
 
// @Component: As a Bean.
@Component
public class AccountInfoValidator implements Validator {
 
    @Autowired
    private AccountDAO accountDAO;
 
    // This Validator support EmployerInfo class.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == AccountInfo.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        AccountInfo accountInfo = (AccountInfo) target;
 
        // Check the fields of EmployerInfo class.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.accountForm.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.accountForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userRole", "NotEmpty.accountForm.userRole");
 
        String userName= accountInfo.getUserName();
        if (userName != null && userName.length() > 0) {
            if (userName.matches("\\s+")) {
            } else if(accountInfo.isNewAccount()) {
                Account account = accountDAO.findAccount(userName);
                if (account != null) {
                    errors.rejectValue("userName", "Duplicate.accountForm.userName");
                }
            }
        }
    }
 
}