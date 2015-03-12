package com.bhonzo.shooter;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Soldier extends GameEntity {
	
	
	private float health = 100;
	private Weapon weapon = null;
	private Sprite sprite = null; 

	public Soldier(float health , Sprite sprite) {
		// TODO Auto-generated constructor stub
		this.health = health;
		this.sprite = sprite;  
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
	public void draw(SpriteBatch batch){
	
		if(sprite!=null)
		{
			sprite.setPosition(this.getPosition().x, this.getPosition().y);
			sprite.setRotation(getHeading().angle());
			sprite.draw(batch);
		}
	}

}
