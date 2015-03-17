package com.bhonzo.shooter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


@SuppressWarnings("unused")
public class Player extends Soldier {
		Rectangle 				bottom, left, right, top, full;
		Sprite 					sprite;
		Texture 				texture;
		
		private Vector2 velocity = new Vector2();
		private Vector2 newPos = new Vector2();
		private float speed = 60 * 2;
		private float gravity = 60 * 1.8f;
		private TiledMapTileLayer collisionLayer;

	public Player(float health, TiledMapTileLayer collisionLayer) {
		super(health);
		bottom 	= 	new Rectangle(0, 0, 64, 8);
		sprite 	= 	new Sprite(new Texture("enemy.png"));	
		this.collisionLayer = collisionLayer;
		
		
	}	
	
	public void draw(Batch batch){
		update(Gdx.graphics.getDeltaTime());
		sprite.draw(batch);
	}
	
	public void update(float delta) {
		

		// apply gravity
		velocity.y -= gravity * delta;
		// clamp velocity
		if(velocity.y > speed){
			velocity.y = speed;
			}
		else if(velocity.y < -speed){
			velocity.y = -speed;
			}
		// save old positions
		float oldX = getX();
		float oldY = getY();
		float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
		
		boolean collisionX = false, collisionY = false;
		
		
		// move on x
		setX(getX() + velocity.x * delta);
		
		if(velocity.x < 0){
			// top left
			collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int)((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			// middle left
			if(!collisionX)
				collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int)((getY() + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			// bottom left
			if(!collisionX)
				collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int)(getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
		}
		else if(velocity.x > 0){
			// top right
			collisionX = collisionLayer.getCell((int) ((getX() + getWidth() / tileWidth)), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			// middle right
			if(!collisionX)
				collisionX = collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int)((getY() + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");
			// bottom right
			if(!collisionX)
				collisionX = collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
		}
		
		//react to x collision
		if(collisionX){
			setX(oldX);
			velocity.x=0;
		}
			
		
		//move on y
		setY(getY() + velocity.y * delta);	
		
		if(velocity.y < 0){
			//bottom left
			collisionY = collisionLayer.getCell((int) ((getX() / tileWidth)), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
			//bottom middle
			if(!collisionY)
				collisionY = collisionLayer.getCell((int) ((getX() + getWidth() / 2) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
			//bottom right
			if(!collisionY)
				collisionY = collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");				
			}
		else if(velocity.y > 0){
			//top left
			collisionY = collisionLayer.getCell((int) ((getX()) / tileWidth), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			
			// top middle
			if(!collisionY)
				collisionY = collisionLayer.getCell((int) ((getX() + getWidth() / 2) / tileWidth ), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
		
			// top right
			if(!collisionY)
				collisionY = collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth ), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
		}
		
				//react to Y collision
				if(collisionY){
					setY(oldY);
					velocity.y=0;
				}				
	}
	
	public void setPosition(float x, float y) {
		bottom.x = 	x;
		bottom.y = 	y;
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

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public TiledMapTileLayer getCollisionLayer() {
		return collisionLayer;
	}

	public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
		this.collisionLayer = collisionLayer;
	}

	
	
}
