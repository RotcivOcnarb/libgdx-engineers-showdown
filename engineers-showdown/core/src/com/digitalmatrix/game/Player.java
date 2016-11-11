package com.digitalmatrix.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends GameObject{
	
	OrthographicCamera camera;
	
	public Player(World world, BodyDef def) {
		super(world, def);
		body.setUserData(this);
		
		CircleShape circ = new CircleShape();
		circ.setRadius(32/MainComponent.SCALE);
		body.createFixture(circ, 1);
		body.setLinearDamping(10);
		circ.dispose();
	}

	public void setCamera(OrthographicCamera camera){
		this.camera = camera;
	}
	
	public void update(float delta){
		input();
		camera.position.set(getPosition(), 0);
	}
	
	public void input(){
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			body.applyForceToCenter(new Vector2(0, 80*body.getMass()), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			body.applyForceToCenter(new Vector2(0, -80*body.getMass()), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
			body.applyForceToCenter(new Vector2(80*body.getMass(), 0), true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			body.applyForceToCenter(new Vector2(-80*body.getMass(), 0), true);
		}
	}
	
	public void render(SpriteBatch batch){
		
	}
}
