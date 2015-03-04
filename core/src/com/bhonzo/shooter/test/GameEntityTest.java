package com.bhonzo.shooter.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.bhonzo.shooter.GameEntity;

public class GameEntityTest {

	@Test
	public void setUniqueID(){
		
		GameEntity entity1 = new GameEntity(); 
		GameEntity entity2 = new GameEntity(); 
		assertEquals("id is unique ", entity1.getID()== entity2.getID() , false);

		
	}
	@Test
	public void setPostionTest(){
		
		GameEntity entity1 = new GameEntity(); 
		entity1.setPosition(new Vector2(4,2)); 
		
		assertEquals(entity1.getPosition().x == 4, true); 
		assertEquals(entity1.getPosition().y== 2,true); 
	}
	@Test 
	public void directionTest()
	{
		GameEntity entity1 = new GameEntity(); 
		entity1.setHeading(new Vector2(0,1)); 
		
		assertEquals(entity1.getHeading().x == 0, true); 
		assertEquals(entity1.getHeading().y== 1,true); 
	}
	

}
