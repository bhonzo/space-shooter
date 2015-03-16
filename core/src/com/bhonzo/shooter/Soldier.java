package com.bhonzo.shooter;

import com.badlogic.gdx.InputProcessor;

public class Soldier extends GameEntity implements InputProcessor{
	
	
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


	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
