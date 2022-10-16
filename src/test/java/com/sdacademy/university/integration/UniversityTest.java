package com.sdacademy.university.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sdacademy.university.model.entity.UniversityEntity;

import com.sdacademy.university.repository.UniversityRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class UniversityTest extends AbstractIntegration {

    @MockBean
    private UniversityRepository mockedUniversityRepository;

    @Test
    void getAllUniversities() throws Exception {
        List<UniversityEntity> universities = List.of(
                UniversityEntity.builder()
                        .code("TU")
                        .title("Test University")
                        .build()
        );
        when(mockedUniversityRepository.getUniversities()).thenReturn(universities);

        var result = sendGet("/api/universities", new TypeReference<List<UniversityEntity>>() {
        });

        assertEquals(universities.size(), result.size());
        for (int i = 0; i < universities.size(); i++) {
            assertEquals(universities.get(i), result.get(i));
        }
    }
}