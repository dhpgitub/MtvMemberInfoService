//package com.deanhealthplan.memberinfo.config;
//
//import java.util.ArrayList;
//import java.util.Map;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//@Configuration
//public class GSONConfiguration {
//
//	
//	@Bean
//	public Gson getGson(){
//		final GsonBuilder gsonBuilder = new GsonBuilder();
//	    gsonBuilder.setDateFormat("MM-dd-yy HH:mm:ss.SSS");
//	    gsonBuilder.setPrettyPrinting();
//	    gsonBuilder.serializeNulls();
//	    gsonBuilder.disableHtmlEscaping();
//	    final Gson gson = gsonBuilder.create();
//	    return gson;
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String json = "[" + 
//					 "  [" + 
//					 "    {" + 
//					 "      \"_oid\": \"Scope:1661:44359\"," + 
//					 "      \"Name\": \"Inf - PI 4\"," + 
//					 "      \"Workitems:Story[AssetState!=\\\"Closed\\\"].Estimate.@Sum\": \"774\"," + 
//					 "      \"Workitems:Story[AssetState=\\\"Closed\\\"].Estimate.@Sum\": \"104.5\"," + 
//					 "      \"Workitems:Story[Status.Name=\\\"Ready for Work\\\"].Estimate.@Sum\": \"226\"," + 
//					 "      \"Workitems:Story[Status.Name=\\\"Done\\\"].Estimate.@Sum\": \"81.5\"" + 
//					 "    }" + 
//					 "  ]," + 
//					 "  [" + 
//					 "    {" + 
//					 "      \"_oid\": \"Scope:1661:44359\"," + 
//					 "      \"Name\": \"Inf - PI 4\"," + 
//					 "      \"Workitems:Story[AssetState!=\\\"Closed\\\"].Estimate.@Sum\": \"702\"," + 
//					 "      \"Workitems:Story[AssetState=\\\"Closed\\\"].Estimate.@Sum\": \"179.5\"," + 
//					 "      \"Workitems:Story[Status.Name=\\\"Ready for Work\\\"].Estimate.@Sum\": \"223\"," + 
//					 "      \"Workitems:Story[Status.Name=\\\"Done\\\"].Estimate.@Sum\": \"156.5\"" + 
//					 "    }" + 
//					 "  ]," + 
//					 "  [" + 
//					 "    {" + 
//					 "      \"_oid\": \"Scope:1661:44359\"," + 
//					 "      \"Name\": \"Inf - PI 4\"," + 
//					 "      \"Workitems:Story[AssetState!=\\\"Closed\\\"].Estimate.@Sum\": \"318\"," + 
//					 "      \"Workitems:Story[AssetState=\\\"Closed\\\"].Estimate.@Sum\": \"693.5\"," + 
//					 "      \"Workitems:Story[Status.Name=\\\"Ready for Work\\\"].Estimate.@Sum\": \"106\"," + 
//					 "      \"Workitems:Story[Status.Name=\\\"Done\\\"].Estimate.@Sum\": \"664.5\"" + 
//					 "    }" + 
//					 "  ]" + 
//					 "]";
//		ArrayList<ArrayList<Map>>  a = new GSONConfiguration().getGson().fromJson(json, new ArrayList().getClass());
//
//		//ArrayList<ArrayList<Map>> topArray = new GSONConfiguration().getGson().fromJson(resultpt, new ArrayList().getClass());
//		System.out.println(a);
//	}
//}
