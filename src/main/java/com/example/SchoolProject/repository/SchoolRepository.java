package com.example.SchoolProject.repository;

import com.example.SchoolProject.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School,Long> {
    Optional<School> findBySchoolName(String schoolName);

    List<School> findAllBySchoolName(String schoolName);
}
