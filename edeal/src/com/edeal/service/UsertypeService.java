package com.edeal.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.edeal.base.Usertype;
import com.edeal.dao.UsertypeDao;

@Path("/usertype")
public class UsertypeService {
	UsertypeDao dao = new UsertypeDao();
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usertype> findAll() {
		return dao.load();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usertype find(@PathParam("id") int id) {
		return dao.load(id);
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Usertype create(Usertype usertype) {
		return dao.save(usertype);
	}
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		dao.remove(id);
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Usertype usertype) {
		dao.update(usertype);
	}
	
}
