package com.sdacademy.university.repository;

import com.sdacademy.university.model.entity.LecturerEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class LecturerRepository {
    public List<LecturerEntity> getLecturers() {
        return List.of(
                LecturerEntity.builder()
                        .id(1L)
                        .name("Rutenis")
                        .age(33)
                        .salary(new BigDecimal("1000"))
                        .universityId(2L)
                        .build(),
                LecturerEntity.builder()
                        .id(2L)
                        .name("Tomas")
                        .age(38)
                        .salary(new BigDecimal("1500"))
                        .universityId(2L)
                        .build(),
                LecturerEntity.builder()
                        .id(3L)
                        .name("Audrius")
                        .age(41)
                        .salary(new BigDecimal("1800"))
                        .universityId(1L)
                        .build()
        );
    }
}
