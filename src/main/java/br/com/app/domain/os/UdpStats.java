package br.com.app.domain.os;

public class UdpStats {

	private Long datagramsSent;
    private Long datagramsReceived;
    private Long datagramsNoPort;
    private Long datagramsReceivedErrors;
	
    public Long getDatagramsSent() {
		return datagramsSent;
	}
	public void setDatagramsSent(Long datagramsSent) {
		this.datagramsSent = datagramsSent;
	}
	public Long getDatagramsReceived() {
		return datagramsReceived;
	}
	public void setDatagramsReceived(Long datagramsReceived) {
		this.datagramsReceived = datagramsReceived;
	}
	public Long getDatagramsNoPort() {
		return datagramsNoPort;
	}
	public void setDatagramsNoPort(Long datagramsNoPort) {
		this.datagramsNoPort = datagramsNoPort;
	}
	public Long getDatagramsReceivedErrors() {
		return datagramsReceivedErrors;
	}
	public void setDatagramsReceivedErrors(Long datagramsReceivedErrors) {
		this.datagramsReceivedErrors = datagramsReceivedErrors;
	}
    
    
    
}
