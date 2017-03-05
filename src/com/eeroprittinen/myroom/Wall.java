package com.eeroprittinen.myroom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**represents a wall of a room**/
public class Wall {

	Sprite sprite;
	
	float imgWidth=10/(float)Math.sqrt(5);
	float imgHeight=10/(float)Math.sqrt(5);//not really needed
	
	//TODO maybe generic wall object/item?
	Door door=null;//default no door
	
	//TODO generic wall objects implementation(for example wall safe, painting, light switch etc..)
	
	
	
	Wall(String f){
		sprite = new Sprite( new Texture( Gdx.files.internal(f)) );
		imgHeight=imgWidth*sprite.getHeight()/sprite.getWidth();
		sprite.setSize(imgWidth, imgHeight);
	}
	
	
	
	/**add a ready made door to a wall**/
	void setDoor(Door d){
		door=d;
	}
	/**create a door to a certain point on the wall**/
	void setDoor(float position){
		door=new Door(position, "assets/door_generic.png");//default door picture
	}
	/**create a door with desired image**/
	void setDoor(float position, String f){
		door=new Door(position, f);
	}
	
	
	
	/**updates all attached objects sprites to right position**/
	void updateSprites(){
		//TODO generic wall objects update
		if(door!=null)
			door.sprite.setPosition(Isometric.toIsoX(0, door.position),Isometric.toIsoY(0, door.position));
	}
	
	/**returns true if the room has a door*/
	boolean hasDoor(){
		return (door!=null);
	}
}