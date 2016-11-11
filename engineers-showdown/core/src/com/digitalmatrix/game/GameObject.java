package com.digitalmatrix.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public abstract class GameObject{
	
	Body body;

	public GameObject(World world, BodyDef def) {
		body = world.createBody(def);
	}

	int zRender = 0;
	
	public Vector2 getPosition(){
		return body.getWorldCenter();
	}
	
	public void setPositon(Vector2 position){
		body.getTransform().setPosition(position);
	}
	
	public abstract void update(float delta);
	
	public abstract void render(SpriteBatch batch);

}
