//package com.deanhealthplan.memberinfo.config;
//
//import java.util.Scanner;
//
//import org.jasypt.encryption.StringEncryptor;
//import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
//import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
//import org.jasypt.spring31.properties.EncryptablePropertySourcesPlaceholderConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//
//import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
//
//@Configuration
//@EnableEncryptableProperties
//@PropertySources(value={
//		@PropertySource(value="application_${environment:default}.properties")
//})
//public class PropertiesConfig {
//	
//    @Bean(name="environmentVariablesConfiguration")
//    public EnvironmentStringPBEConfig environmentVariablesConfiguration() {
//        final EnvironmentStringPBEConfig configurer = new EnvironmentStringPBEConfig();
//        configurer.setAlgorithm("PBEWithMD5AndDES");//PBEWithMD5AndTripleDES
//        configurer.setPassword("dhp-event-viewer-254682448244583a");
//        return configurer;
//    }
//    
//    @Bean(name="stringEncryptor")    
//    public StringEncryptor stringEncryptor() {
//        final StandardPBEStringEncryptor configurer = new StandardPBEStringEncryptor();
//        configurer.setConfig(environmentVariablesConfiguration());
//        return configurer;
//    }
//    
//    @Bean(name="propertySourcesPlaceholderConfigurer")   
//    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//    	PropertySourcesPlaceholderConfigurer psp = new EncryptablePropertySourcesPlaceholderConfigurer(stringEncryptor());
//    	return psp;
//    }
//
////	public static void main(String[] args) {
////		
////
////		String pass = null;
////		if(args.length == 1){
////			pass = args[1];
////		}else{ 
////			// create a scanner so we can read the command-line input
////			@SuppressWarnings("resource")
////			Scanner scanner = new Scanner(System.in);	
////		    //  prompt for the user's name
////		    System.out.print("Password To Encrypt: ");
////
////		    // get their input as a String
////		    pass = scanner.next();
////		}
////		
////		PropertiesConfig cfp = new PropertiesConfig();
////		StringEncryptor strEnc = cfp.stringEncryptor();
////		String encrypted = strEnc.encrypt(pass);
////		System.out.print("Enter the following in the property file: ");
////		System.out.print("ENC(" + encrypted + ")");
////
////		
////	}
////    
//}