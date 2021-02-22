package br.com.app.domain.os;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NetworkParams {

	@Id
	private String id;
	private String hostName;
	private String domainName;
	private List<String> dnsServers;
	private String ipv4DefaultGateway;
	private String ipv6DefaultGateway;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public List<String> getDnsServers() {
		return dnsServers;
	}

	public void setDnsServers(List<String> dnsServers) {
		this.dnsServers = dnsServers;
	}

	public String getIpv4DefaultGateway() {
		return ipv4DefaultGateway;
	}

	public void setIpv4DefaultGateway(String ipv4DefaultGateway) {
		this.ipv4DefaultGateway = ipv4DefaultGateway;
	}

	public String getIpv6DefaultGateway() {
		return ipv6DefaultGateway;
	}

	public void setIpv6DefaultGateway(String ipv6DefaultGateway) {
		this.ipv6DefaultGateway = ipv6DefaultGateway;
	}

}
