package com.floriano.com.floriano.tcc_tracker_api.repositories.StudentRepository;

import com.floriano.com.floriano.tcc_tracker_api.model.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByRa(String ra);
}
