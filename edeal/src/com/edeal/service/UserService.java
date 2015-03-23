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



import com.edeal.base.User;
import com.edeal.dao.UserDao;

@Path("/user")
public class UserService {

	UserDao dao = new UserDao();
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll() {
		return dao.load();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User find(@PathParam("id") int id) {
		return dao.load(id);
	}
	
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User create(User user) {
		return dao.save(user);
	}
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		dao.remove(id);
	}
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(User user) {
		dao.update(user);
	}
	
}
