package com.deanhealthplan.memberinfo.mock;

import org.springframework.stereotype.Component;

import com.eds.metavance.membership.Pmbr1av3MemberSearchTExport;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTExport.ExportMemberGroupRow;

@Component
public class MtvMemberSearch {

	
	
	public Pmbr1av3MemberSearchTExport mockMemberSearch(String contractId) {
		
		Pmbr1av3MemberSearchTExport memberExport = new Pmbr1av3MemberSearchTExport();
		memberExport.getExportImbr1Interface().setReturnCode(1);
		contractId = contractId.trim();
		
		ExportMemberGroupRow row = new ExportMemberGroupRow();
		row.getExportGImbr1Member().setContractId3("000250603");
		row.getExportGImbr1Member().setCompleteFirstName("SHILPA");
		row.getExportGImbr1Member().setCompleteLastName("KHOT");
		row.getExportGImbr1Member().setMemberId("01");
		row.getExportGImbr1Member().setTBirthDate("19721206");
		row.getExportGImbr1Member().setPersonIdentifier("0450620210094080");
		row.getExportGImbr1Member().setCompleteMiddleName("K");
		row.getExportGImbr1Member().setSexCode("F");
		row.getExportGImbr1Member().setCoverageContractHolderFlag("Y");
		row.getExportGImbr1Member().setRecordStatus("A");
		row.getExportGImbr1MemberEligibility().setTEffectiveDate("20170101");
		row.getExportGImbr1MemberEligibility().setTEndDate("99991231");
		row.getExportGImbr1MemberEligibility().setLineOfBusiness("");
		row.getExportGImbr1MemberEligibility().setBusinessLevel4Id("COMM PROG PR");
		row.getExportGImbr1MemberEligibility().setBusinessLevel5Id("FULLY FUNDED");
		row.getExportGImbr1MemberEligibility().setBusinessLevel6Id("");
		row.getExportGImbr1MemberEligibility().setBusinessLevel7Id("POS");
		row.getExportGImbr1MemberEligibility().setBenefitPackageTypeCode("MED");
		row.getExportGImbr1MemberEligibility().setBenefitPackageIdentifier("POS03329");
		row.getExportGImbr1CoverageTypeSpan().setEmployerGroupLevel1Id("14RMB0C");
		row.getExportGImbr1MemberStatus().setStatusCode("APTC");
		
		
		
		ExportMemberGroupRow[] rows = new ExportMemberGroupRow[1];
		rows[0] = row;
		memberExport.getExportMemberGroup().setRows(rows);
		return memberExport;
		
//		memberExport.getExportImbr1Interface().setReturnCode(-10);
//		memberExport.getExportImbr1Interface().setContextString("No Member Found");
//		return memberExport;
		
		
	}
	
	
	
}
