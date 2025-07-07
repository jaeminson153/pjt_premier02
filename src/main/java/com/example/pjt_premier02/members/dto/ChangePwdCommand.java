package com.example.pjt_premier02.members.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ChangePwdCommand {
	private String currentPassword;
	private String newPassword;	
}
