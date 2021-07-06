package br.com.app.dto.os;

public class OsProcessInformation {

	private Long pid;
	private Long ppid;
	private Long threads;
	private Double cpu;
	private Double cumulative;
	private Double vsz;
	private Double rss;
	private Double memory;
	private String processName;
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getPpid() {
		return ppid;
	}
	public void setPpid(Long ppid) {
		this.ppid = ppid;
	}
	public Long getThreads() {
		return threads;
	}
	public void setThreads(Long threads) {
		this.threads = threads;
	}
	public Double getCpu() {
		return cpu;
	}
	public void setCpu(Double cpu) {
		this.cpu = cpu;
	}
	public Double getCumulative() {
		return cumulative;
	}
	public void setCumulative(Double cumulative) {
		this.cumulative = cumulative;
	}
	public Double getVsz() {
		return vsz;
	}
	public void setVsz(Double vsz) {
		this.vsz = vsz;
	}
	public Double getRss() {
		return rss;
	}
	public void setRss(Double rss) {
		this.rss = rss;
	}
	public Double getMemory() {
		return memory;
	}
	public void setMemory(Double memory) {
		this.memory = memory;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
}
