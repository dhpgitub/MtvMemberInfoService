package com.deanhealthplan.memberinfo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.deanhealthplan.memberinfo.service.impl.MemberInfoImpl;

@Component
public class HealthCheck implements HealthIndicator {

	@Autowired 
	private MemberInfoImpl memberInfo;
	
	@Override
	public Health health() {
		try {
			//memberInfo.pmbr1av3MemberSearch_T(memInfoImport)("12345");
			if (true) {
				return Health.up().withDetail("MTV CALL", "SUCCESS").build();
			}
		} catch (Exception e) {
			return Health.down().withDetail("MTV CALL", "FAILURE").build();
		}
		return Health.down().withDetail("MTV CALL", "FAILURE").build();
	}
	

}
