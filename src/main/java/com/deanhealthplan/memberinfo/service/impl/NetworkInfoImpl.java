package com.deanhealthplan.memberinfo.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

import com.ca.gen85.csu.exception.CSUException;
import com.deanhealthplan.memberinfo.config.MemberInfoProperties;
import com.deanhealthplan.memberinfo.mock.MtvNetworkLookup;
import com.eds.metavance.membership.Pmbr1dl4ListMemberNetworksT;
import com.eds.metavance.membership.Pmbr1dl4ListMemberNetworksTExport;
import com.eds.metavance.membership.Pmbr1dl4ListMemberNetworksTImport;

@Service
public class NetworkInfoImpl {

	
private static final Logger log = LogManager.getLogger(NetworkInfoImpl.class);

//	@Value("${data.MTVUSER}")
//	private String MTVUSER;
//	@Value("${data.MTVPASSWORD}")
//	private String MTVPASSWORD;
//	@Value("${data.MTVHOST}")
//	private String MTVHOST;
	
	@Autowired
	MemberInfoProperties memberInfoProps;

	@Autowired
	MtvNetworkLookup mtvNetworkLookup;

	
	@NewSpan("MtvNetworkLookupApiCall")
	public Pmbr1dl4ListMemberNetworksTExport pmbr1dl4ListMemberNetworksT(String contractId, String memberId, String effDate, String endDate) throws IllegalArgumentException, CSUException, Exception  {
		
		Pmbr1dl4ListMemberNetworksTImport networkInfoImport = new Pmbr1dl4ListMemberNetworksTImport();
		
		networkInfoImport.getImportImbr1Interface().setRequestorId(memberInfoProps.getMTVUSER());
		networkInfoImport.getImportImbr1Interface().setRequestorPassword(memberInfoProps.getMTVPASSWORD());
		networkInfoImport.getImportQualifyImbr1MemberProvAssociation().setContractId3(contractId);
		networkInfoImport.getImportQualifyImbr1MemberProvAssociation().setMemberId(memberId);
		networkInfoImport.getImportQualifyImbr1MemberProvAssociation().setTEffectiveDate(effDate);
		networkInfoImport.getImportQualifyImbr1MemberProvAssociation().setTEndDate(endDate);
				
		Pmbr1dl4ListMemberNetworksT networkInfo = new Pmbr1dl4ListMemberNetworksT();
		Pmbr1dl4ListMemberNetworksTExport networkInfoExport = new Pmbr1dl4ListMemberNetworksTExport();
		try {
			//networkInfoExport = networkInfo.execute(networkInfoImport, mtvprops.getMTVURL());
			networkInfoExport = mtvNetworkLookup.mtvNetworkSearch(contractId);
		} catch (IllegalArgumentException e) {
			log.error("IllegalArgumentException in pmbr1dl4ListMemberNetworksT of NetworkInfoImpl: ", e);
			throw e;
//		} catch (CSUException e) {
//			log.error("CSUException in pmbr1dl4ListMemberNetworksT of NetworkInfoImpl: ", e);
//			throw e;
		} catch (Exception e) {
			log.error("Exception in pmbr1dl4ListMemberNetworksT of NetworkInfoImpl: ", e);
			throw e;
		}
		return networkInfoExport;
		
	}
}
