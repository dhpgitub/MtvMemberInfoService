package com.deanhealthplan.memberinfo.service;

import com.ca.gen85.csu.exception.CSUException;
import com.deanhealthplan.memberinfo.domain.api.memberinforeq.MemberGetMTVMemberInfoReq;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTExport;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTImport;

public interface MemberInfo {

	public Pmbr1av3MemberSearchTExport pmbr1av3MemberSearch_T(Pmbr1av3MemberSearchTImport memInfoImport) throws IllegalArgumentException, CSUException, Exception;
	
}
