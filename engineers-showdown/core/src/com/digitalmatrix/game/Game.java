package com.digitalmatrix.game;


import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.digitalmatrix.game.levels.Hangar01;

public class Game extends State {
	
	public Game(OrthographicCamera camera) {
		super(camera);
	}

	ArrayList<Level> levels;
	int currentLevel = 0;
	Player player;
	
	public void init() {
		levels = new ArrayList<Level>();
		levels.add(new Hangar01(camera));
		World world = new World(new Vector2(0, 0), false);
		
//		BodyDef wall = new BodyDef();
//		wall.type = BodyDef.BodyType.StaticBody;
//		wall.position.set(1280/2, 720/2);

//		Body w = world.createBody(wall);
//		PolygonShape ps = new PolygonShape();
//		ps.setAsBox(200/MainComponent.SCALE, 30/MainComponent.SCALE);
//		w.createFixture(ps, 1f);
//		ps.dispose();

		BodyDef playerDef = new BodyDef();
		
		playerDef.type = BodyDef.BodyType.DynamicBody;
		playerDef.position.set(1280/2, 720/2);
		playerDef.fixedRotation = true;		
		player = new Player(world, playerDef);
		
		levels.get(currentLevel).init(player, world);
	}

	public void update(float delta) {
		levels.get(currentLevel).update(delta);
	}

	public void render(SpriteBatch batch) {
		levels.get(currentLevel).render(batch);
	}

	public void dispose() {
		levels.get(currentLevel).dispose();
	}

}
