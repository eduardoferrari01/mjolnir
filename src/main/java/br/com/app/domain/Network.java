package br.com.app.domain;

import java.util.List;

public class Network {

  private String name;
  private String displayName;
  private String mac;
  private List<String> ipv4;
  private List<String> ipv6;
  private Integer mtu;
  private Long bytesRecv;
  private Long bytesSent;
  private Long packetsRecv;
  private Long packetsSent;
  private Long inErrors;
  private Long outErrors;
  private Long speed;
  private Long timeStamp;

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

  public String getMac() {
    return mac;
  }

  public void setMac(String mac) {
    this.mac = mac;
  }

  public List<String> getIpv4() {
    return ipv4;
  }

  public void setIpv4(List<String> ipv4) {
    this.ipv4 = ipv4;
  }

  public List<String> getIpv6() {
    return ipv6;
  }

  public void setIpv6(List<String> ipv6) {
    this.ipv6 = ipv6;
  }

  public Integer getMtu() {
    return mtu;
  }

  public void setMtu(Integer mtu) {
    this.mtu = mtu;
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



}
