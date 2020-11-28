package br.com.app.domain.hardware;

public class VirtualMemory {

	private Long swapTotal;
	private Long swapUsed;
	private long virtualMax;
	private long virtualInUse;
	private long swapPagesIn;
	private long SwapPagesOut;
	
	public Long getSwapTotal() {
		return swapTotal;
	}
	public void setSwapTotal(Long swapTotal) {
		this.swapTotal = swapTotal;
	}
	public Long getSwapUsed() {
		return swapUsed;
	}
	public void setSwapUsed(Long swapUsed) {
		this.swapUsed = swapUsed;
	}
	public long getVirtualMax() {
		return virtualMax;
	}
	public void setVirtualMax(long virtualMax) {
		this.virtualMax = virtualMax;
	}
	public long getVirtualInUse() {
		return virtualInUse;
	}
	public void setVirtualInUse(long virtualInUse) {
		this.virtualInUse = virtualInUse;
	}
	public long getSwapPagesIn() {
		return swapPagesIn;
	}
	public void setSwapPagesIn(long swapPagesIn) {
		this.swapPagesIn = swapPagesIn;
	}
	public long getSwapPagesOut() {
		return SwapPagesOut;
	}
	public void setSwapPagesOut(long swapPagesOut) {
		SwapPagesOut = swapPagesOut;
	}
	
}
