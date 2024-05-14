package com.ompany.dto.answer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    private int id;
    private String red;
    private String green;
    private String pink;
    private LocalDate createdDate;
}
