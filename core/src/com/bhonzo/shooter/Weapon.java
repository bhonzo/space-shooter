package com.bhonzo.shooter;

public class Weapon  extends GameEntity{

	
	private int numCurrentAmmo = 0; 
	private int maxAmmoCapacity = 0; 
	private float firingRate = 1; 
	private long lastTimeFired = 0;

	public Weapon(int numInitialAmmo, int maxAmmoCapacity, float firingRate) {
		// TODO Auto-generated constructor stub
		this.numCurrentAmmo = numInitialAmmo; 
		this.maxAmmoCapacity = maxAmmoCapacity; 
		this.firingRate = firingRate;
	}

	public boolean isReady() {
		// TODO Auto-generated method stub
		
		float time = 1/firingRate; //sec
		//sec to milli 
		time = time*1000; 
		
		if(System.currentTimeMillis()-this.lastTimeFired>time)
		return true;
		
		return false; 
	}

	public int getNumberOfCurentAmmo() {
		// TODO Auto-generated method stub
		return this.numCurrentAmmo;
	}

	public void fire() {
		// TODO Auto-generated method stub
		this.numCurrentAmmo--;
		
	}

	public int getAmmoCapacity() {
		// TODO Auto-generated method stub
		return this.maxAmmoCapacity;
	}

	public float getFiringRate() {
		// TODO Auto-generated method stub
		return this.firingRate;
	}

	public void reload() {
		// TODO Auto-generated method stub
		this.numCurrentAmmo = this.getAmmoCapacity();
		
	}

}
