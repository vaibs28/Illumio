package com.illumio.service;

public interface IFirewallService {

    void init(String fileName);
    
    boolean accept_packet(String direction, String protocol, int port, String ipAddress);

}
