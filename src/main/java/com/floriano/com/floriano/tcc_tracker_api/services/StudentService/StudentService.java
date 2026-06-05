package com.floriano.com.floriano.tcc_tracker_api.services.StudentService;

import com.floriano.com.floriano.tcc_tracker_api.dto.RegisterStudentDTO;
import com.floriano.com.floriano.tcc_tracker_api.model.Student.Student;
import com.floriano.com.floriano.tcc_tracker_api.model.user.User;
import com.floriano.com.floriano.tcc_tracker_api.model.user.UserRole;
import com.floriano.com.floriano.tcc_tracker_api.repositories.StudentRepository.StudentRepository;
import com.floriano.com.floriano.tcc_tracker_api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User register(RegisterStudentDTO data) {

        if (userRepository.existsByEmail(data.email())) {
            throw new RuntimeException("Email já cadastrado");
        }

        if (studentRepository.existsByRa(data.ra())) {
            throw new RuntimeException("RA já cadastrado");
        }

        User user = new User(
                data.email(),
                passwordEncoder.encode(data.password()),
                UserRole.STUDENT
        );

        user = userRepository.save(user);

        Student student = new Student();
        student.setName(data.name());
        student.setRa(data.ra());
        student.setUser(user);

        studentRepository.save(student);

        return user;
    }
}
