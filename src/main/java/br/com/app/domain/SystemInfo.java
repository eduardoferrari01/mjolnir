package br.com.app.domain;

import org.springframework.data.annotation.Id;

public class SystemInfo {

  @Id
  private String id;
  private String hash;
  private String platform;
  private OperatingSystem operatingSystem;
  private Hardware hardware;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public OperatingSystem getOperatingSystem() {
    return operatingSystem;
  }

  public void setOperatingSystem(OperatingSystem operatingSystem) {
    this.operatingSystem = operatingSystem;
  }

  public Hardware getHardware() {
    return hardware;
  }

  public void setHardware(Hardware hardware) {
    this.hardware = hardware;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

}
