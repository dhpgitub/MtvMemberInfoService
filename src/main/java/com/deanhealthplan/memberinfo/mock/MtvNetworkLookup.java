package com.deanhealthplan.memberinfo.mock;

import org.springframework.stereotype.Component;

import com.eds.metavance.membership.Pmbr1av3MemberSearchTExport.ExportGImbr1MemberProvAssociation;
import com.eds.metavance.membership.Pmbr1dl4ListMemberNetworksTExport;
import com.eds.metavance.membership.Pmbr1dl4ListMemberNetworksTExport.ExportMemberNetworkGroupRow;

@Component
public class MtvNetworkLookup {

	
	
	public Pmbr1dl4ListMemberNetworksTExport mtvNetworkSearch(String contractId) {
		
		Pmbr1dl4ListMemberNetworksTExport networkExport = new Pmbr1dl4ListMemberNetworksTExport();
		
		networkExport.getExportImbr1Interface().setReturnCode(1);
		contractId = contractId.trim();
		
		if(contractId.equals("000250603")) {
			ExportMemberNetworkGroupRow row = new ExportMemberNetworkGroupRow();
			row.getExportMemberNetworkGImbr1MemberProvAssociation().setNetworkIdentifier("PREVEA");
			ExportMemberNetworkGroupRow[] rows = new ExportMemberNetworkGroupRow[1];
			rows[0] = row;
			networkExport.getExportMemberNetworkGroup().setRows(rows);
			return networkExport;
		}
		
		networkExport.getExportImbr1Interface().setReturnCode(-10);
		networkExport.getExportImbr1Interface().setContextString("No Network Found");
		return networkExport;
		
	}
	
	
	
}
