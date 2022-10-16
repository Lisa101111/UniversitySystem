package com.universitysystem.validator;

import com.universitysystem.model.entity.LecturerEntity;
import com.universitysystem.model.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LecturerValidator {
    public boolean isValid(LecturerEntity lecturer) {
        if (lecturer.getName() == null) {
            throw new ValidationException();
        }
        if (lecturer.getAge() < 18) {
            throw new ValidationException();
        }
        if (lecturer.getSalary() == null || lecturer.getSalary().compareTo(new BigDecimal(0)) < 0) {
            throw new ValidationException();
        }

        return true;
    }


}
