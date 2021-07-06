package br.com.app.domain.os;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class InternetProtocolStats {

	@Id
	private String id;
	private TcpStats tcpv4Stats;
	private TcpStats tcpv6Stats;
	private UdpStats udpv4Stats;
	private UdpStats udpv6Stats;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TcpStats getTcpv4Stats() {
		return tcpv4Stats;
	}

	public void setTcpv4Stats(TcpStats tcpv4Stats) {
		this.tcpv4Stats = tcpv4Stats;
	}

	public TcpStats getTcpv6Stats() {
		return tcpv6Stats;
	}

	public void setTcpv6Stats(TcpStats tcpv6Stats) {
		this.tcpv6Stats = tcpv6Stats;
	}

	public UdpStats getUdpv4Stats() {
		return udpv4Stats;
	}

	public void setUdpv4Stats(UdpStats udpv4Stats) {
		this.udpv4Stats = udpv4Stats;
	}

	public UdpStats getUdpv6Stats() {
		return udpv6Stats;
	}

	public void setUdpv6Stats(UdpStats udpv6Stats) {
		this.udpv6Stats = udpv6Stats;
	}
}
