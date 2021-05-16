package br.com.app.domain.os;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OSVersionInfo {

	@Id
	private String id;
	private String version;
	private String codeName;
	private String buildNumber;
	private String versionStr;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getBuildNumber() {
		return buildNumber;
	}
	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}
	public String getVersionStr() {
		return versionStr;
	}
	public void setVersionStr(String versionStr) {
		this.versionStr = versionStr;
	}
	
	public String getVersionInfo() {
		
		StringBuilder versionStr = new StringBuilder();
		versionStr.append(getVersion());
		versionStr.append(" ");
		versionStr.append(getCodeName());
		versionStr.append(" ");
		versionStr.append(getBuildNumber());
		
		return versionStr.toString();
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
		OSVersionInfo other = (OSVersionInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
