package com.bhonzo.shooter;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class ShooterMain extends ApplicationAdapter implements InputProcessor {
	
			SpriteBatch 							batch;
			TiledMap 								tiledMap;
		    OrthographicCamera 						camera;
		    TiledMapRenderer 						tiledMapRenderer;    
		    Enemy 									enemyTest ;
		    Sprite 									enemySprite ; 
		    
		    private Player 							player1;
		    private ArrayList<GameObject> list = 	new ArrayList<GameObject>();
			
@Override
public void create () {
	
		float w 	= 		Gdx.graphics.getWidth();
	    float h 	= 		Gdx.graphics.getHeight();		
		camera	 	= 		new OrthographicCamera();
		batch 		= 		new SpriteBatch();			 
		player1 	= 		new Player(100);  				//Create new player
        
		
		camera.setToOrtho(false,w,h);						//Set camera position
		player1.setPosition(200,100);						//Set player position
		
		// add some test blocks to interact with
		list.add(new Brick(0,0));
		list.add(new Brick(64,0));
		list.add(new Brick(128,0));
		list.add(new Brick(256,128));
		list.add(new Brick(320,128));		    
        
        camera.update();
        
        tiledMap 			= 		new TmxMapLoader().load("level1map.tmx");
        tiledMapRenderer 	= 		new OrthogonalTiledMapRenderer(tiledMap);
        
		//to listen to user input 
		Gdx.input.setInputProcessor(this);	
		
		//create a test enemy
		enemyTest 			= 		new Enemy(100,30);
		enemySprite 		= 		new Sprite(new Texture("enemy.png"));
		
		enemyTest.setPosition(new Vector2(w/2,h/2));		//Set enemy position
		
	
}

@Override
public void render () {
	
	   float ds 	= 		Gdx.graphics.getDeltaTime();
	
	   Gdx.gl.glClearColor(1, 0, 0, 1);
	   Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	   camera.update();
	
	   tiledMapRenderer.setView(camera);
	   tiledMapRenderer.render();
    
	   enemyTest.update(ds);	    
	   batch.setProjectionMatrix(camera.combined);		   
	    
	   batch.begin();	
		
		for(GameObject t : list){
			t.draw(batch);
		}
	
	
		player1.draw(batch); 
		enemySprite.setPosition(enemyTest.getPosition().x, enemyTest.getPosition().y);
		enemySprite.setRotation(enemyTest.getHeading().angle());
		enemySprite.draw(batch);
		batch.end();
	
	
	//Updates
		player1.update(Gdx.graphics.getDeltaTime());
		
		Rectangle temp 		= 		new Rectangle(0,0, Gdx.graphics.getWidth(),5);
	
	if(player1.hits(temp) != -1){
		    player1.action(1, 0 , 10);
	}
	
	for (GameObject t : list){
		switch (player1.hits(t.getHitBox())){
		case 1:
			player1.action(1, 0, t.getHitBox().y + t.getHitBox().height);
			break;
		//case 2:
			//player1.action(2, t.getHitBox().x + t.getHitBox().width + 1, 0);
			//player1.action(2, t.getHitBox().x + t.getHitBox().width + 2, 0);
			//break;
		//case 3:
			//player1.action(3, t.getHitBox().x - player1.getHitBox().width - 2,0);
			//break;
		//case 4:
			//player1.action(4,0, t.getHitBox().y - player1.getHitBox().height);
		}
	}
	
		//Controls
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			player1.moveLeft(Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			player1.moveRight(Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			player1.moveDown(Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			player1.moveUp(Gdx.graphics.getDeltaTime());
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
			if(Gdx.input.isKeyPressed(Input.Keys.A)){
				player1.moveLeft(Gdx.graphics.getDeltaTime()*1.35f);
			}
			if(Gdx.input.isKeyPressed(Input.Keys.D)){
				player1.moveRight(Gdx.graphics.getDeltaTime()*1.35f);
			}
			if(Gdx.input.isKeyPressed(Input.Keys.S)){
				player1.moveDown(Gdx.graphics.getDeltaTime()*1.35f);
			}
			if(Gdx.input.isKeyPressed(Input.Keys.W)){
				player1.moveUp(Gdx.graphics.getDeltaTime()*1.35f);
			}
			//player1.moveUp(Gdx.graphics.getDeltaTime());
		}
	}

@Override
public boolean keyDown(int keycode) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean keyUp(int keycode) {
	// TODO Auto-generated method stub
	 if(keycode == Input.Keys.LEFT)
            camera.translate(-32,0);
        if(keycode == Input.Keys.RIGHT)
            camera.translate(32,0);
        if(keycode == Input.Keys.UP)
            camera.translate(0,-32);
        if(keycode == Input.Keys.DOWN)
            camera.translate(0,32);
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
