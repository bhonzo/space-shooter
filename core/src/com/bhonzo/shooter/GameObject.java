package com.bhonzo.shooter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
// Basic test template for game objects I am trying out
public abstract class GameObject {
			public abstract int 		hits(Rectangle r);
			public abstract void 		action(int type, float x, float y);
			public abstract void 		update(float delta);
			public abstract void 		setPosition(float x, float y);
			public abstract void 		moveLeft(float delta);
			public abstract void 		moveRight(float delta);
			public abstract void 		moveUp(float delta);
			public abstract void 		moveDown(float delta);
			public abstract void 		draw(SpriteBatch batch);
			public abstract Rectangle 	getHitBox();
			public abstract int 		hitAction(int side);
}
