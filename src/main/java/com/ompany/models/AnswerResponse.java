package com.ompany.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



public interface AnswerResponse {


     String getRed();
     String getGreen();
     String getPink();
     String getStudentOriginalId();
     String getLastName();
     LocalDate getCreatedDate();


}
