package com.deanhealthplan.memberinfo.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

import com.ca.gen85.csu.exception.CSUException;
import com.deanhealthplan.memberinfo.config.MTVProperties;
import com.deanhealthplan.memberinfo.mock.MtvMemberSearch;
import com.deanhealthplan.memberinfo.service.MemberInfo;
import com.eds.metavance.membership.Pmbr1av3MemberSearchT;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTExport;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTImport;


@Service
public class MemberInfoImpl implements MemberInfo {

	private static final Logger log = LogManager.getLogger(MemberInfoImpl.class);
	
	//@Value("${MTVUser}") 
	//String mtvUser;
	//@Value("${MTVPassword}") 
	//String mtvPass;
	//@Value("${MTVURL}")
	//String mtvUrl;
	@Autowired
	MtvMemberSearch mtvMemberSearch;
	@Autowired
    private MTVProperties mtvprops;
	
	@NewSpan("MtvMemberInfoApiCall")
	public Pmbr1av3MemberSearchTExport pmbr1av3MemberSearch_T(Pmbr1av3MemberSearchTImport memInfoImport) throws IllegalArgumentException, CSUException, Exception  {
		
		//memInfoImport.getImportImbr1Interface().setRequestorId(mtvUser);
		//memInfoImport.getImportImbr1Interface().setRequestorPassword(mtvPass);
		log.info("MTVUser: " + mtvprops.getMTVUser());
		//log.info("MTVPassword: " + mtvprops.getMTVPassword());
		log.info("MTVURL: " + mtvprops.getMTVURL());
		Pmbr1av3MemberSearchT memInfo = new Pmbr1av3MemberSearchT();
		Pmbr1av3MemberSearchTExport memInfoExport = new Pmbr1av3MemberSearchTExport();
		try {
			//memInfoExport = memInfo.execute(memInfoImport, mtvUrl);
			memInfoExport = mtvMemberSearch.mockMemberSearch(memInfoImport.getImportQualifyImbr1Member().getContractId3());
			//System.out.println(memInfoExport.getExportImbr1Interface().getReturnCode());
			//System.out.println(memInfoExport.getExportImbr1Interface().getContextString());
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
		log.info("Successfully called MTV API Member Search, returning response");
		return memInfoExport;
		
	}

	
}
