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
		//Vector2 				playerPosition = new Vector2();
		Sprite 					sprite;
		//Texture 				texture;
		
		private Vector2 velocity = new Vector2();
		private Vector2 newPos = new Vector2();
		private float speed = 60 * 2;
		private float gravity = 0;
		private float resistance = 0.2f;
		private TiledMapTileLayer collisionLayer;

	public Player(float health, TiledMapTileLayer collisionLayer) {
		super(health);
		
		
		
		sprite 	= 	new Sprite(new Texture("enemy.png"));	
		this.collisionLayer = collisionLayer;
		
		
	}	
	
	public void draw(Batch batch){
		update(Gdx.graphics.getDeltaTime());
		sprite.setPosition(getPosition().x, getPosition().y);
		sprite.draw(batch);
	}
	
	public void update(float delta) {	
		// apply gravity
		//velocity.y -= gravity * delta;
		// clamp velocity
		if(velocity.y > speed)
		{
			velocity.y = speed;
		}
		else if(velocity.y < -speed)
		{
			velocity.y = -speed;
		}
		// save old positions
		float oldX = getPosition().x;
		float oldY = getPosition().y;
		
		float tileWidth = collisionLayer.getTileWidth();
		float tileHeight = collisionLayer.getTileHeight();
		
		boolean collisionX = false, collisionY = false;
		// move on x
		setPositionX(getPosition().x + velocity.x * delta);
		setPositionY(getPosition().y + velocity.y * delta);
		velocity.x = velocity.x * resistance;
		velocity.y = velocity.y * resistance;
		/*
		if(velocity.x < 0){
			// top left			
			collisionX = collisionLayer.getCell((int) (playerPosition.x / tileWidth), (int)((playerPosition.y + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
						 
			if(collisionX){
			System.out.println("you hit a wall top left");}
			// middle left
			if(!collisionX){
				collisionX = collisionLayer.getCell((int) (playerPosition.x / tileWidth), (int)((playerPosition.y + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");
				System.out.println("you hit a wall middle left");}
			// bottom left
			if(!collisionX){
				collisionX = collisionLayer.getCell((int) (playerPosition.x / tileWidth), (int)(playerPosition.y / tileHeight)).getTile().getProperties().containsKey("blocked");
				System.out.println("you hit a wall bottom left");}
		}	
		else if(velocity.x > 0){
			// top right
			collisionX = collisionLayer.getCell((int) ((playerPosition.x + getWidth() / tileWidth)), (int) ((playerPosition.y + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			if(collisionX){
				System.out.println("you hit a wall top right");}
			// middle right
			if(!collisionX){
				collisionX = collisionLayer.getCell((int) ((playerPosition.x + getWidth()) / tileWidth), (int)((playerPosition.y + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");
			System.out.println("you hit a wall middle right");}
			// bottom right
			if(!collisionX){
				collisionX = collisionLayer.getCell((int) ((playerPosition.x + getWidth()) / tileWidth), (int) (playerPosition.y / tileHeight)).getTile().getProperties().containsKey("blocked");
			System.out.println("you hit a wall bottom right");}
		}
		
		//react to x collision
		if(collisionX){
			playerPosition.set(oldX, oldY);
			velocity.x = 0;
		}
			
		
		//move on y
		setY(getY() + velocity.y * delta);	
		
		if(velocity.y < 0){
			//bottom left
			collisionY = collisionLayer.getCell((int) ((playerPosition.x / tileWidth)), (int) (playerPosition.y / tileHeight)).getTile().getProperties().containsKey("blocked");
			if(collisionY){
				System.out.println("you hit a wall bottom left");}
			//bottom middle
			if(!collisionY){
				collisionY = collisionLayer.getCell((int) ((playerPosition.x + getWidth() / 2) / tileWidth), (int) (playerPosition.y / tileHeight)).getTile().getProperties().containsKey("blocked");
				System.out.println("you hit a wall bottom middle");}
			//bottom right
			if(!collisionY){
				collisionY = collisionLayer.getCell((int) ((playerPosition.x + getWidth()) / tileWidth), (int) (playerPosition.y / tileHeight)).getTile().getProperties().containsKey("blocked");
				System.out.println("you hit a wall bottom right");}
			}
		else if(velocity.y > 0){
			//top left
			collisionY = collisionLayer.getCell((int) ((playerPosition.x) / tileWidth), (int) ((playerPosition.y + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
			System.out.println("you hit a wall top left");			
			// top middle
			if(!collisionY){
				collisionY = collisionLayer.getCell((int) ((playerPosition.x + getWidth() / 2) / tileWidth ), (int) ((playerPosition.y + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
				System.out.println("you hit a wall top middle");}	
			// top right
			if(!collisionY){
				collisionY = collisionLayer.getCell((int) ((playerPosition.x + getWidth()) / tileWidth ), (int) ((playerPosition.y + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
				System.out.println("you hit a wall top right");}
		}
		
				//react to Y collision
				if(collisionY){
					setY(oldY);
					velocity.y=0;
				}	*/			
	}
	
	
	public void moveLeft(float delta){
		velocity.x -= (100);
	}
	
	public void moveRight(float delta){
			velocity.x += (100);
		}
		
	public void moveUp(float delta){
		velocity.y += (100);	
	}
	
	public void moveDown(float delta){
		velocity.y -= (100);	
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
