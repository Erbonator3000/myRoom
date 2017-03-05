package com.eeroprittinen.myroom;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.eeroprittinen.myroom.Character.Brain;
import com.eeroprittinen.myroom.Character.DestinationBrain;
import com.eeroprittinen.myroom.Character.MainCharacter;
import com.eeroprittinen.myroom.Character.TrackFollowBrain;

public class MyRoom extends ApplicationAdapter {
	
	SpriteBatch batch;
	OrthographicCamera camera;
	
	
	Map map;
	Room[][] rooms;
	
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(15,15);
		camera.position.set(3, 3, 0);
		camera.update();
		
		rooms = new Room[][]{//the rooms go here		
		{ new Room("assets/floor_generic.png"), new Room("assets/floor_generic.png") },
		{ new Room("assets/floor_generic.png"), new Room("assets/floor_generic.png") }
		};
		
		rooms[1][0].wall1.setDoor(4);
		map = new Map(rooms);
		map.mainCharacter = new MainCharacter("assets/character1_generic.png", 3, 5);
		map.mainCharacter.moveTo(new Vector2(10,10));
		DestinationBrain brain = new DestinationBrain(map.mainCharacter, map);
		map.mainCharacter.addBrain(brain);
		brain.setSpeed(0.07f);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		handleInput();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		map.mainCharacter.brain.performStep();
		
		//drawing floors
		map.drawFloors(batch);
		map.drawWalls(batch);
		map.drawCharacters(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
	
	
	void handleInput(){
		 if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			 camera.position.add(-0.1f, 0, 0);
	     }if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			 camera.position.add(0.1f, 0, 0);
	     }if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			 camera.position.add(0, 0.1f, 0);
	     }if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			 camera.position.add(0, -0.1f, 0);
	     }if (Gdx.input.isKeyPressed(Input.Keys.X)) {
			 camera.zoom+=0.01;
	     }if (Gdx.input.isKeyPressed(Input.Keys.C)) {
	    	 camera.zoom-=0.01;
	     }
	     if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
	    	 Vector3 tmp = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
	    	 camera.unproject(tmp);
	    	 map.mainCharacter.brain.setDestination(new Vector2(Isometric.fromIsoX(tmp.x, tmp.y),
	    			 Isometric.fromIsoY(tmp.x, tmp.y)));
	    	 
	     }
		 
		
		
	}
}