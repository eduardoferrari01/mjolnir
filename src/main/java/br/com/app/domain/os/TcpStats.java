package br.com.app.domain.os;

public class TcpStats {

	private Long connectionsEstablished;
    private Long connectionsActive;
    private Long connectionsPassive;
    private Long connectionFailures;
    private Long connectionsReset;
    private Long segmentsSent;
    private Long segmentsReceived;
    private Long segmentsRetransmitted;
    private Long inErrors;
    private Long outResets;
	
    public Long getConnectionsEstablished() {
		return connectionsEstablished;
	}
	public void setConnectionsEstablished(Long connectionsEstablished) {
		this.connectionsEstablished = connectionsEstablished;
	}
	public Long getConnectionsActive() {
		return connectionsActive;
	}
	public void setConnectionsActive(Long connectionsActive) {
		this.connectionsActive = connectionsActive;
	}
	public Long getConnectionsPassive() {
		return connectionsPassive;
	}
	public void setConnectionsPassive(Long connectionsPassive) {
		this.connectionsPassive = connectionsPassive;
	}
	public Long getConnectionFailures() {
		return connectionFailures;
	}
	public void setConnectionFailures(Long connectionFailures) {
		this.connectionFailures = connectionFailures;
	}
	public Long getConnectionsReset() {
		return connectionsReset;
	}
	public void setConnectionsReset(Long connectionsReset) {
		this.connectionsReset = connectionsReset;
	}
	public Long getSegmentsSent() {
		return segmentsSent;
	}
	public void setSegmentsSent(Long segmentsSent) {
		this.segmentsSent = segmentsSent;
	}
	public Long getSegmentsReceived() {
		return segmentsReceived;
	}
	public void setSegmentsReceived(Long segmentsReceived) {
		this.segmentsReceived = segmentsReceived;
	}
	public Long getSegmentsRetransmitted() {
		return segmentsRetransmitted;
	}
	public void setSegmentsRetransmitted(Long segmentsRetransmitted) {
		this.segmentsRetransmitted = segmentsRetransmitted;
	}
	public Long getInErrors() {
		return inErrors;
	}
	public void setInErrors(Long inErrors) {
		this.inErrors = inErrors;
	}
	public Long getOutResets() {
		return outResets;
	}
	public void setOutResets(Long outResets) {
		this.outResets = outResets;
	}
    
    
}
