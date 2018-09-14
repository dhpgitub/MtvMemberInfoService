//package com.deanhealthplan.memberinfo.config;
//
//import java.util.Collection;
//import java.util.HashSet;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.ldap.core.DirContextOperations;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
//
//@Configuration
//@EnableWebSecurity()
//@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
//@Order(SecurityProperties.BASIC_AUTH_ORDER)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	final static Logger log = LogManager.getLogger(WebSecurityConfig.class);
//	final String READ_ONLY_SECURITY_GROUP = "APP_270_MEMBER_INFO";
//	
////	@Value("${ldapUrl}") 
////	String ldapURL;
////	@Value("${ldapConfig.ldapUser}") 
////	String ldapUser;
////	@Value("${ldapConfig.ldapPassword}") 
////	String ldapPassword;
//
////	@Value("${ldapConfig.readonly}") 
////	String readOnlySecurityGroup;
//	
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//    	httpSecurity.csrf().disable();
//    	
//    	httpSecurity
//    	.requestMatchers()
//    		.anyRequest()
//    		.and()
//        .authorizeRequests()
//        	.anyRequest().permitAll()
//            .and()
//        .httpBasic();	
//    }
//    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldap = auth.ldapAuthentication();
////        ldap.userSearchFilter("(sAMAccountName={0})" );
////        ldap.userSearchBase("OU=_DHP,DC=dhp,DC=ad,DC=deanhealth,DC=com");
////        ldap.groupSearchBase("OU=DHPGroups,OU=_DHP,DC=dhp,DC=ad,DC=deanhealth,DC=com");
////        ldap.groupSearchFilter("member={0}");
////        ldap.ldapAuthoritiesPopulator(new CustomLdapAuthoritiesPopulator());
////        ldap.contextSource().url(ldapURL).managerDn(ldapUser).managerPassword(ldapPassword);
//
//    }
//    
//    
////    class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
////		@Override
////		public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
////			Collection<GrantedAuthority> gas = new HashSet<GrantedAuthority>();
////			log.debug("*********************");
////			log.debug("***             Check  Role");
////			log.debug("***             "+ username);
////			for (String memberOf: userData.getStringAttributes("memberOf")) {
////				String role = memberOf.substring(memberOf.indexOf('=') + 1, memberOf.indexOf(',')).toUpperCase();
////				log.debug("******************* role : " + role + " - member of : " + memberOf);
//////				if (role.equalsIgnoreCase(readOnlySecurityGroup)) {
//////					log.debug("*************** Adding: " + READ_ONLY_SECURITY_GROUP + " when role : " + role + " is found" );
//////					gas.add(new SimpleGrantedAuthority(READ_ONLY_SECURITY_GROUP)); 
//////				}
////			}
////			log.debug("********************");
////			return gas;
////
////        }
//
////    }
//    
//}
