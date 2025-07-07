package com.example.pjt_premier02.members.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pjt_premier02.members.entity.MemberRefreshTokenEntity;
@Repository
public interface MemberRefreshTokenRepository extends JpaRepository<MemberRefreshTokenEntity, Long> {
   Optional<MemberRefreshTokenEntity> findByMemberEmail(String memberEmail);
   void deleteByMemberEmail(String memberEmail);
}




