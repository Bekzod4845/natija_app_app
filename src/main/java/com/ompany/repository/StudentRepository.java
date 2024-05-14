package com.ompany.repository;


import com.ompany.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByChannelTgId(String channelTgId);
}
