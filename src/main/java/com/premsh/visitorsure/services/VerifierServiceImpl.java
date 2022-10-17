package com.premsh.visitorsure.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.premsh.visitorsure.dto.CheckPasscodeDto;
import com.premsh.visitorsure.models.Visit;
import com.premsh.visitorsure.repository.EmployeeDao;
import com.premsh.visitorsure.repository.OfficeDao;
import com.premsh.visitorsure.repository.VisitDao;
import com.premsh.visitorsure.repository.VisitorDao;
import com.premsh.visitorsure.services.api.VerifierServices;

@Service
@Primary
public class VerifierServiceImpl implements VerifierServices {
	@Autowired VisitDao visitDao;
	@Autowired VisitorDao visitorDao;
	@Autowired EmployeeDao employeeDao;
	@Autowired OfficeDao officeDao;

	public CheckPasscodeDto checkPasscode(Integer passcode) {
		CheckPasscodeDto checkPasscodeDto = new CheckPasscodeDto();
		List<Visit> visit = visitDao.getByPasscode(passcode);
		if (!visit.isEmpty()) {
			checkPasscodeDto.setVisit(visit.get(0));
			checkPasscodeDto.setVisitor(visitorDao.getById(visit.get(0).getVisitorId()).get(0));
			checkPasscodeDto.setEmployee(employeeDao.getById(visit.get(0).getEmployeeId()).get(0));
			checkPasscodeDto.setOffice(officeDao.getById(visit.get(0).getOfficeId()).get(0));
		}
		return checkPasscodeDto;
	}

}
