package br.com.app.domain.os;

public class InternetProtocolStats {

	private String id;
	
	private TcpStats tcpV4Stats;
	
	private TcpStats tcpV6Stats;
	
	private UdpStats udpV4Stats;
	
	private UdpStats udpV6Stats;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TcpStats getTcpV4Stats() {
		return tcpV4Stats;
	}

	public void setTcpV4Stats(TcpStats tcpV4Stats) {
		this.tcpV4Stats = tcpV4Stats;
	}

	public TcpStats getTcpV6Stats() {
		return tcpV6Stats;
	}

	public void setTcpV6Stats(TcpStats tcpV6Stats) {
		this.tcpV6Stats = tcpV6Stats;
	}

	public UdpStats getUdpV4Stats() {
		return udpV4Stats;
	}

	public void setUdpV4Stats(UdpStats udpV4Stats) {
		this.udpV4Stats = udpV4Stats;
	}

	public UdpStats getUdpV6Stats() {
		return udpV6Stats;
	}

	public void setUdpV6Stats(UdpStats udpV6Stats) {
		this.udpV6Stats = udpV6Stats;
	}
	
	
}
