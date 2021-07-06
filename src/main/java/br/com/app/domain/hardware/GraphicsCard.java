package br.com.app.domain.hardware;

public class GraphicsCard {

	private String name;

	private String deviceId;

	private String vendor;

	private String versionInfo;

	private Long vram;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public Long getVram() {
		return vram;
	}

	public void setVram(Long vram) {
		this.vram = vram;
	}

}
