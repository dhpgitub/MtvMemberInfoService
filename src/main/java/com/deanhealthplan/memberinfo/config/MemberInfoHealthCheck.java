package com.deanhealthplan.memberinfo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

import com.deanhealthplan.memberinfo.service.impl.MemberInfoImpl;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTImport;

@Component
public class MemberInfoHealthCheck extends AbstractHealthIndicator {

	@Autowired 
	private MemberInfoImpl memberInfo;

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		try {
			// call MemberInfo, should return successful with no member found 
			Pmbr1av3MemberSearchTImport memInfoImport = new Pmbr1av3MemberSearchTImport();
			memInfoImport.getImportImbr1Interface().setSearchType("I");
			memInfoImport.getImportImbr1Interface().setPartialSearchFlag("F");
			memInfoImport.getImportQualifyImbr1Member().setMemberId("01");
			memInfoImport.getImportQualifyImbr1Member().setContractId3("1234567");
			memInfoImport.getImportQualifyImbr1Member().setTBirthDate("19721206");
			memberInfo.pmbr1av3MemberSearch_T(memInfoImport);
			builder.up();
		} catch (Exception e) {
			builder.down();
		}
		
	}
	

}
