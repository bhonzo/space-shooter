package com.bhonzo.shooter;

import com.badlogic.gdx.math.Vector2;

public class GameEntity {
	
	private static int nextID = 0; 
	private final int id; 
	private final Vector2 position ; 
	private final Vector2 heading ; 
	public GameEntity()
	{id = nextID++;
	
	position = new Vector2(0,0); 
	heading = new Vector2(1,0); 
		
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setPosition(Vector2 newpos) {
		// TODO Auto-generated method stub
		position.set(newpos); 
	}

	public Vector2 getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	public void setHeading(Vector2 newheading) {
		// TODO Auto-generated method stub
		this.heading.set(newheading);
		
	}
	public Vector2 getHeading()
	{
		return this.heading;
	}

}
