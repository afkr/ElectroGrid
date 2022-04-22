package com.oop.bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.oop.model.PowerConsumption;
import com.oop.repository.PowerConsumptionRepository;

public class PowerConsumptionBLL {
	public void CreatePowerConsumption(PowerConsumption powerConsumption) {
		powerConsumption.setUserId(1);
		powerConsumption.setUnits(1);
		powerConsumption.setBillDate(new Date());
		powerConsumption.setMobileNumber("123");
		new PowerConsumptionRepository().CreatePowerConsumption(powerConsumption);	
	}
	
	public void EditPowerConsumption(PowerConsumption powerConsumption) {
		new PowerConsumptionRepository().EditPowerConsumption(powerConsumption);
	}
	
	public void DeletePowerConsumption(int id) {
		new PowerConsumptionRepository().DeletePowerConsumption(id);
	}
	
	
	
	public PowerConsumption GetPowerConsumptionByTel(String tel){
		PowerConsumption powerConsumption= new PowerConsumptionRepository().GetPowerConsumptionByTel(tel);
		return powerConsumption;
	}

	public ArrayList<PowerConsumption> GetListOfPowerConsumptions(){
		ArrayList<PowerConsumption> powerConsumptionList = new PowerConsumptionRepository().GetListOfPowerConsumptions();
		return powerConsumptionList;
	}
}
