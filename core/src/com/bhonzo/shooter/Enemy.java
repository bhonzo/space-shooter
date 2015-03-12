package com.bhonzo.shooter;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;


public class Enemy extends Soldier { 
    private Vector2 target = new Vector2(); 
    private float speed =  10; 
	public Enemy(float health , float walkingspeed , Sprite sprite) {
		super(health,sprite);
		this.speed = walkingspeed; 
		// TODO Auto-generated constructor stub
	}
	
	public boolean isTargetInSight(Vector2 target)
	{
		//if the target is less than 100 m
		if(target.dst(this.getPosition())<=100)
		{
			//if we lookin at the target ..right in front
			if(this.isFacingTarget(target))
				return true; 
		}
		
		return false; 
	}

	public boolean isFacingTarget(Vector2 target) {
		// TODO Auto-generated method stub
		
		if(this.getHeading().dot(target)>0)
			return true; 
		
		return false;
	}
	public void setTarget(Vector2 newTarget)
	{
		this.target = newTarget; 
	}
	public Vector2 getTarget()
	{
		return this.target; 
	}
	public void setSpeed(float newspeed)
	{
		this.speed = newspeed; 
	}
	public float getSpeed()
	{
		return this.speed;
	}
	public void update(float ds)
	{
		
		if(this.isActive())
		{
			if(!this.hasReachedTarget(target))
			followTarget(target, ds);
			else selectRandomTarget();
		}
	}
	/** 
	 * 
	 * just for testing 
	 */
	private void selectRandomTarget() {
		// TODO Auto-generated method stub
		target = new Vector2((float)(Math.random()*400),(float)(Math.random()*400));
	}

	private boolean hasReachedTarget(Vector2 target)
	{
		if(target.dst2(this.getPosition())<4)
			return true; 
		
		return false; 
	}

	private void followTarget(Vector2 target, float ds) {
		// TODO Auto-generated method stub
		Vector2 velocity =new Vector2(target).sub(this.getPosition()).nor().scl(getSpeed());
		
		if(velocity.len()>0.01f)
		{
		this.setHeading(velocity);
		this.setPosition(this.getPosition().add(velocity.scl(ds)));
		}

		
	}

}
