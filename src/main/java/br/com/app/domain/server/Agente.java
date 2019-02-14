package br.com.app.domain.server;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

public class Agente implements Serializable {

  private static final long serialVersionUID = -7771131969650057398L;

  @Id
  private Long id;
  private String ip;
  private String hash;
  private String hostName;
  private Integer tempoEspera = 3;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public Integer getTempoEspera() {
    return tempoEspera;
  }

  public void setTempoEspera(Integer tempoEspera) {
    this.tempoEspera = tempoEspera;
  }


}
