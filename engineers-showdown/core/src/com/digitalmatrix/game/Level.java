package com.digitalmatrix.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Level{

	World world;
	Box2DDebugRenderer b2dr;
	Player player;
	ArrayList<GameObject> objects;
	OrthographicCamera camera;
	int ID;
	
	public Level(OrthographicCamera camera){
		this.camera = camera;
	}
	
	public void init(Player player, World world){
		objects = new ArrayList<GameObject>();
		this.world = world;
		this.player = player;
		b2dr = new Box2DDebugRenderer();
		player.setCamera(camera);
		objects.add(player);
	}
	
	public static void insertionSort(GameObject[] array){
		for (int i = 0; i < array.length; i++){
			GameObject a = array[i];
				for (int j = i - 1; j >= 0 && array[j].zRender > a.zRender; j--){
					array[j + 1] = array[j];
					array[j] = a;
				}                       
		}               
   }
	
	public void update(float delta){
//		GameObject[] gos = new GameObject[objects.size()];
//		objects.toArray(gos);
//		insertionSort(gos);
		
		Collections.sort(objects, new Comparator<GameObject>(){
			public int compare(GameObject a, GameObject b) {
				return a.zRender - b.zRender;
			}
			
		});
		
		for(int i = objects.size() - 1; i >= 0; i --){
			objects.get(i).update(delta);
		}
		
		world.step(1/60f, 6, 2);
	}
	public void render(SpriteBatch batch){
		for(int i = objects.size() - 1; i >= 0; i --){
			objects.get(i).render(batch);
		}
		camera.zoom = 1f/45f;
		b2dr.render(world, camera.combined);
		
	}
	
	public void dispose(){
		world.dispose();
		b2dr.dispose();
	}

}
