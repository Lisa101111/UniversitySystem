package com.sdacademy.university.model.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityEntity {
    private Long id;

    private String code;

    private String title;
    private List<LecturerEntity> lecturers;

    protected boolean canEqual(final Object other) {
        return other instanceof UniversityEntity;
    }

}
