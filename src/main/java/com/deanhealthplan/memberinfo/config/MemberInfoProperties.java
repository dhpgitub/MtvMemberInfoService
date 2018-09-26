package com.deanhealthplan.memberinfo.config;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Here to have a central location of dynamic variables coming from the yml file
 * @author jmenkk
 *
 */
@Component
public class MemberInfoProperties {

	@Value("${mtv.mtvUser}")
	private String mtvUser;
	@Value("${mtv.mtvPassword}")
	private String mtvPassword;
	@Value("${mtv.mtvUrl}")
	private String mtvUrl;
	
	
	public String getMtvUser() {
		return mtvUser;
	}
	public String getMtvPassword() {
		return mtvPassword;
	}
	public String getMtvUrl() {
		return mtvUrl;
	}

	
	/**
	 * Use this to create the Base64 strings to put in the yml secrets file for K8s
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = Base64.getEncoder().encodeToString(("asdf").getBytes());
		System.out.println(str);
		
	}
	
}
