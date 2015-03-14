package com.bhonzo.shooter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


@SuppressWarnings("unused")
public class Player extends Soldier {
	Rectangle bottom, left, right, top, full;
	Sprite sprite;
	Texture texture;
	int action;
	float velocityY;
	int direction = 0;

	public Player(float health) {
		super(health);
		
		full   = new Rectangle(0, 0, 128, 128);
		
		bottom = new Rectangle(0, 0, 64, 8);
		left   = new Rectangle(0, 16, 32, 48);
		right  = new Rectangle(32, 16, 32, 48);
		top    = new Rectangle(0, 48, 64, 8);
		
		//texture = new Texture(Gdx.files.internal("enemy.png"));
		sprite = new Sprite(new Texture("enemy.png"));			
		this.setPosition(0,0);	
	}

	public int hits(Rectangle r) {
		if (left.overlaps(r)) {
			return 2;
		}
		if (right.overlaps(r)) {
			return 3;
		}
		
		if(bottom.overlaps(r)) {
			return 1;
		}
		
		if (top.overlaps(r)) {
			return 4;
		}

		return -1;
	}
	
	public void action(int type, float x, float y) {
		
		if (type == 1 || type == 4) {
			velocityY = 0;
			setPosition(bottom.x, y);
		}
		
		if (type == 2 || type == 3) {
			velocityY = 0;
			setPosition(x, bottom.y);
		}		

	}
	
	public void update(float delta) {
		velocityY -= 0;
		bottom.y += velocityY;
		sprite.setPosition(bottom.x,bottom.y);
	}
	
	
	public void setPosition(float x, float y) {
		full.x  = x;
		full.y  = y;
		
		bottom.x = x;
		bottom.y = y;

		left.x = x;
		left.y = y + 16;
		
		right.x = x + 32;
		right.y = y + 16;
		
		top.x = x;
		top.y = y + 56;
		
		sprite.setPosition(x, y);
	}
	
	public void moveLeft(float delta){
		bottom.x -= (100 * delta);
		sprite.setPosition(bottom.x, bottom.y);		
	}
	
	public void moveRight(float delta){
			bottom.x += (100 * delta);
			sprite.setPosition(bottom.x, bottom.y);		
		}
		
	public void moveUp(float delta){
		bottom.y += (100 * delta);
		sprite.setPosition(bottom.x, bottom.y);
	}
	
	public void moveDown(float delta){
		bottom.y -= (100 * delta);
		sprite.setPosition(bottom.x, bottom.y);		
	}

	public void draw(SpriteBatch batch){
		sprite.draw(batch);
	}
	
	public Rectangle getHitBox(){
		return full;
	}
	
	public int hitAction(int side) {
		// TODO Auto-generated method stub
		return 0;
	}
}
//change