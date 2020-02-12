package com.illumio.model;

public class Port {

    private int startPortnumber;
    private int endPortnumber;

    public Port(int startPortnumber) {
	super();
	this.startPortnumber = startPortnumber;
    }
    
    public Port(int startPortnumber, int endPortnumber) {
	super();
	this.setStartPortnumber(startPortnumber);
	this.setEndPortnumber(endPortnumber);
    }

    public int getEndPortnumber() {
	return endPortnumber;
    }

    public void setEndPortnumber(int endPortnumber) {
	this.endPortnumber = endPortnumber;
    }

    public int getStartPortnumber() {
	return startPortnumber;
    }

    public void setStartPortnumber(int startPortnumber) {
	this.startPortnumber = startPortnumber;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + endPortnumber;
	result = prime * result + startPortnumber;
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
	Port other = (Port) obj;
	if (endPortnumber != other.endPortnumber)
	    return false;
	if (startPortnumber != other.startPortnumber)
	    return false;
	return true;
    }

}
