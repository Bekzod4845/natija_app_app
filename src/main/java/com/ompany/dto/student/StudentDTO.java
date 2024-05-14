package com.ompany.dto.student;

import com.ompany.models.Channel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String originalId;
    private LocalDate createdDate;
}
