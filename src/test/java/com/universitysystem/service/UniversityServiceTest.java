package com.universitysystem.service;
import com.universitysystem.model.entity.LecturerEntity;
import com.universitysystem.model.entity.UniversityEntity;
import com.universitysystem.repository.LecturerRepository;
import com.universitysystem.repository.UniversityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UniversityServiceTest {
    private LecturerRepository mockedLecturerRepository;
    private UniversityRepository mockedUniversityRepository;
    private UniversityService universityService;

    @BeforeEach
    void init() {
        mockedLecturerRepository = mock(LecturerRepository.class);
        mockedUniversityRepository = mock(UniversityRepository.class);
        universityService = new UniversityService(mockedLecturerRepository, mockedUniversityRepository);
    }

    @Test
    void getUniversities(){

        var universities = generateUniversities();
        when(mockedUniversityRepository.getUniversities()).thenReturn(universities);

        var result = universityService.getUniversities();

        assertEquals(universities, result);

        //Prepare
       /* List<UniversityEntity> universities = List.of(
                UniversityEntity.builder()
                        .code("TU")
                        .title("Test University")
                        .build()
        );
        var mockedUniversityRepository = mock(UniversityRepository.class);
        var universityService = new UniversityService(mockedLecturerRepository, mockedUniversityRepository);

        when(mockedUniversityRepository.getUniversities()).thenReturn(universities);

        //Execute

        var result = universityService.getUniversities();

        //Verify

        assertEquals(universities, result);*/
    }

    @Test

    void getUniversitiesWithLecturers(){

        var universities = generateUniversities();
        var lecturers = generateLecturers();
        // Define that mocked repos should return that data
        when(mockedUniversityRepository.getUniversities()).thenReturn(universities);
        when(mockedLecturerRepository.getLecturers()).thenReturn(lecturers);


        // Execute - call service method
        var result = universityService.getUniversitiesWithLecturers();

        // Assert - verify the result
        assertEquals(universities.size(), result.size());

        result.forEach(university -> university.getLecturers().forEach(lecturer -> assertEquals(university.getId(), lecturer.getUniversityId())));

    }

    private List<UniversityEntity> generateUniversities() {
        return List.of(
                UniversityEntity.builder()
                        .id(1L)
                        .code("TU")
                        .title("Test University")
                        .build(),
                UniversityEntity.builder()
                        .id(2L)
                        .code("TU2")
                        .title("Test University 2")
                        .build()
        );
    }

    private List<LecturerEntity> generateLecturers() {
        return List.of(
                LecturerEntity.builder()
                        .id(1L)
                        .name("Test")
                        .salary(new BigDecimal("1000"))
                        .age(35)
                        .universityId(1L)
                        .build(),
                LecturerEntity.builder()
                        .id(2L)
                        .name("Test2")
                        .salary(new BigDecimal("1100"))
                        .age(37)
                        .universityId(2L)
                        .build(),
                LecturerEntity.builder()
                        .id(3L)
                        .name("Test3")
                        .salary(new BigDecimal("900"))
                        .age(39)
                        .universityId(1L)
                        .build()
        );
    }


}