package com.bhonzo.shooter;

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
import com.badlogic.gdx.math.Vector2;

public class ShooterMain extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	//Texture img;
	TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    
    Enemy enemyTest ;
    Sprite enemySprite ; 
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
	//
		 float w = Gdx.graphics.getWidth();
	        float h = Gdx.graphics.getHeight();

	        camera = new OrthographicCamera();
	        camera.setToOrtho(false,w,h);
	        camera.update();
	        tiledMap = new TmxMapLoader().load("level1map.tmx");
	        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		  
		
		//to listen to user inoput 
		Gdx.input.setInputProcessor(this);
		
		
		
		//
		enemyTest = new Enemy(100,30);
		enemyTest.setPosition(new Vector2(w/2,h/2));
		enemySprite = new Sprite(new Texture("enemy.png"));
		
	}

	@Override
	public void render () {
		float ds = Gdx.graphics.getDeltaTime();
		enemyTest.update(ds);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 camera.update();
	        tiledMapRenderer.setView(camera);
	        tiledMapRenderer.render();
		batch.begin();
	//	batch.draw(img, 0, 0);
		
		// draw sum srrites 
		enemySprite.setPosition(enemyTest.getPosition().x, enemyTest.getPosition().y);
		enemySprite.setRotation(enemyTest.getHeading().angle());
		enemySprite.draw(batch);
		
		batch.end();
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
