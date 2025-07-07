package com.example.pjt_premier02.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pjt_premier02.club.entity.ClubEntity;

@Repository
public interface ClubRepository extends JpaRepository<ClubEntity, Long> {

}
