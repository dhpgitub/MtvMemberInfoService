package com.deanhealthplan.memberinfo.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

@Configuration
public class CacheConfig {
	   @Bean
	     public CacheManager cacheManager() {
	         // configure and return an implementation of Spring's CacheManager SPI
	         SimpleCacheManager cacheManager = new SimpleCacheManager();
	         
	         GuavaCache cache1 = new GuavaCache("default", CacheBuilder.newBuilder().build());
	         GuavaCache cacheTb = new GuavaCache("eventCodes", 
	        		 CacheBuilder.newBuilder()
	        		 .expireAfterWrite(30, TimeUnit.MINUTES)
	        		 .build());
	         
	         
	         cacheManager.setCaches(
	        		 Arrays.asList(
	        				 cache1, 
	        				 cacheTb,
	        				 new GuavaCache("event-identifiers-by-type", 
	        		        		 CacheBuilder.newBuilder()
	        		        		 .expireAfterWrite(60, TimeUnit.MINUTES)
	        		        		 .build()),
	        				 new GuavaCache("event-search-by-type", 
		    		        		 CacheBuilder.newBuilder()
		    		        		 .expireAfterAccess(10, TimeUnit.MINUTES)
		    		        		 .build())
		    				 )
			         );
	         
	         return cacheManager;
	     }
}
