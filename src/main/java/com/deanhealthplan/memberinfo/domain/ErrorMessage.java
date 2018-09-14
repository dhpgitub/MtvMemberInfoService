package com.deanhealthplan.memberinfo.domain;

public class ErrorMessage {


	String returnCode; // = "1"
	String severityCode; // = "I"
	String contextString; // = ""
	String message;
	String stacktrace;

	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getSeverityCode() {
		return severityCode;
	}
	public void setSeverityCode(String severityCode) {
		this.severityCode = severityCode;
	}
	public String getContextString() {
		return contextString;
	}
	public void setContextString(String contextString) {
		this.contextString = contextString;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStacktrace() {
		return stacktrace;
	}
	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}
	
	
	
	
}
