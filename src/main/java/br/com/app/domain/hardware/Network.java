package br.com.app.domain.hardware;

import java.util.List;

public class Network {
	
	private String name;
	private String displayName;
	private Integer mtu;
	private String macaddr;
	private List<String> ipv4addr;
	private List<String> subnetMasks;
	private List<String> ipv6addr;
	private List<Short> prefixLengths;
	private Integer ifType;
	private Integer ndisPhysicalMediumType;
	private Boolean connectorPresent;
	private Long bytesRecv;
	private Long bytesSent;
	private Long packetsRecv;
	private Long packetsSent;
	private Long inErrors;
	private Long outErrors;
	private Long inDrops;
	private Long collisions;
	private Long speed;
	private Long timeStamp;
	private Boolean knownVmMacAddr;
	private Boolean updateAttributes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Integer getMtu() {
		return mtu;
	}
	public void setMtu(Integer mtu) {
		this.mtu = mtu;
	}
	public String getMacaddr() {
		return macaddr;
	}
	public void setMacaddr(String macaddr) {
		this.macaddr = macaddr;
	}
	public List<String> getIpv4addr() {
		return ipv4addr;
	}
	public void setIpv4addr(List<String> ipv4addr) {
		this.ipv4addr = ipv4addr;
	}
	public List<String> getSubnetMasks() {
		return subnetMasks;
	}
	public void setSubnetMasks(List<String> subnetMasks) {
		this.subnetMasks = subnetMasks;
	}
	public List<String> getIpv6addr() {
		return ipv6addr;
	}
	public void setIpv6addr(List<String> ipv6addr) {
		this.ipv6addr = ipv6addr;
	}
	public List<Short> getPrefixLengths() {
		return prefixLengths;
	}
	public void setPrefixLengths(List<Short> prefixLengths) {
		this.prefixLengths = prefixLengths;
	}
	public Integer getIfType() {
		return ifType;
	}
	public void setIfType(Integer ifType) {
		this.ifType = ifType;
	}
	public Integer getNdisPhysicalMediumType() {
		return ndisPhysicalMediumType;
	}
	public void setNdisPhysicalMediumType(Integer ndisPhysicalMediumType) {
		this.ndisPhysicalMediumType = ndisPhysicalMediumType;
	}
	public Boolean getConnectorPresent() {
		return connectorPresent;
	}
	public void setConnectorPresent(Boolean connectorPresent) {
		this.connectorPresent = connectorPresent;
	}
	public Long getBytesRecv() {
		return bytesRecv;
	}
	public void setBytesRecv(Long bytesRecv) {
		this.bytesRecv = bytesRecv;
	}
	public Long getBytesSent() {
		return bytesSent;
	}
	public void setBytesSent(Long bytesSent) {
		this.bytesSent = bytesSent;
	}
	public Long getPacketsRecv() {
		return packetsRecv;
	}
	public void setPacketsRecv(Long packetsRecv) {
		this.packetsRecv = packetsRecv;
	}
	public Long getPacketsSent() {
		return packetsSent;
	}
	public void setPacketsSent(Long packetsSent) {
		this.packetsSent = packetsSent;
	}
	public Long getInErrors() {
		return inErrors;
	}
	public void setInErrors(Long inErrors) {
		this.inErrors = inErrors;
	}
	public Long getOutErrors() {
		return outErrors;
	}
	public void setOutErrors(Long outErrors) {
		this.outErrors = outErrors;
	}
	public Long getInDrops() {
		return inDrops;
	}
	public void setInDrops(Long inDrops) {
		this.inDrops = inDrops;
	}
	public Long getCollisions() {
		return collisions;
	}
	public void setCollisions(Long collisions) {
		this.collisions = collisions;
	}
	public Long getSpeed() {
		return speed;
	}
	public void setSpeed(Long speed) {
		this.speed = speed;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Boolean getKnownVmMacAddr() {
		return knownVmMacAddr;
	}
	public void setKnownVmMacAddr(Boolean knownVmMacAddr) {
		this.knownVmMacAddr = knownVmMacAddr;
	}
	public Boolean getUpdateAttributes() {
		return updateAttributes;
	}
	public void setUpdateAttributes(Boolean updateAttributes) {
		this.updateAttributes = updateAttributes;
	}
}
