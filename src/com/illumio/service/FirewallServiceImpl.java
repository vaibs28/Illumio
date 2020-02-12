package com.illumio.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.illumio.model.Firewall;
import com.illumio.model.Rule;

public class FirewallServiceImpl implements IFirewallService {

    Firewall firewall;

    @Override
    public boolean accept_packet(String direction, String protocol, int port, String ipAddress) {
	Set<Rule> ruleSet = firewall.getRuleSet();
	Iterator<Rule> iter = ruleSet.iterator();
	while (iter.hasNext()) {	//iterate over the ruleset and check if the passed rule is valid
	    Rule rule = iter.next();
	    if (isValid(rule, direction, protocol, port, ipAddress))
		return true;
	}
	return false;
    }

    private boolean isValid(Rule rule, String direction, String protocol, int port, String ipAddress) {
	String dir = rule.getDirection();
	String prtcl = rule.getProtocol();
	int portStart = rule.getPort().getStartPortnumber();
	int portEnd = rule.getPort().getEndPortnumber();
	String ipStart = rule.getIpAddress().getStartIP();
	String ipEnd = rule.getIpAddress().getEndIP();

	if (dir.equals(direction) && prtcl.equals(protocol) && isValidPort(port, portStart, portEnd)
		&& isValid(ipAddress, ipStart, ipEnd))
	    return true;

	return false;
    }

    private boolean isValidPort(int port, int portStart, int portEnd) {
	if (portEnd == 0) {
	    // just check for port start
	    if (port == portStart)
		return true;
	    else
		return false;
	}
	return (port >= portStart && port <= portEnd);
    }

    private boolean isValid(String ipAddress, String ipStart, String ipEnd) {
	if (ipEnd == null) {
	    //just check for ipstart
	    return ipAddress.equals(ipStart);
	}
	if (ipAddress.compareTo(ipStart) >= 0 && ipAddress.compareTo(ipEnd) <= 0)
	    return true;
	return false;
    }

    @Override
    public void init(String fileName) {

	try {
	    // initialize the rule set
	    firewall = new Firewall(fileName);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}
