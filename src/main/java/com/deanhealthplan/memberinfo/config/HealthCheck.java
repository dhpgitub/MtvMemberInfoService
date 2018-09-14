package com.deanhealthplan.memberinfo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

	//@Autowired 
	//private ClaimInfoImpl claimInfo;
	
	@Override
	public Health health() {
		try {
			//claimInfo.phcl1dl4_Detail_Claim_T("12345");
			
			return Health.up().withDetail("MTV CALL", "SUCCESS").build();
		} catch (Exception e) {
			return Health.down().withDetail("MTV CALL", "FAILURE").build();
		}
	}
	

}
