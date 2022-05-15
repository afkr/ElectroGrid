package com.oop.ws;

import java.util.ArrayList;
import java.util.Date;
import com.oop.bll.PowerConsumptionBLL;
import com.oop.bll.TransactionBLL;
import com.oop.model.PowerConsumption;
import com.oop.model.ReturnObject;
import com.oop.model.Transaction;
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

@Path("/Transaction")
@ApplicationPath("api")
public class PaymentmanagementApplication extends Application{

	//http://localhost:8080/ElectroGrid/api/Transaction/get
		@Produces(MediaType.APPLICATION_JSON)
		@GET
		@Path("get")
		public Response Get(@QueryParam("cardnumber") int cardnumber) {
			Transaction transaction = new TransactionBLL().GetTransactionByCardholdername(cardnumber);
			ReturnObject obj = new ReturnObject();
			obj.Status = Utilities.resultStatus.success.toString();
			return Response.ok(transaction).build();

		}
	
	
	//http://localhost:8080/ElectroGrid/api/Transaction/all
		@Produces(MediaType.APPLICATION_JSON)
		@GET
		@Path("all")
		public Response GetAll() {
			ArrayList<Transaction > transactionlist= new TransactionBLL().GetListOfTransactions();
			
			ReturnObject obj = new ReturnObject();
			obj.Status = Utilities.resultStatus.success.toString();
			return Response.ok(transactionlist).build();
		}
	
	
	
	
	//http://localhost:8080/ElectroGrid/api/Transaction/save
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@POST
		@Path("save")
		public Response Save(@FormParam("userid") String userId,
				@FormParam("transactionAmount") double transactionAmount,
				@FormParam("cardtype") String cardtype,
				@FormParam("cardnumber") int cardnumber,
				@FormParam("expirydate") Date expirydate,
				@FormParam("cardholdername") String cardholdername,
				@FormParam("code") int code) {
			Transaction transaction = new Transaction( userId , transactionAmount , cardtype ,cardnumber , expirydate , cardholdername, code);
			new TransactionBLL().CreateTransaction(transaction);;	
			ReturnObject obj = new ReturnObject();
			obj.Status = Utilities.resultStatus.success.toString();
			return Response.ok(obj).build();
		}
	
	
	
	
	
	
	//http://localhost:8080/ElectroGrid/api/Transaction/edit
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@POST
		@Path("edit")
		public Response Edit(@FormParam("id") String id,
				@FormParam("userid") String userId,
				@FormParam("transactionAmount") double transactionAmount,
				@FormParam("cardtype") String cardtype,
				@FormParam("cardnumber") int cardnumber,
				@FormParam("expirydate") Date expirydate,
				@FormParam("cardholdername") String cardholdername,
				@FormParam("code") int code
				) {
			Transaction transaction = new Transaction(id , userId , transactionAmount , cardtype ,cardnumber , expirydate , cardholdername, code);
			new TransactionBLL().EditTransaction(transaction);;
			ReturnObject obj = new ReturnObject();
			obj.Status = Utilities.resultStatus.success.toString();
			return Response.ok(obj).build();
		}
	
	
	
	
	
	
	//http://localhost:8080/ElectroGrid/api/Transaction/delete
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("delete")
	public Response Delete(@QueryParam("id") int id) {
		new TransactionBLL().DeleteTransaction(id);
		ReturnObject obj = new ReturnObject();
		obj.Status = Utilities.resultStatus.success.toString();
		return Response.ok(obj).build();
	}

}
