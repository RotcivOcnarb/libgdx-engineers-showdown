package com.digitalmatrix.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StatesManager {
	
	ArrayList<State> states;
	int currentState = 0;
	OrthographicCamera camera;
	
	public StatesManager(OrthographicCamera camera){
		this.camera = camera;
		states = new ArrayList<State>();
		states.add(new Game(camera));
		init();
	}
	
	public void changeState(int state){
		currentState = state;
		init();
	}
	
	public void init(){
		states.get(currentState).init();
	}
	
	public void update(float delta){
		states.get(currentState).update(delta);
	}
	
	public void render(SpriteBatch batch){
		states.get(currentState).render(batch);
	}
	
	public void dispose(){
		states.get(currentState).dispose();
	}

}