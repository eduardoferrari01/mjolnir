package br.com.app.domain.hardware;

import java.util.List;

public class Memory {

	private Long total;
	private Long available;
	private Long pageSize;
	private VirtualMemory virtualMemory;
	private List<PhysicalMemory> physicalMemory;
	
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
