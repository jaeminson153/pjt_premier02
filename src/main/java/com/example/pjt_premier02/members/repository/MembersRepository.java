package com.example.pjt_premier02.members.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pjt_premier02.members.entity.MembersEntity;

@Repository
public interface MembersRepository  extends JpaRepository<MembersEntity, String>{

}
