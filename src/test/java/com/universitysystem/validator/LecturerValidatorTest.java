package com.universitysystem.validator;

import com.universitysystem.model.entity.LecturerEntity;
import com.universitysystem.model.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LecturerValidatorTest {
    private LecturerValidator lecturerValidator;

    @BeforeEach
    void init() {
        lecturerValidator = new LecturerValidator();
    }

    @Test
    void isValid() {
        var lecturer = LecturerEntity.builder()
                .name("Test")
                .salary(new BigDecimal("1000"))
                .age(22)
                .build();

        var result = lecturerValidator.isValid(lecturer);

        Assertions.assertTrue(result);
    }

    @Test
    void isValid_invalidAge() {
        var lecturer = LecturerEntity.builder()
                .name("Test")
                .salary(new BigDecimal("1000"))
                .age(17)
                .build();

        assertThrows(ValidationException.class, () -> lecturerValidator.isValid(lecturer));
    }
}
