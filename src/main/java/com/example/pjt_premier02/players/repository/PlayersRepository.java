package com.example.pjt_premier02.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pjt_premier02.players.entity.PlayersEntity;
import java.util.List;

public interface PlayersRepository extends JpaRepository<PlayersEntity, Integer> {
    List<PlayersEntity> findByClubNo(Integer clubNo);
    PlayersEntity findByClubNoAndPlayerNo(Integer clubNo, Integer playerNo);
}
