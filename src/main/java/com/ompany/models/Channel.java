package com.ompany.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "tg_id",unique = true )
    private String tgId;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "teacher_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Teacher teacher;
    @Column(name = "created_date")
    private LocalDate createdDate;

    public Channel(String name, String tgId) {
        this.name = name;
        this.tgId = tgId;
        createdDate = LocalDate.now();
    }
}
