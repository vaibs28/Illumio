package com.illumio.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.illumio.service.FirewallServiceImpl;

public class UnitTest {
    static FirewallServiceImpl service;

    @BeforeClass
    public static void init() {
	String filePath = "/Users/vaibhav/eclipse-workspace/com.vaibhav.illumiochallenge/src/com/illumio/resources/rules.csv";
	service = new FirewallServiceImpl();
	service.init(filePath); // initialize the ruleset by reading from the csv file
    }

    @Test
    public void testWithSinglePortandIPSuccess() {
	boolean expected = true;
	boolean actual = service.accept_packet("inbound", "tcp", 80, "192.168.1.2");
	Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithSinglePortandIPFailureOnWrongDirection() {
	boolean expected = false;
	boolean actual = service.accept_packet("outbound", "tcp", 80, "192.168.1.2");
	Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testWithSinglePortandIPFailureOnWrongProtocol() {
	boolean expected = false;
	boolean actual = service.accept_packet("inbound", "udp", 80, "192.168.1.2");
	Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testWithSinglePortandIPFailureOnWrongPort() {
	boolean expected = false;
	boolean actual = service.accept_packet("inbound", "tcp", 90, "192.168.1.2");
	Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testWithSinglePortandIPFailureOnWrongIP() {
	boolean expected = false;
	boolean actual = service.accept_packet("inbound", "tcp", 80, "192.168.1.3");
	Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testWithSinglePortandIPFailureOnLastIP() {
	boolean expected = false;
	boolean actual = service.accept_packet("inbound", "tcp", 80, "255.255.255.255");
	Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testWithPortandIPRange() {
	boolean expected = true;
	boolean actual = service.accept_packet("inbound", "udp", 53, "255.255.255.255");
	Assert.assertEquals(expected, actual);
    }
    
}
