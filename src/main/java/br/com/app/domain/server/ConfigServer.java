package br.com.app.domain.server;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

public class ConfigServer implements Serializable {

  private static final long serialVersionUID = -3273685045015629520L;

  @Id
  private Long id;

  private String serverHost = "http://localhost";

  private Integer porta = 8081;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getServerHost() {
    return serverHost;
  }

  public void setServerHost(String serverHost) {
    this.serverHost = serverHost;
  }

  public Integer getPorta() {
    return porta;
  }

  public void setPorta(Integer porta) {
    this.porta = porta;
  }

  public String getURL() {
    StringBuilder url = new StringBuilder();

    url.append(getServerHost());
    url.append(":");
    url.append(porta);
    return url.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ConfigServer other = (ConfigServer) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }


}
