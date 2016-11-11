package com.digitalmatrix.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {
	
	OrthographicCamera camera;
	public State(OrthographicCamera camera){
		this.camera = camera;
	}
	
	public abstract void init();
	public abstract void update(float delta);
	public abstract void render(SpriteBatch batch);
	public abstract void dispose();

}
