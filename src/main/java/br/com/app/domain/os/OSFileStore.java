package br.com.app.domain.os;

public class OSFileStore {

	private String name;

    private String volume;
    
    private String label;

    private String logicalVolume;
    
    private String mount;

    private String description;

    private String type;
    
    private String options;

    private String uuid;

    private String freeSpace;
    
    private Long usableSpace;

    private Long totalSpace;
    
    private Long freeInodes;
    
    private Long totalInodes;
    
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLogicalVolume() {
		return logicalVolume;
	}

	public void setLogicalVolume(String logicalVolume) {
		this.logicalVolume = logicalVolume;
	}

	public String getMount() {
		return mount;
	}

	public void setMount(String mount) {
		this.mount = mount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFreeSpace() {
		return freeSpace;
	}

	public void setFreeSpace(String freeSpace) {
		this.freeSpace = freeSpace;
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

	public Long getFreeInodes() {
		return freeInodes;
	}

	public void setFreeInodes(Long freeInodes) {
		this.freeInodes = freeInodes;
	}

	public Long getTotalInodes() {
		return totalInodes;
	}

	public void setTotalInodes(Long totalInodes) {
		this.totalInodes = totalInodes;
	}

}
