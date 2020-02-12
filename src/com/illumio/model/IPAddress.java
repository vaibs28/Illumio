package com.illumio.model;

public class IPAddress {

    private String startIP;
    private String endIP;
    
    public IPAddress(String startIP) {
	super();
	this.startIP = startIP;
    }

    public IPAddress(String startIP, String endIP) {
	super();
	this.startIP = startIP;
	this.endIP = endIP;
    }

    public String getStartIP() {
	return startIP;
    }

    public void setStartIP(String startIP) {
	this.startIP = startIP;
    }

    public String getEndIP() {
	return endIP;
    }

    public void setEndIP(String endIP) {
	this.endIP = endIP;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((endIP == null) ? 0 : endIP.hashCode());
	result = prime * result + ((startIP == null) ? 0 : startIP.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	IPAddress other = (IPAddress) obj;
	if (endIP == null) {
	    if (other.endIP != null)
		return false;
	} else if (!endIP.equals(other.endIP))
	    return false;
	if (startIP == null) {
	    if (other.startIP != null)
		return false;
	} else if (!startIP.equals(other.startIP))
	    return false;
	return true;
    }

}
