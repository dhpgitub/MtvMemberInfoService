package com.deanhealthplan.memberinfo.service;

import com.deanhealthplan.memberinfo.domain.api.memberinforeq.MemberGetMTVMemberInfoReq;
import com.deanhealthplan.memberinfo.domain.api.memberinforesp.MemberGetMTVMemberInfoResp;

public interface MemberSearchOrchestration {

	public MemberGetMTVMemberInfoResp memberSearch (String coorelationId, MemberGetMTVMemberInfoReq memberGetMtvMemberInfoReq);
	
}
