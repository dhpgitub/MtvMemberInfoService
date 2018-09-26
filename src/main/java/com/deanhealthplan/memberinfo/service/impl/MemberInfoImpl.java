package com.deanhealthplan.memberinfo.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

import com.ca.gen85.csu.exception.CSUException;
import com.deanhealthplan.memberinfo.config.MemberInfoProperties;
import com.deanhealthplan.memberinfo.mock.MtvMemberSearch;
import com.deanhealthplan.memberinfo.service.MemberInfo;
import com.eds.metavance.membership.Pmbr1av3MemberSearchT;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTExport;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTImport;


@Service
public class MemberInfoImpl implements MemberInfo {

	private static final Logger log = LogManager.getLogger(MemberInfoImpl.class);
	
	@Autowired
	MtvMemberSearch mtvMemberSearch;
	@Autowired
    private MemberInfoProperties mtvprops;
	
	@NewSpan("MtvMemberInfoApiCall")
	public Pmbr1av3MemberSearchTExport pmbr1av3MemberSearch_T(Pmbr1av3MemberSearchTImport memInfoImport) throws IllegalArgumentException, CSUException, Exception  {
		//log.info("MTVUser: |" + mtvprops.getMtvUser()+"|");
		//log.info("MTVPassword: |" + mtvprops.getMtvPassword()+"|");
		//log.info("MTVURL: |" + mtvprops.getMtvUrl()+"|");
		memInfoImport.getImportImbr1Interface().setRequestorId(mtvprops.getMtvUser());
		memInfoImport.getImportImbr1Interface().setRequestorPassword(mtvprops.getMtvPassword());

		Pmbr1av3MemberSearchT memInfo = new Pmbr1av3MemberSearchT();
		Pmbr1av3MemberSearchTExport memInfoExport = new Pmbr1av3MemberSearchTExport();
		try {
			//memInfoExport = memInfo.execute(memInfoImport, mtvprops.getMtvUrl().trim());
			memInfoExport = mtvMemberSearch.mockMemberSearch(memInfoImport.getImportQualifyImbr1Member().getContractId3());
		} catch (IllegalArgumentException e) {
			log.error("IllegalArgumentException in pmbr1av3MemberSearch_T of MemberInfoImpl: ", e);
			throw e;
//		} catch (CSUException e) {
//			log.error("CSUException in pmbr1av3MemberSearch_T of MemberInfoImpl: ", e);
//			throw e;
		} catch (Exception e) {
			log.error("Exception in pmbr1av3MemberSearch_T of MemberInfoImpl: ", e);
			throw e;
		}
		return memInfoExport;
		
	}

	
}
