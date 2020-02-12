package com.illumio.application;

import com.illumio.service.FirewallServiceImpl;

public class Application {

    public static void main(String[] args) {
	// app entry point
	String filePath = "/Users/vaibhav/eclipse-workspace/com.vaibhav.illumiochallenge/src/com/illumio/resources/rules.csv";
	FirewallServiceImpl service = new FirewallServiceImpl();
	service.init(filePath); // initialize the ruleset by reading from the csv file
	System.out.print(service.accept_packet("outbound", "tcp", 10000, "192.168.10.12"));
    }

}
