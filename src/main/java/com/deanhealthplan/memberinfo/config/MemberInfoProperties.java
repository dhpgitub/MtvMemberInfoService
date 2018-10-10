package com.deanhealthplan.memberinfo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Here to have a central location of dynamic variables coming from the yml file
 * @author jmenkk
 *
 */

@Component
@ConfigurationProperties("data")
@RefreshScope
public class MemberInfoProperties {

	
	//@Value("${data.MTVUSER}")
	private String MTVUSER;
	//@Value("${data.MTVPASSWORD}")
	private String MTVPASSWORD;
	//@Value("${data.MTVHOST}")
	private String MTVHOST;
	
	
	public String getMTVUSER() {
		return MTVUSER;
	}
	public void setMTVUSER(String mTVUSER) {
		MTVUSER = mTVUSER;
	}
	public String getMTVPASSWORD() {
		return MTVPASSWORD;
	}
	public void setMTVPASSWORD(String mTVPASSWORD) {
		MTVPASSWORD = mTVPASSWORD;
	}
	public String getMTVHOST() {
		return MTVHOST;
	}
	public void setMTVHOST(String mTVHOST) {
		MTVHOST = mTVHOST;
	}
	
	
//	
//	/**
//	 * Use this to create the Base64 strings to put in the yml secrets file for K8s
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		
//		String str = Base64.getEncoder().encodeToString(("asdf").getBytes());
//		System.out.println(str);
//		
//	}
	
}
