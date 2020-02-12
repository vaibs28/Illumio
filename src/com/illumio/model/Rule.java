package com.illumio.model;

//model to store the Rule data
public class Rule {

    private String direction;
    private String protocol;
    private Port port;
    private IPAddress ipAddress;

    public Rule(String direction, String protocol, Port port, IPAddress ipAddress) {
	super();
	this.direction = direction;
	this.protocol = protocol;
	this.port = port;
	this.ipAddress = ipAddress;
    }

    public String getDirection() {
	return direction;
    }

    public void setDirection(String direction) {
	this.direction = direction;
    }

    public String getProtocol() {
	return protocol;
    }

    public void setProtocol(String protocol) {
	this.protocol = protocol;
    }

    public Port getPort() {
	return port;
    }

    public void setPort(Port port) {
	this.port = port;
    }

    public IPAddress getIpAddress() {
	return ipAddress;
    }

    public void setIpAddress(IPAddress ipAddress) {
	this.ipAddress = ipAddress;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((direction == null) ? 0 : direction.hashCode());
	result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
	result = prime * result + ((port == null) ? 0 : port.hashCode());
	result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
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
	Rule other = (Rule) obj;
	if (direction == null) {
	    if (other.direction != null)
		return false;
	} else if (!direction.equals(other.direction))
	    return false;
	if (ipAddress == null) {
	    if (other.ipAddress != null)
		return false;
	} else if (!ipAddress.equals(other.ipAddress))
	    return false;
	if (port == null) {
	    if (other.port != null)
		return false;
	} else if (!port.equals(other.port))
	    return false;
	if (protocol == null) {
	    if (other.protocol != null)
		return false;
	} else if (!protocol.equals(other.protocol))
	    return false;
	return true;
    }

}
