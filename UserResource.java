package com.apex.resource;
import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.apex.service.UserService;
import com.apex.service.user.User;




//http://localhost:8080/user-api/api/user/v1/1
@Path("/user/v1")
public class UserResource {

	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void addUser(Use user) 
	{
		UserService service = new UserService();
		service.addUser(user);
	}
	
	@GET
	@Path("/{userid}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUser(@PathParam("userid") String id) {
		System.out.println("Start : UserResource: getUser()");
		UserService service = new UserService();
		User user = service.getUser(Integer.parseInt(id));
		System.out.println("END : UserResource:getUser()");
		return user;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void updateUser(User user) {
		UserService service = new UserService();
		service.updateUser(user);
	}
	
	@DELETE
	public void deleteUser(int id) {
		UserService service = new UserService();
		service.deleteUser(id);
	}

}