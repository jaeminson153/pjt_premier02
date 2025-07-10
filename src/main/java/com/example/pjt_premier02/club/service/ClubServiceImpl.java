package com.example.pjt_premier02.club.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pjt_premier02.club.dto.ClubDTO;
import com.example.pjt_premier02.club.entity.ClubEntity;
import com.example.pjt_premier02.club.repository.ClubRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public ClubServiceImpl() {
        // 기본 생성자
    }

    // ✅ 전체 구단 목록 조회
    @Override
    public List<ClubDTO> listClub() {
        List<ClubEntity> listClubEntity = clubRepository.findClubList();
        return listClubEntity.stream()
                             .map(ClubDTO::toDTO)
                             .collect(Collectors.toList());
    }

    // ✅ 특정 구단 상세 조회
    @Override
    public ClubDTO contentClub(long clubNo) {
        ClubEntity clubEntity = clubRepository.findClubByClubNo(clubNo);
        return ClubDTO.toDTO(clubEntity);
    }

    // ✅ 구단 정보 수정 (파일 포함)
    @Override
    public void updateClub(Long clubNo, ClubDTO clubDto) {
        ClubEntity existingClub = clubRepository.findClubByClubNo(clubNo);

        if (existingClub != null) {
            // ✅ 텍스트 정보 업데이트
            existingClub.setClubName(clubDto.getClubName());
            existingClub.setHomeCity(clubDto.getHomeCity());
            existingClub.setYear(clubDto.getYear());
            existingClub.setStadium(clubDto.getStadium());
            existingClub.setHeadCoach(clubDto.getHeadCoach());
            existingClub.setCaptain(clubDto.getCaptain());
            existingClub.setInfomation(clubDto.getInfomation());

            // ✅ 이미지 파일 처리
            MultipartFile file = clubDto.getFilename();
            if (file != null && !file.isEmpty()) {
                String originalName = file.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();
                String newFileName = uuid + "_" + originalName;

                // ✅ 실제 저장 경로 (React 프로젝트 public 아래)
                String uploadDir = "C:/web__ai/first-project-new/public/images/clubs/";
                File saveFile = new File(uploadDir + newFileName);

                try {
                    file.transferTo(saveFile);
                    // ✅ 클라이언트가 접근할 수 있는 경로로 저장
                    existingClub.setImgPath("/images/clubs/" + newFileName);
                } catch (IOException e) {
                    throw new RuntimeException("이미지 저장 실패", e);
                }
            }

            // ✅ DB 저장
            clubRepository.save(existingClub);
        } else {
            throw new RuntimeException("존재하지 않는 구단 번호입니다.");
        }
    }
}
