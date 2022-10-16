package com.sdacademy.university.repository;


import com.sdacademy.university.model.entity.UniversityEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniversityRepository {

    private List<UniversityEntity> universities = List.of(
           UniversityEntity.builder()
                   .code("KTU")
                   .title("Kaunas Technology University")
                   .build(),
            UniversityEntity.builder()
                    .code("VU")
                    .title("Vilnius University")
                    .build()
    );

    public List<UniversityEntity> getUniversities(){
        return universities;

    }
}
