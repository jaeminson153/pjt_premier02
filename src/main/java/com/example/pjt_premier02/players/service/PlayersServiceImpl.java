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

            String uploadDir = "C:/web__ai/first-project-new/public/images/players/";
            File saveFile = new File(uploadDir + newFileName);
            try {
                file.transferTo(saveFile);
                entity.setImgPath("/images/players/" + newFileName);
            } catch (IOException e) {
                throw new RuntimeException("파일 저장 실패", e);
            }
        }

        // ✅ 저장
        playersRepository.save(entity); // 이때는 UPDATE가 정상 수행됨

        return toDTO(entity);
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
