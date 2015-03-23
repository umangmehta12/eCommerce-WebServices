package com.edeal.service;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.edeal.base.Category;
import com.edeal.dao.CategoryDao;


@Path("/category")
public class CategoryService {
	CategoryDao dao = new CategoryDao();
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> findAll() {
		return dao.load();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Category find(@PathParam("id") int id) {
		return dao.load(id);
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Category create(Category category) {
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
	public void update(Category category) {
		dao.update(category);
	}
	
}
