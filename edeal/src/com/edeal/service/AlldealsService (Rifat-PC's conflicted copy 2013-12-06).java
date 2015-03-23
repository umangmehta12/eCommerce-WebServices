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

import com.edeal.base.Alldeal;
import com.edeal.dao.AlldealsDao;


@Path("/alldeals")
public class AlldealsService {
	AlldealsDao dao = new AlldealsDao();
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alldeal> findAll() {
		return dao.load();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alldeal find(@PathParam("id") int id) {
		return dao.load(id);
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Alldeal create(Alldeal alldeal) {
		return dao.save(alldeal);
	}
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		dao.remove(id);
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Alldeal alldeal) {
		dao.update(alldeal);
	}
}
