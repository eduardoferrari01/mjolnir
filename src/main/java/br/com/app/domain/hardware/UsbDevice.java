package br.com.app.domain.hardware;

import java.util.List;

public class UsbDevice {

	private String name;

	private String vendor;

	private String vendorId;

	private String productId;

	private String serialNumber;

	private List<UsbDevice> connectedDevices;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public List<UsbDevice> getConnectedDevices() {
		return connectedDevices;
	}

	public void setConnectedDevices(List<UsbDevice> connectedDevices) {
		this.connectedDevices = connectedDevices;
	}
	
	
	
}
