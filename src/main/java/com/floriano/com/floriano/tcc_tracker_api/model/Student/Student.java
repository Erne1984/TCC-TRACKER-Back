package com.floriano.com.floriano.tcc_tracker_api.model.Student;

import com.floriano.com.floriano.tcc_tracker_api.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String ra;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
