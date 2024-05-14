package com.ompany.repository;


import com.ompany.models.Answer;
import com.ompany.models.AnswerResponse;
import com.ompany.models.Channel;
import com.ompany.models.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {




    @Query(value = "select student.original_id as studentOriginalId ,student.last_name as lastName,a.green as green,a.red as red, a.pink as pink,a.created_date as createdDate  from " +
            "student inner join public.answer a on student.id = a.student_id" +
            " inner join public.channel c on c.id = student.channel_id where  c.id = ?1 and  a.created_date = current_date  ",nativeQuery = true)
    List <AnswerResponse> findAllAnswer(int channelId);


    @Query(value = "select count(a.red) as redCount from " +
            "student inner join public.answer a on student.id = a.student_id" +
            " inner join public.channel c on c.id = student.channel_id where  c.id = ?1  ",nativeQuery = true)
    Integer findBy(int channelId);



}
