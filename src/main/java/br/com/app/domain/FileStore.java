package br.com.app.domain;

public class FileStore {

	private String name;

    private String volume;

    private String mountPoint;

    private String description;

    private String fsType;

    private String uuid;

    private Long usableSpace;

    private Long totalSpace;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public String getMountPoint() {
		return mountPoint;
	}

	public void setMountPoint(String mountPoint) {
		this.mountPoint = mountPoint;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFsType() {
		return fsType;
	}

	public void setFsType(String fsType) {
		this.fsType = fsType;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getUsableSpace() {
		return usableSpace;
	}

	public void setUsableSpace(Long usableSpace) {
		this.usableSpace = usableSpace;
	}

	public Long getTotalSpace() {
		return totalSpace;
	}

	public void setTotalSpace(Long totalSpace) {
		this.totalSpace = totalSpace;
	}
    
    
}
