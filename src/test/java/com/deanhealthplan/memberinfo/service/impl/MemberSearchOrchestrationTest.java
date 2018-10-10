package com.deanhealthplan.memberinfo.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deanhealthplan.memberinfo.domain.api.memberinforeq.MemberGetMTVMemberInfoReq;


public class MemberSearchOrchestrationTest {

	@Autowired
	MemberSearchOrchestrationImpl mso;
	
	@Autowired
	MemberGetMTVMemberInfoReq mgmmir;
	
	@Test
	public void searchByMemberIdTest() {
		
		mso.searchByMemberId("12", mgmmir);
		
		
	}
	
	
	
	
}
