package com.example.pjt_premier02.admin.service;

import java.util.Optional;

import com.example.pjt_premier02.admin.entity.AdminEntity;


public interface AdminService {

	public Optional<AdminEntity>  findByAdminId(String adminId);
	public void deleteAdminProcess(String adminId); 
}
