package br.com.app.domain.os;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OSSession {

	@Id
	private String id;
	private String userName;
	private String terminalDevice;
	private Long loginTime;
	private String host;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTerminalDevice() {
		return terminalDevice;
	}
	public void setTerminalDevice(String terminalDevice) {
		this.terminalDevice = terminalDevice;
	}
	public Long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
}