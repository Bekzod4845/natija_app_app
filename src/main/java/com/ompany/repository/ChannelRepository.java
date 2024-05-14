package com.ompany.repository;


import com.ompany.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Integer> {
    List<Channel> findAllByTeacherTgId(String tgId);
}
