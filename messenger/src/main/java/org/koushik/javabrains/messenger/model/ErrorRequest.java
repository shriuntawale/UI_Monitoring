package org.koushik.javabrains.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorRequest {
	private int lineNumber;
	private String errorType;
	private String errorMessage;
	  
	public ErrorRequest(){
		
	}

	public ErrorRequest(int lineNumber, String errorType, String errorMessage) {
		super();
		this.lineNumber = lineNumber;
		this.errorType = errorType;
		this.errorMessage = errorMessage;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
