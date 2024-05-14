package com.ompany.dto.answer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCreateDTO {
    private String red;
    private String green;
    private String pink;
}
