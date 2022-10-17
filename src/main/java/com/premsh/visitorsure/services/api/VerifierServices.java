package com.premsh.visitorsure.services.api;


import com.premsh.visitorsure.dto.CheckPasscodeDto;

public interface VerifierServices {
	
	CheckPasscodeDto checkPasscode(Integer passcode);

}
