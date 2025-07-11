package com.example.pjt_premier02.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pjt_premier02.players.entity.PlayersEntity;
import com.example.pjt_premier02.players.entity.PlayersId;

import java.util.List;

public interface PlayersRepository extends JpaRepository<PlayersEntity, PlayersId> {
    List<PlayersEntity> findByClubNo(Integer clubNo);
    PlayersEntity findByClubNoAndPlayerNo(Integer clubNo, Integer playerNo);
}
