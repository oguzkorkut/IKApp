package iptalcom.okorkut.ik.authentication.validator;
//package com.okorkut.ik.authentication.validator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//import com.okorkut.ik.dto.UserDto;
//import com.okorkut.ik.service.UserService;
//
//@Component
//public class UserValidator implements Validator {
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return UserDto.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
////        UserDto user = (UserDto) o;
//
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
////        if (user.getEmail().length() < 6 || user.getEmail().length() > 32) {
////            errors.rejectValue("username", "Size.userForm.username");
////        }
////        if (userService.findByUsername(user.getEmail()) != null) {
////            errors.rejectValue("username", "Duplicate.userForm.username");
////        }
////
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
////        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
////            errors.rejectValue("password", "Size.userForm.password");
////        }
////
////        if (!user.getPasswordConfirm().equals(user.getPassword())) {
////            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
////        }
//    }
//}
