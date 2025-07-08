package com.example.pjt_premier02.players.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pjt_premier02.players.entity.PlayersEntity;

@Repository
public interface PlayersRepository extends JpaRepository<PlayersEntity, Integer>{

	List<PlayersEntity> findByClubNo(Integer clubNo);
}
