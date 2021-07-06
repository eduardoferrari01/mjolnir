package br.com.app.domain.hardware;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Memory {

	@Id
	private String id;
	private Long total;
	private Long available;
	private Long pageSize;
	private VirtualMemory virtualMemory;
	private List<PhysicalMemory> physicalMemory;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getAvailable() {
		return available;
	}
	public void setAvailable(Long available) {
		this.available = available;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public VirtualMemory getVirtualMemory() {
		return virtualMemory;
	}
	public void setVirtualMemory(VirtualMemory virtualMemory) {
		this.virtualMemory = virtualMemory;
	}
	public List<PhysicalMemory> getPhysicalMemory() {
		return physicalMemory;
	}
	public void setPhysicalMemory(List<PhysicalMemory> physicalMemory) {
		this.physicalMemory = physicalMemory;
	}

}
