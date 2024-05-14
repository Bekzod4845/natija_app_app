package com.ompany.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String tgId;
    @Column(name = "created_date")
    private LocalDate createdDate;

    public Teacher(String name, String tgId) {
        this.name = name;
        this.tgId = tgId;
        createdDate =LocalDate.now();
    }
}
