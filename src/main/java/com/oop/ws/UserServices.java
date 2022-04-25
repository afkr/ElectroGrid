/*
 * package com.ws;
 * 
 * import javax.ws.rs.ApplicationPath;
 * 
 * import com.sun.jersey.api.core.ResourceConfig;
 * 
 * @ApplicationPath("/") public class UserServices extends ResourceConfig {
 * 
 * public UserServices() { packages("com.ws"); } }
 */

package com.oop.ws;

import java.util.ArrayList;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oop.bll.UserBLL;
import com.oop.model.ReturnObject;
import com.oop.model.User;
import com.oop.utils.Utilities;



@Path("/Users")
@ApplicationPath("api")
public class UserServices extends Application{
	
	//http://localhost:8080/Electro-Grid/api/Users/sayHello
	@GET
	@Path("/sayHello")
	public String getHelloMsg() {
		return "Hello";
	}
	
	//http://localhost:8080/Electro-Grid/api/Users/all
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("all")
	public Response GetAll() {
		ArrayList<User> userList = new UserBLL().GetListOfUsers();
		
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(userList).build();
	}
	
	//http://localhost:8080/Electro-Grid/api/Users/get
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("get")
	public Response Get(@QueryParam("tel") String tel) {
		User user = new UserBLL().GetUserByTel(tel);	
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(user).build();

	}
	
	//http://localhost:8080/Electro-Grid/api/Users/save
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	@Path("save")
	public Response Save(@FormParam("Name") String name,
			@FormParam("Address") String address,
			@FormParam("MobileNumber") String mobileNumber) {
		User user = new User(name, address, mobileNumber);
		new UserBLL().CreateUser(user);	
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(obj).build();
	}
	
	//http://localhost:8080/Electro-Grid/api/Users/edit
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	@Path("edit")
	public Response Edit(@FormParam("UserId") int id,
			@FormParam("Name") String name,
			@FormParam("Address") String address,
			@FormParam("MobileNumber") String mobileNumber
			) {
		User user = new User(id, name, address, mobileNumber);
		new UserBLL().EditUser(user);
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(obj).build();
	}
	
	//http://localhost:8080/Electro-Grid/api/Users/delete
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("delete")
	public Response Delete(@QueryParam("UserId") int id) {
		new UserBLL().DeleteUser(id);
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(obj).build();
	}

}
