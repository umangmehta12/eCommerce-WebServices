package com.edeal.service;

import javax.ws.rs.*;

@Path("/test")
public class TestService {

	@GET
	@Path("/")
	public String returnTest() {
//		Test test = new Test(4,"name1");
	return "<h1>Test</h1>";	
	}

}