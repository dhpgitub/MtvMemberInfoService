package com.deanhealthplan.memberinfo.controller;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deanhealthplan.memberinfo.SwaggerVisible;
import com.deanhealthplan.memberinfo.domain.api.memberinforeq.MemberGetMTVMemberInfoReq;
import com.deanhealthplan.memberinfo.domain.api.memberinforesp.MemberGetMTVMemberInfoResp;
import com.deanhealthplan.memberinfo.service.impl.MemberSearchOrchestrationImpl;

@RestController
@RequestMapping("/")
public class MemberInfoController {

	private static final Logger log = LogManager.getLogger(MemberInfoController.class);
	
	@Autowired
	MemberSearchOrchestrationImpl memberSearchOrchImpl;
	
	@SwaggerVisible
	@RequestMapping(path="/smbr1av3_MemberSearchT", method=RequestMethod.POST,
				produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
				consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public MemberGetMTVMemberInfoResp smbr1av3_MemberSearchT(@RequestBody MemberGetMTVMemberInfoReq memberGetMtvMemberInfoReq) {
		log.info("Request for Member Info received.");
		String coorelationId = "";
		if(memberGetMtvMemberInfoReq.getHeader() != null && memberGetMtvMemberInfoReq.getHeader().getCorrelationID() != null && (!memberGetMtvMemberInfoReq.getHeader().getCorrelationID().trim().equals(""))) {
			coorelationId = memberGetMtvMemberInfoReq.getHeader().getCorrelationID();
		} else {
			// if CorrelationId comes in blank, create one using current time in millis
			coorelationId = GregorianCalendar.getInstance().getTimeInMillis()+"";
		}
		// print values for debug only, not meant for production
		log.debug(printRequestValues(coorelationId, memberGetMtvMemberInfoReq));
		return memberSearchOrchImpl.memberSearch(coorelationId, memberGetMtvMemberInfoReq);
	}
	
	/**
	 * Print out the request variables.  Use for DEBUG ONLY.
	 * @param coorelationId
	 * @param memberInfoReq
	 * @return String
	 */
	private String printRequestValues(String coorelationId, MemberGetMTVMemberInfoReq memberInfoReq) {
		StringBuilder str = new StringBuilder();
		str.append("ContractId: " + memberInfoReq.getContractID() + "\n");
		str.append("MemberId: " + memberInfoReq.getMemberID() + "\n");
		str.append("FirstName: " + memberInfoReq.getMemberFirstName() + "\n");
		str.append("LastName: " + memberInfoReq.getMemberLastName() + "\n");
		str.append("DOB: " + memberInfoReq.getMemberDateOfBirth() + "\n");
		str.append("CorrelationID: " + coorelationId);
		return str.toString();
	}
	
	
}
