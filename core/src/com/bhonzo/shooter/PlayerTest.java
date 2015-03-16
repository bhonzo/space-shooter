package com.bhonzo.shooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PlayerTest extends Sprite {// movement velocity
		private Vector2 velocity = new Vector2();		
		private float speed = 60 * 2;
		private float gravity = 60 * 1.8f;
		Sprite 					sprite;
		Texture 				texture;
		
	public PlayerTest(float health) {
			super(health);
			sprite 	= 	new Sprite(new Texture("enemy.png"));	
		}
	
	public void draw(SpriteBatch batch){
		update(Gdx.graphics.getDeltaTime());
		sprite.draw(batch);
	}
	
	public void update(float delta){
		// apply gravity
		velocity.y -= gravity * delta;
		// clamp velocity
		if(velocity.y > speed)
			velocity.y = speed;
		else if(velocity.y < speed)
			velocity.y = -speed;
		
		setX(getX() + velocity.x * delta);
		setY(getY() + velocity.y * delta);
	}
}