package com.deanhealthplan.memberinfo.service;

import com.ca.gen85.csu.exception.CSUException;
import com.eds.metavance.membership.Pmbr1dl4ListMemberNetworksTExport;

public interface NetworkInfo {

	public Pmbr1dl4ListMemberNetworksTExport pmbr1dl4ListMemberNetworksT(String contractId, String memberId, String effDate, String endDate) throws IllegalArgumentException, CSUException, Exception;
	
}
