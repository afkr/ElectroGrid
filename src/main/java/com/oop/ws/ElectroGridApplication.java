package com.oop.ws;
import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath; 

@ApplicationPath("/")
public class ElectroGridApplication extends ResourceConfig {               

    public ElectroGridApplication() {
        packages("com.oop.ws");
    }
}