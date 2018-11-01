package com.yantra.auto.yrms.data;

public class MachineFingerPrint {
	private String ipAddress;

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	private String macAddress;

	public String getMacAddress() {
		return this.macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	private String operatingSystem;

	public String getOperatingSystem() {
		return this.operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	private String webBrowser;

	public String getWebBrowser() {
		return this.webBrowser;
	}

	public void setWebBrowser(String webBrowser) {
		this.webBrowser = webBrowser;
	}
}