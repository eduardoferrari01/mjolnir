package br.com.app.domain;

import org.springframework.data.annotation.Id;

import br.com.app.domain.operatingsystem.OperatingSystem;

public class SystemInfo {

  @Id
  private String id;
  private String hash;
  private String platform;
  private OperatingSystem operatingSystem;
 

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
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

}
