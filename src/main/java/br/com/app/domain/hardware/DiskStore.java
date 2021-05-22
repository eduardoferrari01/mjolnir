package br.com.app.domain.hardware;

import java.util.List;

public class DiskStore {

	private String name;
	private String model;
	private String serial;
	private Long size;
	private Long reads;
	private Long readBytes;
	private Long writes;
	private Long writeBytes;
	private Long currentQueueLength;
	private Long transferTime;
	private List<Partition> partitions;
	private Long timeStamp;
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getReads() {
		return reads;
	}

	public void setReads(Long reads) {
		this.reads = reads;
	}

	public Long getReadBytes() {
		return readBytes;
	}

	public void setReadBytes(Long readBytes) {
		this.readBytes = readBytes;
	}

	public Long getWrites() {
		return writes;
	}

	public void setWrites(Long writes) {
		this.writes = writes;
	}

	public Long getWriteBytes() {
		return writeBytes;
	}

	public void setWriteBytes(Long writeBytes) {
		this.writeBytes = writeBytes;
	}

	public Long getCurrentQueueLength() {
		return currentQueueLength;
	}

	public void setCurrentQueueLength(Long currentQueueLength) {
		this.currentQueueLength = currentQueueLength;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Long transferTime) {
		this.transferTime = transferTime;
	}

	public List<Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(List<Partition> partitions) {
		this.partitions = partitions;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
