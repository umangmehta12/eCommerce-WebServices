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

import com.edeal.base.Preferredsite;
import com.edeal.dao.PreferredsiteDao;

@Path("/sites")
public class PreferredsiteService {
	PreferredsiteDao dao = new PreferredsiteDao();
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Preferredsite> findAll() {
		return dao.load();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Preferredsite find(@PathParam("id") int id) {
		return dao.load(id);
	}

	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Preferredsite create(Preferredsite category) {
		return dao.save(category);
	}
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		dao.remove(id);
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Preferredsite category) {
		dao.update(category);
	}	
}
