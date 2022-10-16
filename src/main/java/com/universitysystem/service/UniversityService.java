package com.universitysystem.service;

import com.universitysystem.model.entity.UniversityEntity;
import com.universitysystem.repository.LecturerRepository;
import com.universitysystem.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {

    private final LecturerRepository lecturerRepository;

    private final UniversityRepository universityRepository;
    @Autowired
    public UniversityService(LecturerRepository lecturerRepository, UniversityRepository universityRepository) {
        this.lecturerRepository = lecturerRepository;
        this.universityRepository = universityRepository;
    }

    public List<UniversityEntity> getUniversities(){
        return universityRepository.getUniversities();
    }

    public List<UniversityEntity> getUniversitiesWithLecturers() {
        /*
        Get all universities
        Get all lecturers
        map them together
        return list of universities with lecturers
         */

        var universities = universityRepository.getUniversities();
        var lecturers = lecturerRepository.getLecturers();

        universities.forEach(university -> lecturers.forEach(lecturer -> {
            if (university.getId().equals(lecturer.getUniversityId())) {
                if (university.getLecturers() == null) {
                    university.setLecturers(new ArrayList<>());
                }
                university.getLecturers().add(lecturer);
            }
        }));

        return universities;
    }
}
