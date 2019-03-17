package org.koushik.javabrains.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorRequest {
	@Override
	public String toString() {
		return "ErrorRequest [errorMsg=" + errorMsg + ", url=" + url + ", lineNumber=" + lineNumber + ", key=" + key
				+ ", errorType=" + errorType + ", timeStamp=" + timeStamp + ", params=" + params + ", ajaxUrl="
				+ ajaxUrl + "]";
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getAjaxUrl() {
		return ajaxUrl;
	}
	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}
	private String errorMsg;
	private String url;
	private int lineNumber;
	private String key;
	private String errorType;
	private Date timeStamp;
	private String params;
	private String ajaxUrl;
}
