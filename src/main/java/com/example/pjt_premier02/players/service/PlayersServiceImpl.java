package com.example.pjt_premier02.players.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pjt_premier02.players.dto.PlayersDTO;
import com.example.pjt_premier02.players.entity.PlayersEntity;
import com.example.pjt_premier02.players.repository.PlayersRepository;

@Service
public class PlayersServiceImpl implements PlayersService {

    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public List<PlayersDTO> getByClubNo(Integer clubNo) {
        return playersRepository.findByClubNo(clubNo)
            .stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public PlayersDTO getByClubNoAndPlayerNo(Integer clubNo, Integer playerNo) {
        PlayersEntity entity = playersRepository.findByClubNoAndPlayerNo(clubNo, playerNo);
        return (entity != null) ? toDTO(entity) : null;
    }

    @Override
    public PlayersDTO updatePlayer(Integer clubNo, Integer playerNo, PlayersDTO playerDTO, MultipartFile file) {
        PlayersEntity entity = playersRepository.findByClubNoAndPlayerNo(clubNo, playerNo);

        if (entity == null) {
            return null;
        }

        // ✅ 이미 존재하는 엔티티에만 값 덮어쓰기 (playerNo 유지)
        entity.setName(playerDTO.getName());
        entity.setAge(playerDTO.getAge());
        entity.setNation(playerDTO.getNation());
        entity.setPosition(playerDTO.getPosition());
        entity.setBackNumber(playerDTO.getBackNumber());
        entity.setHeight(playerDTO.getHeight());
        entity.setWeight(playerDTO.getWeight());

        // ✅ 파일 처리
        if (file != null && !file.isEmpty()) {
            String originalName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String newFileName = uuid + "_" + originalName;

            // 클럽 번호에 맞는 폴더를 동적으로 설정
            String clubFolderName = getClubFolderName(clubNo);  // 클럽 번호에 맞는 폴더 이름 가져오기
            String uploadDir = "C:/web_ai/react-workspace/first-project-new/public/images/players/" + clubFolderName + "/";

            // 폴더가 없으면 생성
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs(); // 디렉토리 생성
            }

            // 이미지 저장
            File saveFile = new File(uploadDir + newFileName);
            try {
                file.transferTo(saveFile);
                // 이미지 경로를 클럽 이름에 맞게 저장
                entity.setImgPath("/images/players/" + clubFolderName + "/" + newFileName);
            } catch (IOException e) {
                throw new RuntimeException("파일 저장 실패", e);
            }
        }

        // ✅ 저장
        playersRepository.save(entity);

        return toDTO(entity);
    }

    // 클럽 번호에 맞는 폴더 이름 반환 (예: 1 -> "liverpool", 2 -> "manchester_city")
    private String getClubFolderName(Integer clubNo) {
        switch (clubNo) {
            case 1: return "liverpool";
            case 2: return "manchester_city";
            case 3: return "chelsea";
            case 4: return "tottenham";
            // 추가 클럽 번호에 대한 처리
            default: return "unknown"; // 알 수 없는 클럽
        }
    }



    // 엔티티를 DTO로 변환
    private PlayersDTO toDTO(PlayersEntity e) {
        return PlayersDTO.builder()
            .playerNo(e.getPlayerNo())
            .clubNo(e.getClubNo())
            .name(e.getName())
            .age(e.getAge())
            .nation(e.getNation())
            .position(e.getPosition())
            .height(e.getHeight())
            .weight(e.getWeight())
            .backNumber(e.getBackNumber())
            .imgPath(e.getImgPath())
            .build();
    }
}
