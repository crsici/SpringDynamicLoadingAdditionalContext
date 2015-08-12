package com.trungp.test;

public class Hawaii {
	private Vehicle vehicle;
	private Gas gas;
	
	public void hello(){
		System.out.println("Going to Hawaii by "+ vehicle.getName());
		gas.print();
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Gas getGas() {
		return gas;
	}

	public void setGas(Gas gas) {
		this.gas = gas;
	}
}
