package br.com.app.domain.os;

public class OSVersionInfo {

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
}
