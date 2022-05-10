package com.oop.bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.oop.model.PowerConsumption;
import com.oop.model.PowerConsumptionDto;
import com.oop.repository.PowerConsumptionRepository;

public class PowerConsumptionBLL {
	public void CreatePowerConsumption(PowerConsumption powerConsumption) {
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

	public ArrayList<PowerConsumptionDto> GetListOfPowerConsumptions(){
		ArrayList<PowerConsumptionDto> powerConsumptionList = new PowerConsumptionRepository().GetListOfPowerConsumptions();
		return powerConsumptionList;
	}
}
