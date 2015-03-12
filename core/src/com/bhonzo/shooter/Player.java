package com.bhonzo.shooter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


@SuppressWarnings("unused")
public class Player extends Soldier {
	Rectangle bottom, left, right, top;

	int action;
	float velocity;

	public Player(float health ,Sprite sprite) {
		super(health ,sprite);
		bottom = new Rectangle(0.0f, 0.0f, 128.0f, 128.0f);
		
	}

	public int hits(Rectangle r){
		if(bottom.overlaps(r)){
			return 1;
		}
		return -1;
	}
	
	public void action(int type){
				
	}
	
	public void update(float delta){
		
	}
	
	
	public void setPosition(Vector2 newpos){
		bottom.x = newpos.x;
		bottom.y = newpos.y;
		super.setPosition(newpos);
	}
	
	public void moveLeft(float delta){
		bottom.x -= (100 * delta);
		setPosition(new Vector2(bottom.x, bottom.y));
	}
	
	public void moveRight(float delta){
			bottom.x += (100 * delta);
			setPosition(new Vector2(bottom.x, bottom.y));
		}
		
	public void moveUp(float delta){
		bottom.y += (100 * delta);
		setPosition(new Vector2(bottom.x, bottom.y));
	}
	
	public void moveDown(float delta){
		bottom.y -= (100 * delta);
		setPosition(new Vector2(bottom.x, bottom.y));
	}

	
}
//change