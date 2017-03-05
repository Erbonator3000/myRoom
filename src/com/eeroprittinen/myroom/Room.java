package com.eeroprittinen.myroom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**Represents a single room of the map**/
public class Room {

	
	float width = 5; //default room size
	float height = 5;
	
	//pixel size 1024x512
	float imgWidth=20/(float)Math.sqrt(5);
	float imgHeight=10/(float)Math.sqrt(5);//not really needed
	
	Wall wall1=null;//default walls: no walls
	Wall wall2=null;
	
	Sprite floor;
	
	Room(String f){
		floor = new Sprite( new Texture( Gdx.files.internal(f)) );
		//to keep the original aspect ratio
		imgHeight=imgWidth*floor.getHeight()/floor.getWidth();
		floor.setSize(imgWidth, imgHeight);
		wall1=new Wall("assets/wall_generic.png");
		wall2=new Wall("assets/wall_generic.png");
		wall2.sprite.flip(true, false);
	}
	
	
	
}