package com.oop.ws;

import java.util.ArrayList;

import com.oop.bll.NoticeBLL;
import com.oop.bll.PowerConsumptionBLL;
import com.oop.model.Notice;
import com.oop.model.PowerConsumption;
import com.oop.model.ReturnObject;
import com.oop.utils.Utilities;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/PowerConsumption")
@ApplicationPath("api")
public class PowerConsumptionWS extends Application{
	//http://localhost:8080/ElectroGrid/api/PowerConsumption/sayHello
	@GET
	@Path("/sayHello")
	public String getHelloMsg() {
		return "Hello";
	}
	
	//http://localhost:8080/ElectroGrid/api/PowerConsumption/all
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("all")
	public Response GetAll() {
		ArrayList<PowerConsumption> powerConsumptionList = new PowerConsumptionBLL().GetListOfPowerConsumptions();
		
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(powerConsumptionList).build();
	}
	
	//http://localhost:8080/ElectroGrid/api/PowerConsumption/get
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("get")
	public Response Get(@QueryParam("tel") String tel) {
		new PowerConsumptionBLL().GetPowerConsumptionByTel(tel);	
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(obj).build();

	}
	
	//http://localhost:8080/ElectroGrid/api/PowerConsumption/save
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("save")
	public Response Save(PowerConsumption powerConsumption) {
		new PowerConsumptionBLL().CreatePowerConsumption(powerConsumption);	
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(obj).build();
	}
	
	//http://localhost:8080/ElectroGrid/api/PowerConsumption/edit
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("edit")
	public Response Edit(PowerConsumption powerConsumption) {
		new PowerConsumptionBLL().EditPowerConsumption(powerConsumption);
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(obj).build();
	}
	
	//http://localhost:8080/ElectroGrid/api/PowerConsumption/delete
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("delete")
	public Response Delete(@QueryParam("id") int id) {
		new PowerConsumptionBLL().DeletePowerConsumption(id);
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(obj).build();
	}
}
