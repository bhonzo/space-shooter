package com.bhonzo.shooter;

public class Soldier extends GameEntity {
	
	
	private float health = 100;
	private Weapon weapon = null; 

	public Soldier(float health) {
		// TODO Auto-generated constructor stub
		this.health = health; 
	}
	
	
	public float getHealth()
	{
		return this.health; 
	}
	public void setHealth(float health)
	{
		this.health = health; 
		
	}
	public boolean shoot() 
	{
		if(this.hasWeapon()&&weapon.isReady()&&weapon.getNumberOfCurentAmmo()>0)
		{
			weapon.fire(); 
		}
		return false; 
	}
	public void setWeapon(Weapon weapon)
	{
		this.weapon = weapon; 
	}
	public boolean hasWeapon()
	{
		return weapon != null; 
	}

}
