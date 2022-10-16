package com.universitysystem.controller;


import com.universitysystem.model.entity.UniversityEntity;
import com.universitysystem.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;
    @GetMapping
    public List<UniversityEntity> getUniversities(){
        return universityService.getUniversities();
    }

    @GetMapping("/with-lecturers")
    public List<UniversityEntity> getUniversitiesWithLecturers() {
        return universityService.getUniversitiesWithLecturers();
    }

}
