package com.ompany.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String originalId;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "channel_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Channel channel;
    @Column(name = "created_date")
    private LocalDate createdDate;

    public Student(String firstName, String lastName, String originalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.originalId = originalId;
        createdDate = LocalDate.now();
    }


}
