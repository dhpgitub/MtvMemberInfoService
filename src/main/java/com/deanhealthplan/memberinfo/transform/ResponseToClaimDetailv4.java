package com.deanhealthplan.memberinfo.transform;

import org.springframework.stereotype.Component;

import com.deanhealthplan.memberinfo.domain.ClaimDetailv4;
import com.deanhealthplan.memberinfo.domain.ErrorMessage;

@Component
public class ResponseToClaimDetailv4 {

//	
//	
//	public ClaimDetailv4 xformToClaimDetailv4(Phcl1dl4DetailClaimTExport response) {
//		ClaimDetailv4 clmDetailv4 = new ClaimDetailv4();
//		clmDetailv4.setErrorMessage(new ErrorMessage());
//		// Populate the ErrorMessage
//		clmDetailv4.getErrorMessage().setSeverityCode(response.getExportIclm1Interface().getSeverityCode());
//		clmDetailv4.getErrorMessage().setContextString(response.getExportIclm1Interface().getContextString());
//		clmDetailv4.getErrorMessage().setMessage("");
//		clmDetailv4.getErrorMessage().setReturnCode(String.valueOf(response.getExportIclm1Interface().getReturnCode()));
//		clmDetailv4.getErrorMessage().setStacktrace("");
//		// populate the claim response
//		clmDetailv4.setMemberContractId(response.getExportClaimIclm1Claim().getContractIdentifier2().trim());
//		clmDetailv4.setMemberId(response.getExportClaimIclm1Claim().getMemberIdentifier().trim());
//		clmDetailv4.setMemberGroupLvlId(response.getExportClaimIclm1Claim().getEmpGroupLevel1Id().trim());
//		
//		clmDetailv4.setBillingProviderId(response.getExportClaimIclm1Claim().getBillingProviderId().trim());
//		clmDetailv4.setBillingPrvAddress1(response.getExportClaimIclm1Claim().getBillingAddress1().trim());
//		clmDetailv4.setBillingPrvAddress2(response.getExportClaimIclm1Claim().getBillingAddress2().trim());
//		clmDetailv4.setBillingPrvAddress3(response.getExportClaimIclm1Claim().getBillingAddress3().trim());
//		clmDetailv4.setBillingPrvCity(response.getExportClaimIclm1Claim().getBillingCity().trim());
//		clmDetailv4.setBillingPrvState(response.getExportClaimIclm1Claim().getBillingState().trim());
//		clmDetailv4.setBillingPrvZip(response.getExportClaimIclm1Claim().getBillingZip().trim());
//		
//		clmDetailv4.setServicePrvrId(response.getExportClaimIclm1Claim().getSecurityProviderId());
//		// loop to find the service line, get the status code and break out
//		for(ExportClaimGroupRow ecgr :response.getExportClaimGroup().getRows()) {
//			clmDetailv4.setServicePrvParCode(ecgr.getExportClaimGIclm1Serviceline().getProviderStatusCode().trim());
//			break;
//		}
//
//		return clmDetailv4;
//	}
//	
//	
//	public ClaimDetailv4 xformToClaimDetailv4Error(Phcl1dl4DetailClaimTExport response, Exception e) {
//		ClaimDetailv4 clmDetailv4 = new ClaimDetailv4();
//		clmDetailv4.setErrorMessage(new ErrorMessage());
//		// Populate the ErrorMessage
//		clmDetailv4.getErrorMessage().setSeverityCode(response.getExportIclm1Interface().getSeverityCode().trim());
//		clmDetailv4.getErrorMessage().setContextString(response.getExportIclm1Interface().getContextString().trim() != "" ? response.getExportIclm1Interface().getContextString() : e.getCause().toString());
//		clmDetailv4.getErrorMessage().setMessage(e.getMessage());
//		clmDetailv4.getErrorMessage().setReturnCode(String.valueOf(response.getExportIclm1Interface().getReturnCode()));
//		clmDetailv4.getErrorMessage().setStacktrace(e.getStackTrace().toString());
//		return clmDetailv4;
//	}
}
