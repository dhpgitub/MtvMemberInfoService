package com.deanhealthplan.memberinfo.service.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deanhealthplan.memberinfo.domain.api.memberinforeq.MemberGetMTVMemberInfoReq;
import com.deanhealthplan.memberinfo.domain.api.memberinforesp.Error;
import com.deanhealthplan.memberinfo.domain.api.memberinforesp.Header;
import com.deanhealthplan.memberinfo.domain.api.memberinforesp.MemberGetMTVMemberInfoResp;
import com.deanhealthplan.memberinfo.domain.api.memberinforesp.MemberGetMTVMemberInfoResp.Result;
import com.deanhealthplan.memberinfo.domain.api.memberinforesp.MemberGetMTVMemberInfoResp.Result.Member;
import com.deanhealthplan.memberinfo.service.MemberSearchOrchestration;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTExport;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTImport;
import com.eds.metavance.membership.Pmbr1dl4ListMemberNetworksTExport;
import com.eds.metavance.membership.Pmbr1dl4ListMemberNetworksTExport.ExportMemberNetworkGroupRow;
import com.eds.metavance.membership.Pmbr1av3MemberSearchTExport.ExportMemberGroupRow;

@Service
public class MemberSearchOrchestrationImpl implements MemberSearchOrchestration {

	private static final Logger log = LogManager.getLogger(MemberSearchOrchestrationImpl.class);
	
	@Autowired
	MemberInfoImpl memberInfo;
	@Autowired
	NetworkInfoImpl networkInfo;
	
	/**
	 * Pmbr1av3MemberSearchT 
	 * 
	 * ImportQualifyImbr1Member
	 * 
	 * Search Criteria 1
	 * SearchType=I
	 * PartialSearchFlag=F
	 * 
	 * Search Criteria 2
	 * SearchType=N
	 * PartialSearchFlag=F
	 * 
	 * Search Criteria 3
	 * SearchType=N
	 * PartialSearchFlag=F
	 * 
	 * Search Criteria 4
	 * SearchType=N
	 * PartialSearchFlag=F
	 * 
	 * Search Criteria 5
	 * SearchType=I
	 * PartialSearchFlag=F
	 */
	public MemberGetMTVMemberInfoResp memberSearch (String correlationId, MemberGetMTVMemberInfoReq memberGetMtvMemberInfoReq) {
		log.info(correlationId + " - Starting member search.");
		
		/**
		 * Search Criteria 1
		 * MemberID
		 * ContractId
		 * DateOfBirth
		 */
		if (memberGetMtvMemberInfoReq.getMemberID() != null && memberGetMtvMemberInfoReq.getMemberID().trim().length() > 0) {
			if(memberGetMtvMemberInfoReq.getMemberDateOfBirth() != null && memberGetMtvMemberInfoReq.getMemberDateOfBirth().trim().length() > 0) {
				if (memberGetMtvMemberInfoReq.getContractID() != null && memberGetMtvMemberInfoReq.getContractID().trim().length() > 0) {
					MemberGetMTVMemberInfoResp resp = searchByMemberId(correlationId, memberGetMtvMemberInfoReq);
					if (resp != null) {
						return resp;
					}
				}
			}
		}
		/**
		 * Search Criteria 2
		 * ContractId
		 * DateOfBirth
		 */
		if (memberGetMtvMemberInfoReq.getContractID() != null && memberGetMtvMemberInfoReq.getContractID().trim().length() > 0) {
			if(memberGetMtvMemberInfoReq.getMemberDateOfBirth() != null && memberGetMtvMemberInfoReq.getMemberDateOfBirth().trim().length() > 0) {
				MemberGetMTVMemberInfoResp resp = searchByContractDOB(correlationId, memberGetMtvMemberInfoReq);
				if (resp != null) {
					return resp;
				}
			}			
		}
		/**
		 * Search Criteria 3
		 * ContractId
		 * LastName
		 * DateOfBirth
		 */
		if (memberGetMtvMemberInfoReq.getContractID() != null && memberGetMtvMemberInfoReq.getContractID().trim().length() > 0) {
			if(memberGetMtvMemberInfoReq.getMemberDateOfBirth() != null && memberGetMtvMemberInfoReq.getMemberDateOfBirth().trim().length() > 0) {
				if(memberGetMtvMemberInfoReq.getMemberLastName() != null && memberGetMtvMemberInfoReq.getMemberLastName().trim().length() > 0) {
					MemberGetMTVMemberInfoResp resp = searchByContractLNDOB(correlationId, memberGetMtvMemberInfoReq);
					if (resp != null) {
						return resp;
					}
				}
			}
		}
		/**
		 * Search Criteria 4
		 * ContractId
		 * FirstName
		 * LastName
		 */
		if (memberGetMtvMemberInfoReq.getContractID() != null && memberGetMtvMemberInfoReq.getContractID().trim().length() > 0) {
			if(memberGetMtvMemberInfoReq.getMemberFirstName() != null && memberGetMtvMemberInfoReq.getMemberFirstName().trim().length() > 0) {
				if(memberGetMtvMemberInfoReq.getMemberLastName() != null && memberGetMtvMemberInfoReq.getMemberLastName().trim().length() > 0) {
					MemberGetMTVMemberInfoResp resp = searchByContractFNLN(correlationId, memberGetMtvMemberInfoReq);
					if (resp != null) {
						return resp;
					}
				}
			}
		}

		/**
		 * Search Criteria 5
		 * FirstName
		 * LastName
		 * DateOfBirth
		 */
		if(memberGetMtvMemberInfoReq.getMemberFirstName() != null && memberGetMtvMemberInfoReq.getMemberFirstName().trim().length() > 0) {
			if(memberGetMtvMemberInfoReq.getMemberDateOfBirth() != null && memberGetMtvMemberInfoReq.getMemberDateOfBirth().trim().length() > 0) {
				if(memberGetMtvMemberInfoReq.getMemberLastName() != null && memberGetMtvMemberInfoReq.getMemberLastName().trim().length() > 0) {
					MemberGetMTVMemberInfoResp resp = searchByFNLNDOB(correlationId, memberGetMtvMemberInfoReq);
					if (resp != null) {
						return resp;
					}
				}
			}
		}

		log.info(correlationId + " - Finishing member search. No Member was able to be found.");
		// nothing found, populate error resp
		String contextString = "No Member Found";
		String reasonCode = "99";
		String returnCode = "99";
		String severityCode = "99";
		return buildGenericResponseError(correlationId, "GEN-006", contextString, reasonCode, returnCode, severityCode);
	}
	
	
	/**
	 * Search Criteria 1
	 * Search by MemberID
	 * @throws Exception 
	 */
	MemberGetMTVMemberInfoResp searchByMemberId(String correlationId, MemberGetMTVMemberInfoReq memberGetMtvMemberInfoReq) {
		try {
			log.info(correlationId + " - Have MemberId, ContractId, MemberDOB.  Attempting to call MTV API with this search criteria 1.");
			Pmbr1av3MemberSearchTImport memInfoImport = new Pmbr1av3MemberSearchTImport();
			memInfoImport.getImportImbr1Interface().setSearchType("I");
			memInfoImport.getImportImbr1Interface().setPartialSearchFlag("F");
			memInfoImport.getImportQualifyImbr1Member().setMemberId(memberGetMtvMemberInfoReq.getMemberID());
			memInfoImport.getImportQualifyImbr1Member().setContractId3(memberGetMtvMemberInfoReq.getContractID());
			memInfoImport.getImportQualifyImbr1Member().setTBirthDate(memberGetMtvMemberInfoReq.getMemberDateOfBirth());
			Pmbr1av3MemberSearchTExport memInfoExport = memberInfo.pmbr1av3MemberSearch_T(memInfoImport);
			log.info(correlationId + " Successfully called MTV API Member Search. parsing response");
			if (memInfoExport.getExportImbr1Interface().getReturnCode() != 1) {
				log.error(correlationId + " - Error: RESP-005 - MTV API call for Member Search resulted in an error.");
				return buildMtvMemberResponseError(correlationId, memInfoExport, "RESP-005");
			}

			if(memInfoExport.getExportMemberGroup().getRows().length > 1 && (!memberGetMtvMemberInfoReq.getMemberDateOfBirth().trim().equals(""))) {
				memInfoExport.getExportMemberGroup().setRows(sameNameCheck(correlationId, memInfoExport.getExportMemberGroup().getRows(), memberGetMtvMemberInfoReq.getMemberDateOfBirth()));
			}
			
			if (memInfoExport.getExportMemberGroup().getRows().length == 1) {
				// should have successful response, with 1 row returned
				for (ExportMemberGroupRow memberRow : memInfoExport.getExportMemberGroup().getRows()) {
					MemberGetMTVMemberInfoResp resp = buildSuccessResp(correlationId, memberRow);
					String network = getMemberNetwork(correlationId, memberRow);
					resp.getResult().getMember().get(0).setMemberNetworkID(network);
					return resp;
				}
			}
				
		} catch (Exception e) {
			log.error(correlationId + " - Exception in searchByMemberId of MemberSearchOrchestrationImpl: ", e);
			String contextString = "Exception in searchByMemberId with trying to call MTV API | " + e.getMessage();
			String reasonCode = "99";
			String returnCode = "99";
			String severityCode = "99";
			return buildGenericResponseError(correlationId, "GEN-005", contextString, reasonCode, returnCode, severityCode);
		}
		return null;
	}
	
	/**
	 * Search Criteria 4
	 * @param memberGetMtvMemberInfoReq
	 * @return
	 * @throws Exception
	 */
	private MemberGetMTVMemberInfoResp searchByContractFNLN(String correlationId, MemberGetMTVMemberInfoReq memberGetMtvMemberInfoReq) {
		try {
			log.info(correlationId + " - Have ContractId, FirstName, LastName.  Attempting to call MTV API with this search criteria 4.");
			Pmbr1av3MemberSearchTImport memInfoImport = new Pmbr1av3MemberSearchTImport();
			memInfoImport.getImportImbr1Interface().setSearchType("N");
			memInfoImport.getImportImbr1Interface().setPartialSearchFlag("F");
			memInfoImport.getImportQualifyImbr1Member().setContractId3(memberGetMtvMemberInfoReq.getContractID());
			memInfoImport.getImportQualifyImbr1Member().setCompleteFirstName(memberGetMtvMemberInfoReq.getMemberFirstName());
			memInfoImport.getImportQualifyImbr1Member().setCompleteLastName(memberGetMtvMemberInfoReq.getMemberLastName());
			Pmbr1av3MemberSearchTExport memInfoExport = memberInfo.pmbr1av3MemberSearch_T(memInfoImport);
			log.info(correlationId + " Successfully called MTV API Member Search. parsing response");
			if (memInfoExport.getExportImbr1Interface().getReturnCode() != 1) {
				log.error(correlationId + " - Error: RESP-004 - MTV API call for Member Search resulted in an error.");
				return buildMtvMemberResponseError(correlationId, memInfoExport, "RESP-004");
			}
			
			if(memInfoExport.getExportMemberGroup().getRows().length > 1 && (!memberGetMtvMemberInfoReq.getMemberDateOfBirth().trim().equals(""))) {
				memInfoExport.getExportMemberGroup().setRows(sameNameCheck(correlationId, memInfoExport.getExportMemberGroup().getRows(), memberGetMtvMemberInfoReq.getMemberDateOfBirth()));
			}
			
			if (memInfoExport.getExportMemberGroup().getRows().length == 1) {
				// should have successful response, with 1 row returned
				for (ExportMemberGroupRow memberRow : memInfoExport.getExportMemberGroup().getRows()) {
					MemberGetMTVMemberInfoResp resp = buildSuccessResp(correlationId, memberRow);
					String network = getMemberNetwork(correlationId, memberRow);
					resp.getResult().getMember().get(0).setMemberNetworkID(network);
					return resp;
				}
			}
				
		} catch (Exception e) {
			log.error(correlationId + " - Exception in searchByContractFNLN of MemberSearchOrchestrationImpl: ", e);
			String contextString = "Exception in searchByContractFNLN with trying to call MTV API | " + e.getMessage();
			String reasonCode = "99";
			String returnCode = "99";
			String severityCode = "99";
			return buildGenericResponseError(correlationId, "GEN-004", contextString, reasonCode, returnCode, severityCode);
		}
		return null;
		
		
	}
	
	/**
	 * Search Criteria 3
	 * @param memberGetMtvMemberInfoReq
	 * @return
	 * @throws Exception
	 */
	private MemberGetMTVMemberInfoResp searchByContractLNDOB(String correlationId, MemberGetMTVMemberInfoReq memberGetMtvMemberInfoReq) {
		try {
			log.info(correlationId + " - Have ContractId, LastName, DateOfBirth.  Attempting to call MTV API with this search criteria 3.");
			Pmbr1av3MemberSearchTImport memInfoImport = new Pmbr1av3MemberSearchTImport();
			memInfoImport.getImportImbr1Interface().setSearchType("N");
			memInfoImport.getImportImbr1Interface().setPartialSearchFlag("F");
			memInfoImport.getImportQualifyImbr1Member().setContractId3(memberGetMtvMemberInfoReq.getContractID());
			memInfoImport.getImportQualifyImbr1Member().setCompleteLastName(memberGetMtvMemberInfoReq.getMemberLastName());
			memInfoImport.getImportQualifyImbr1Member().setTBirthDate(memberGetMtvMemberInfoReq.getMemberDateOfBirth());
			Pmbr1av3MemberSearchTExport memInfoExport = memberInfo.pmbr1av3MemberSearch_T(memInfoImport);
			log.info(correlationId + " Successfully called MTV API Member Search. parsing response");
			if (memInfoExport.getExportImbr1Interface().getReturnCode() != 1) {
				log.error(correlationId + " - Error: RESP-003 - MTV API call for Member Search resulted in an error.");
				return buildMtvMemberResponseError(correlationId, memInfoExport, "RESP-003");
			}
			
			if(memInfoExport.getExportMemberGroup().getRows().length > 1 && (!memberGetMtvMemberInfoReq.getMemberDateOfBirth().trim().equals(""))) {
				memInfoExport.getExportMemberGroup().setRows(sameNameCheck(correlationId, memInfoExport.getExportMemberGroup().getRows(), memberGetMtvMemberInfoReq.getMemberDateOfBirth()));
			}
			
			if (memInfoExport.getExportMemberGroup().getRows().length == 1) {
				// should have successful response, with 1 row returned
				for (ExportMemberGroupRow memberRow : memInfoExport.getExportMemberGroup().getRows()) {
					MemberGetMTVMemberInfoResp resp = buildSuccessResp(correlationId, memberRow);
					String network = getMemberNetwork(correlationId, memberRow);
					resp.getResult().getMember().get(0).setMemberNetworkID(network);
					return resp;
				}
			}
				
		} catch (Exception e) {
			log.error(correlationId + " - Exception in searchByContractLNDOB of MemberSearchOrchestrationImpl: ", e);
			String contextString = "Exception in searchByContractLNDOB with trying to call MTV API | " + e.getMessage();
			String reasonCode = "99";
			String returnCode = "99";
			String severityCode = "99";
			return buildGenericResponseError(correlationId, "GEN-003", contextString, reasonCode, returnCode, severityCode);
		}
		return null;
		
		
	}
	
	
	/**
	 * Search Criteria 5
	 * @param memberGetMtvMemberInfoReq
	 * @return
	 * @throws Exception
	 */
	private MemberGetMTVMemberInfoResp searchByFNLNDOB(String correlationId, MemberGetMTVMemberInfoReq memberGetMtvMemberInfoReq)  {
		try {
			log.info(correlationId + " - Have FirstName, LastName, DateOfBirth.  Attempting to call MTV API with this search criteria 5.");
			Pmbr1av3MemberSearchTImport memInfoImport = new Pmbr1av3MemberSearchTImport();
			memInfoImport.getImportImbr1Interface().setSearchType("N");
			memInfoImport.getImportImbr1Interface().setPartialSearchFlag("F");
			memInfoImport.getImportQualifyImbr1Member().setCompleteFirstName(memberGetMtvMemberInfoReq.getMemberFirstName());
			memInfoImport.getImportQualifyImbr1Member().setCompleteLastName(memberGetMtvMemberInfoReq.getMemberLastName());
			memInfoImport.getImportQualifyImbr1Member().setTBirthDate(memberGetMtvMemberInfoReq.getMemberDateOfBirth());
			Pmbr1av3MemberSearchTExport memInfoExport = memberInfo.pmbr1av3MemberSearch_T(memInfoImport);
			log.info(correlationId + " Successfully called MTV API Member Search. parsing response");
			if (memInfoExport.getExportImbr1Interface().getReturnCode() != 1) {
				log.error(correlationId + " - Error: RESP-002 - MTV API call for Member Search resulted in an error.");
				return buildMtvMemberResponseError(correlationId, memInfoExport, "RESP-002");
			}
			
			if(memInfoExport.getExportMemberGroup().getRows().length > 1 && (!memberGetMtvMemberInfoReq.getMemberDateOfBirth().trim().equals(""))) {
				memInfoExport.getExportMemberGroup().setRows(sameNameCheck(correlationId, memInfoExport.getExportMemberGroup().getRows(), memberGetMtvMemberInfoReq.getMemberDateOfBirth()));
			}
			
			if (memInfoExport.getExportMemberGroup().getRows().length == 1) {
				// should have successful response, with 1 row returned
				for (ExportMemberGroupRow memberRow : memInfoExport.getExportMemberGroup().getRows()) {
					MemberGetMTVMemberInfoResp resp = buildSuccessResp(correlationId, memberRow);
					String network = getMemberNetwork(correlationId, memberRow);
					resp.getResult().getMember().get(0).setMemberNetworkID(network);
					return resp;
				}
			}
				
		} catch (Exception e) {
			log.error(correlationId + " - Exception in searchByFNLNDOB of MemberSearchOrchestrationImpl: ", e);
			String contextString = "Exception in searchByFNLNDOB with trying to call MTV API | " + e.getMessage();
			String reasonCode = "99";
			String returnCode = "99";
			String severityCode = "99";
			return buildGenericResponseError(correlationId, "GEN-002", contextString, reasonCode, returnCode, severityCode);
		}
		return null;
		
		
	}
	
	
	/**
	 * Search Criteria 2
	 * @param memberGetMtvMemberInfoReq
	 * @return
	 * @throws Exception
	 */
	private MemberGetMTVMemberInfoResp searchByContractDOB(String correlationId, MemberGetMTVMemberInfoReq memberGetMtvMemberInfoReq) {
		try {
			log.info(correlationId + " - Have ContractId, DateOfBirth.  Attempting to call MTV API with this search criteria 2.");
			Pmbr1av3MemberSearchTImport memInfoImport = new Pmbr1av3MemberSearchTImport();
			memInfoImport.getImportImbr1Interface().setSearchType("I");
			memInfoImport.getImportImbr1Interface().setPartialSearchFlag("F");
			memInfoImport.getImportQualifyImbr1Member().setContractId3(memberGetMtvMemberInfoReq.getContractID());
			memInfoImport.getImportQualifyImbr1Member().setTBirthDate(memberGetMtvMemberInfoReq.getMemberDateOfBirth());
			Pmbr1av3MemberSearchTExport memInfoExport = memberInfo.pmbr1av3MemberSearch_T(memInfoImport);
			log.info(correlationId + " Successfully called MTV API Member Search. parsing response");
			if (memInfoExport.getExportImbr1Interface().getReturnCode() != 1) {
				log.error(correlationId +" - Error: RESP-001 - MTV API call for Member Search resulted in an error.");
				return buildMtvMemberResponseError(correlationId, memInfoExport, "RESP-001");
			}
			
			if(memInfoExport.getExportMemberGroup().getRows().length > 1 && (!memberGetMtvMemberInfoReq.getMemberDateOfBirth().trim().equals(""))) {
				memInfoExport.getExportMemberGroup().setRows(sameNameCheck(correlationId, memInfoExport.getExportMemberGroup().getRows(), memberGetMtvMemberInfoReq.getMemberDateOfBirth()));
			}
			
			if (memInfoExport.getExportMemberGroup().getRows().length == 1) {
				// should have successful response, with 1 row returned
				for (ExportMemberGroupRow memberRow : memInfoExport.getExportMemberGroup().getRows()) {
					MemberGetMTVMemberInfoResp resp = buildSuccessResp(correlationId, memberRow);
					String network = getMemberNetwork(correlationId, memberRow);
					resp.getResult().getMember().get(0).setMemberNetworkID(network);
					return resp;
				}
			}
				
		} catch (Exception e) {
			log.error(correlationId + " - Exception in searchByContractDOB of MemberSearchOrchestrationImpl: ", e);
			String contextString = "Exception in searchByContractDOB with trying to call MTV API | " + e.getMessage();
			String reasonCode = "99";
			String returnCode = "99";
			String severityCode = "99";
			return buildGenericResponseError(correlationId, "GEN-001", contextString, reasonCode, returnCode, severityCode);
		}
		return null;
		
		
	}
	
	
	private ExportMemberGroupRow[] sameNameCheck (String correlationId, ExportMemberGroupRow[] rows, String dob) {
		log.info(correlationId + " - Starting same name check.");
		ArrayList<ExportMemberGroupRow> returnRows = new ArrayList<ExportMemberGroupRow>();
		// if dob of birth matches request dob, add row record to return Array
		for (int i=0; i < rows.length; i++) {
			if(rows[i].getExportGImbr1Member().getTBirthDate().equals(dob)) {
				returnRows.add(rows[i]);
			}
		}
		return returnRows.toArray(new ExportMemberGroupRow[returnRows.size()]);
	}
	
	
	private MemberGetMTVMemberInfoResp buildMtvMemberResponseError (String correlationId, Pmbr1av3MemberSearchTExport errorExport, String errorCode) {
		log.info(correlationId + " - Building MTV Response Error");
		MemberGetMTVMemberInfoResp errorResp = new MemberGetMTVMemberInfoResp();
		Error error = new Error();
		error.setErrorCode(errorCode);
		error.setContextString(errorExport.getExportImbr1Interface().getContextString());
		error.setReasonCode(String.valueOf(errorExport.getExportImbr1Interface().getReasonCode()));
		error.setReturnCode(String.valueOf(errorExport.getExportImbr1Interface().getReturnCode()));
		error.setSeverityCode(errorExport.getExportImbr1Interface().getSeverityCode());
		Result result = new Result();
		result.getError().add(error);
		Header header = new Header();
		header.setCorrelationID(correlationId);
		result.setHeader(header);
		errorResp.setResult(result);
		return errorResp;
	}
	
	private MemberGetMTVMemberInfoResp buildGenericResponseError (String correlationId, String errorCode, String contextString, String reasonCode, String returnCode, String severityCode) {
		log.info(correlationId + " - Building Generic Error");
		MemberGetMTVMemberInfoResp errorResp = new MemberGetMTVMemberInfoResp();
		Error error = new Error();
		error.setErrorCode(errorCode);
		error.setContextString(contextString);
		error.setReasonCode(reasonCode);
		error.setReturnCode(returnCode);
		error.setSeverityCode(severityCode);
		Result result = new Result();
		result.getError().add(error);
		Header header = new Header();
		header.setCorrelationID(correlationId);
		result.setHeader(header);
		errorResp.setResult(result);
		return errorResp;
	}
	
	private MemberGetMTVMemberInfoResp buildSuccessResp (String correlationId, ExportMemberGroupRow memberRow) {
		log.info(correlationId + " - Building Response object");
		MemberGetMTVMemberInfoResp matchResp = new MemberGetMTVMemberInfoResp();
		
		Member member = new Member();
		member.setContractID(memberRow.getExportGImbr1Member().getContractId3());
		member.setBenefitPackageID(memberRow.getExportGImbr1MemberEligibility().getBenefitPackageIdentifier());
		member.setBenefitPackageType(memberRow.getExportGImbr1MemberEligibility().getBenefitPackageTypeCode());
		member.setBusinessLevel4ID(memberRow.getExportGImbr1MemberEligibility().getBusinessLevel4Id());
		member.setBusinessLevel5ID(memberRow.getExportGImbr1MemberEligibility().getBusinessLevel5Id());
		member.setBusinessLevel6ID(memberRow.getExportGImbr1MemberEligibility().getBusinessLevel6Id());
		member.setBusinessLevel7ID(memberRow.getExportGImbr1MemberEligibility().getBusinessLevel7Id());
		member.setCoverageContractHolderFlag(memberRow.getExportGImbr1Member().getCoverageContractHolderFlag());
		member.setCrossReferenceFlag(memberRow.getExportGImbr1CoverageTypeSpan().getContractCrossRefFlag());
		member.setEffectiveDate(memberRow.getExportGImbr1MemberEligibility().getTEffectiveDate());
		member.setEffectiveDateMPNA(memberRow.getExportGImbr1MemberProvAssociation().getTEffectiveDate());
	    member.setEmployerGroupLevelID(memberRow.getExportGImbr1CoverageTypeSpan().getEmployerGroupLevel1Id());
	    member.setEndDate(memberRow.getExportGImbr1MemberEligibility().getTEndDate());
	    member.setEndDateMPNA(memberRow.getExportGImbr1MemberProvAssociation().getTEndDate());
	    member.setLineOfBusiness(memberRow.getExportGImbr1MemberEligibility().getLineOfBusiness());
	    member.setMemberClassCode(memberRow.getExportGImbr1MemberEligibility().getClassCode());
	    member.setMemberDateOfBirth(memberRow.getExportGImbr1Member().getTBirthDate());
	    member.setMemberFirstName(memberRow.getExportGImbr1Member().getCompleteFirstName());
	    member.setMemberID(memberRow.getExportGImbr1Member().getMemberId());
	    member.setMemberLastName(memberRow.getExportGImbr1Member().getCompleteLastName());
	    member.setMemberMiddleName(memberRow.getExportGImbr1Member().getCompleteMiddleName());
	    //member.setMemberNetworkID(value);  // populate after the Network Lookup
	    member.setMemberSexCode(memberRow.getExportGImbr1Member().getSexCode());
	    member.setMemberSuffix(memberRow.getExportGImbr1Member().getCompleteNameSuffix());
	    member.setMemberTitle(memberRow.getExportGImbr1Member().getCompletePersonTitle());
	    member.setMultipleBenefitPackageFlag(memberRow.getExportGImbr1MemberEligibility().getMultipleBenefitPkgsFlag());
	    member.setPersonID(memberRow.getExportGImbr1Member().getPersonIdentifier());
	    member.setProviderID(memberRow.getExportGImbr1MemberProvAssociation().getProviderIdentifier());
	    member.setProviderName(memberRow.getExportGImbr1MemberProvAssociation().getProviderName());
	    member.setRecordStatus(memberRow.getExportGImbr1Member().getRecordStatus());
	    member.setRemarksIndicator(memberRow.getExportGImbr1Member().getRemarksFlag());
	    member.setStatusCode(memberRow.getExportGImbr1MemberStatus().getStatusCode());
	    member.setTypeCode(memberRow.getExportGImbr1MemberEligibility().getTypeCode());
	    member.setVoidFlag(memberRow.getExportGImbr1MemberEligibility().getVoidFlag());
	    member.setZipCode(memberRow.getExportGIref1MetavanceAddress().getZip());
	    
		
	    Result result = new Result();
	    result.getMember().add(member);
	    
	    Error error = new Error();
	    error.setSeverityCode("I");
	    result.getError().add(error);
	    
	    
	    Header header = new Header();
		header.setCorrelationID(correlationId);
		result.setHeader(header);
		matchResp.setResult(result);
		return matchResp;
	}
	
	private String getMemberNetwork (String correlationId, ExportMemberGroupRow memberRow) {
		log.info(correlationId + " - Starting Network Lookup");
		Pmbr1dl4ListMemberNetworksTExport networkExport = searchMemberNetwork(memberRow.getExportGImbr1Member().getContractId3(), memberRow.getExportGImbr1Member().getMemberId(), memberRow.getExportGImbr1MemberEligibility().getTEffectiveDate(), memberRow.getExportGImbr1MemberEligibility().getTEndDate());
		log.info(correlationId + " Successfully called MTV API Member Network Lookup, parsing response");
		String networkId = "Error in Network Lookup"; // default value
		if (networkExport == null) {
			// default value if Lookup fails
			return networkId;
		} else if (networkExport.getExportImbr1Interface().getReturnCode() != 1) {
			log.error(correlationId + " - Error: RESP-006 - MTV API call for Member Network Lookup resulted in an error.");
			// Log error but do not fail, continue on with default value
			//return buildMtvNetworkResponseError(networkExport, "RESP-006");
		} else {					
			if (networkExport.getExportMemberNetworkGroup().getRows().length == 1 ) {
				for (ExportMemberNetworkGroupRow exportRow : networkExport.getExportMemberNetworkGroup().getRows()) {
					networkId = exportRow.getExportMemberNetworkGImbr1MemberProvAssociation().getNetworkIdentifier();
				}
			}
		}
		return networkId;
	}
	
	private Pmbr1dl4ListMemberNetworksTExport searchMemberNetwork(String contractId, String memberId, String effDate, String expDate) {
		
		try {
			Pmbr1dl4ListMemberNetworksTExport networkExport = 
					networkInfo.pmbr1dl4ListMemberNetworksT(contractId, memberId, effDate, expDate);
			return networkExport;
		} catch (Exception e) {
			// TODO
			log.error("Error: GEN-007 - Exception in searchMemberNetwork with trying to call MTV API. Continue On");
		}
		
		return null;
	}
}
