package com.example.pjt_premier02.members.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pjt_premier02.members.dto.AuthInfo;
import com.example.pjt_premier02.members.dto.ChangePwdCommand;
import com.example.pjt_premier02.members.dto.MembersDTO;
import com.example.pjt_premier02.members.entity.MembersEntity;
import com.example.pjt_premier02.members.repository.MemberRefreshTokenRepository;
import com.example.pjt_premier02.members.repository.MembersRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Slf4j
@Service
public class MembersServiceImpl implements MembersService {
	@Autowired
	private MembersRepository membersRepository;
	
	@Autowired
	private MemberRefreshTokenRepository refreshTokenRepository; 

	public MembersServiceImpl() {

	}

	@Override
	public AuthInfo addMemberProcess(MembersDTO dto) {
		membersRepository.save(dto.toEntity());
		return new AuthInfo(dto.getMemberEmail(), dto.getMemberPass(), dto.getMemberName(), dto.getAuthRole());
	}

	@Override
	public AuthInfo loginProcess(MembersDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembersDTO getByMemberProcess(String memberEmail) {
		Optional<MembersEntity> optMembersEntity = membersRepository.findById(memberEmail);
		return MembersDTO.toDTO(optMembersEntity.get());
	}

	@Override
	public AuthInfo updateMemberProcess(MembersDTO dto) {
		
		membersRepository.save(dto.toEntity());
		return new AuthInfo(dto.getMemberEmail(), dto.getMemberName(), dto.getMemberPass(), dto.getAuthRole());
	}

	@Override
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd) {


	}

	@Override
	public void deleteMemberProcess(String memberEmail) {
		log.info("============= :::::deleteMemberProcess 1 ::::::{}",memberEmail);
		refreshTokenRepository.deleteByMemberEmail(memberEmail);
		log.info("============= :::::deleteMemberProcess 2 ::::::{}",memberEmail);
		membersRepository.deleteById(memberEmail);
		log.info("============= :::::deleteMemberProcess 3 ::::::{}",memberEmail);
	}
	
	@Override
	public Optional<MembersEntity>  findByEmail(String memberEmail) {
		return membersRepository.findById(memberEmail);
	}




	

}
