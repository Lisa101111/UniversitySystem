package com.universitysystem.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LecturerEntity {

    private Long id;
    private String name;
    private Integer age;
    private BigDecimal salary;
    private Long universityId;
}
