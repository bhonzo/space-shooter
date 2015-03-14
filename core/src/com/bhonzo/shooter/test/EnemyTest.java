package com.bhonzo.shooter.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;
import com.bhonzo.shooter.Enemy;
import com.bhonzo.shooter.Player;

public class EnemyTest {

	@Test
	public void facingPlayerTest() {
		
		
		Enemy enemy 		= 		new Enemy(100,10); 	
		Vector2 target 		= 		new Vector2(100,100);
		Vector2 target2 	= 		new Vector2(-100,-100);
		enemy.setHeading(new Vector2(1,1));
		
        assertEquals(enemy.isFacingTarget(target)&&!enemy.isFacingTarget(target2),true);
		
		
	}
	
	@Test
	public void lineOfSightTest()
	{
		Enemy enemy 		= 		new Enemy(100,10); 
		Vector2 target 		= 		new Vector2(0,100);
		Vector2 target2 	= 		new Vector2(0,-100);
		Vector2 target3 	= 		new Vector2(-50,-50);
		
		enemy.setHeading(new Vector2(0,-1));
		assertEquals(enemy.isTargetInSight(target),false);
		assertEquals(enemy.isTargetInSight(target2),true);
		assertEquals(enemy.isTargetInSight(target3),true);
		
	}

}
