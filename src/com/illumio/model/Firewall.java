package com.illumio.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Firewall {

    String fileName;
    private Set<Rule> ruleSet = new HashSet<>();

    public Firewall() {
	super();
    }

    public Firewall(String fileName) throws IOException {
	// read the contents of the file and add to the ruleSet
	BufferedReader br = new BufferedReader(new FileReader(fileName));
	String line = "";
	while ((line = br.readLine()) != null) {
	    addToRuleset(line);
	}
	br.close();
    }

    private void addToRuleset(String line) {
	String[] ruleArr = line.split(",");
	String direction = ruleArr[0];
	String protocol = ruleArr[1];
	String port = ruleArr[2];
	String ip = ruleArr[3];

	String[] portArray = port.split("-");
	String portStart = portArray[0];
	String portEnd = null;
	if (portArray.length == 2)
	    portEnd = portArray[1];
	Port portObj;
	String[] ipArray = ip.split("-");
	String ipStart = ipArray[0];
	String ipEnd = null;
	if (ipArray.length == 2)
	    ipEnd = ipArray[1];
	IPAddress ipObj;
	if (portEnd == null)
	    portObj = new Port(Integer.parseInt(portStart));
	else
	    portObj = new Port(Integer.parseInt(portStart), Integer.parseInt(portEnd));

	if (ipEnd == null)
	    ipObj = new IPAddress(ipStart);
	else
	    ipObj = new IPAddress(ipStart, ipEnd);

	Rule rule = new Rule(direction, protocol, portObj, ipObj);
	ruleSet.add(rule);
    }

    public Set<Rule> getRuleSet() {
	return ruleSet;
    }

    public void setRuleSet(Set<Rule> ruleSet) {
	this.ruleSet = ruleSet;
    }

}
